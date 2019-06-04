import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/***
 *
 * @author zhengchunguang
 * @date 2019-06-04 16:01
 * 自己实现的阻塞队列
 */
public class MyArrayBlockingQueue {
    /**
     * 容量
     */
    private int capacity;
    /**
     * 底层数组
     */
    private Integer[] array = null;

    private Lock lock = new ReentrantLock();

    private Condition notFull =  lock.newCondition();

    private Condition notEmpty =  lock.newCondition();
    /**
     * 队列中存的item的数量
     */
    private Integer count = 0;

    public MyArrayBlockingQueue(int capacity) {
        this.capacity = capacity;
        array = new Integer[capacity];
    }

    /**
     * 存放item
     * @param item
     */
    public void put(Integer item){
        lock.lock();
        try {
            while (count == this.capacity){
                System.out.println("队列已满,count:"+count);
                notFull.await();
            }
            count++;
            array[count-1] = item;
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }

    }

    /**
     * 获取值
     * @return
     */
    public Integer take(){
        Integer result = null;
        lock.lock();
        try {
            while (count == 0){
                System.out.println("队列是空的");
                notEmpty.await();
            }
            int index = count - 1;
            result = array[index];
            array[index] = null;
            count--;
            notFull.signal();
            return result;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return null;
    }

    public static void main(String[] args) {
        MyArrayBlockingQueue queue = new MyArrayBlockingQueue(10);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Random random = new Random();
        executor.submit(()->{
            while(true){
                queue.put(random.nextInt(10));
            }
        });
        executor.submit(()->{
            while(true){
                System.out.println(queue.take());
            }
        });
    }
}
