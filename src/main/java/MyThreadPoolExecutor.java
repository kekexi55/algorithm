import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/***
 *
 * @author zhengchunguang
 * @date 2019-05-30 16:23
 * 简易的线程池
 */
public class MyThreadPoolExecutor {

    /**
     * 最少线程数
     */
    private int minSize;
    /**
     * 最大线程数
     */
    private int maxSize;
    /**
     * 阻塞队列,存储任务
     */
    private BlockingQueue<Runnable> taskQueue;
    /**
     * 线程保持时间
     */
    private long keepAliveTime;
    /**
     * 时间单位
     */
    private TimeUnit timeUnit;
    /**
     * 保存现有线程
     */
    private HashSet<Thread> workerSet = new HashSet<>(8);
    /**
     * 阻塞队列的最大值
     */
    private static final int MAX_SIZE =  16;
    /**
     * worker的数量
     */
    private static final AtomicInteger workerSize = new AtomicInteger();
    /**
     * 线程池的状态  0 ：RUNNING
     *             1 ：TERMINATED
     *             2 ：STOPPED
     */
    private int state = 0;

    public MyThreadPoolExecutor(int minSize, int maxSize, BlockingQueue queue, long keepAliveTime, TimeUnit timeUnit) {
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.taskQueue = queue;
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
    }

    private class Worker extends Thread{
        private Runnable task;

        private Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            while(true){
                try {
                    if (task == null && (task = getTask()) == null){
                        break;
                    }else{
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    task = null;
                }
            }

        }

    }

    /**
     * 获取task
     * @return
     */
    private Runnable getTask() throws InterruptedException {
        if(state != 0){
            return null;
        }
        Runnable task  = null;
        if(workerSet.size() > minSize){
            task = taskQueue.poll(keepAliveTime,timeUnit);
        }else{
            task = taskQueue.take();
        }
        return task;
    }

    /**
     * 提交任务
     * @param task
     */
    public void submit(Runnable task) {
        //不是运行状态
        if(state != 0){
            return;
        }
        if(workerSize.get() <= minSize){
            addWorker(task);
            workerSize.getAndAdd(1);
            System.out.println("小于核心线程数");
            return;
        }
        if(taskQueue.remainingCapacity() >1){
            System.out.println("核心线程数已满，开始往队列中放任务");
            taskQueue.offer(task);
            return;
        }
        if(workerSize.get() <= maxSize){
            System.out.println("队列已满，增加线程数");
            addWorker(task);
            workerSize.getAndAdd(1);
        }
    }

    /**
     * 停止线程池
     */
    public void shutdown(){
        state = 1;
        if(taskQueue.size() == 0){
            for (Thread thread : workerSet) {
                thread.interrupt();
            }
        }

    }

    /**
     * 立即停止线程池
     */
    public void shutdownNow(){
        state = 2;
        for (Thread thread : workerSet) {
            thread.interrupt();
        }
        workerSet = null;
        taskQueue = null;
    }

    private void addWorker(Runnable task) {
        Worker worker = new Worker(task);
        workerSet.add(worker);
        worker.start();
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        MyThreadPoolExecutor executor  = new MyThreadPoolExecutor(1,3,new ArrayBlockingQueue(8),10,TimeUnit.SECONDS);
        executor.submit(()->{
            System.out.println("111");
        });
        executor.submit(()->{
            System.out.println("222");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.submit(()->{
            System.out.println("333");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.submit(()->{
            System.out.println("444");
        });
        executor.submit(()->{
            System.out.println("555");
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.submit(()->{
            System.out.println("666");
        });
        executor.submit(()->{
            System.out.println("777");
        });

    }

}
