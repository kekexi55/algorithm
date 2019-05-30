import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

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

    private class Worker implements Runnable{
        private Runnable task;

        private Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            Runnable theTask = task;
            while(true){
                if(theTask !=  null){
                    theTask.run();
                }else{
                    try {
                        theTask = (Runnable) taskQueue.take();
                        if(theTask == null){
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                theTask  = null;
            }

        }

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
        if(workerSet.size() <= minSize){
            addWorker(task);
            return;
        }
        if(taskQueue.size() <= MAX_SIZE){
            taskQueue.put(task);
            return;
        }
        if(workerSet.size() <= maxSize){
            addWorker(task);
        }
    }

    /**
     * 停止线程池
     */
    public void shutdown(){
        state = 1;

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

    }

    private void addWorker(Runnable task) {
        Worker worker = new Worker(task);
        new Thread(worker).start();
//        workerSet.add(worker);
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {

    }

}
