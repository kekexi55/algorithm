import java.util.concurrent.CountDownLatch;

/***
 *
 * @author zhengchunguang
 * @date 2019-06-11 15:10
 *  countdownlatch测试
 */
public class CTLTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread thread1 =  new Thread(new MyThread(countDownLatch));
        Thread thread2 =  new Thread(new MyThread(countDownLatch));
        thread1.start();
        thread2.start();
        try {
            System.out.println("start");
            countDownLatch.await();
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static class MyThread  implements   Runnable{
        private CountDownLatch countDownLatch;

        public MyThread(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
