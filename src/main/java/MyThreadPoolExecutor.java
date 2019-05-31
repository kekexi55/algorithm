import java.util.HashSet;
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
    private long keepAlivedTime;
    /**
     * 时间单位
     */
    private TimeUnit timeUnit;
    /**
     * 保存现有线程
     */
    private HashSet<Thread> workerSet;
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
    private int state;

    public MyThreadPoolExecutor(int minSize, int maxSize, BlockingQueue queue, long keepAlivedTime, TimeUnit timeUnit) {
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.taskQueue = queue;
        this.keepAlivedTime = keepAlivedTime;
        this.timeUnit = timeUnit;
    }

    private class Worker extends Thread{
        private Runnable task;

        private Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            try {
                while(task != null ||(task = getTask()) != null){
                    task.run();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

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
            task = taskQueue.poll(keepAlivedTime,timeUnit);
        }else{
            task = taskQueue.take();
        }
        return task;
    }

    /**
     * 提交任务
     * @param task
     */
    public void submit(Runnable task) throws InterruptedException {
        //不是运行状态
        if(state != 0){
            return;
        }
        if(workerSize.get() <= minSize){
            addWorker(task);
            workerSize.getAndAdd(1);
            return;
        }
        if(workerSize.get() <= maxSize && taskQueue.size() <= MAX_SIZE){
            taskQueue.put(task);
            return;
        }
        if(workerSize.get() <= maxSize){
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

    }

}
