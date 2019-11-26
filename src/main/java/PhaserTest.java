import java.util.concurrent.Phaser;

/***
 *
 * @author zhengchunguang
 * @date 2019-11-26 13:47
 * 测试Phaser类
 */
public class PhaserTest {
    public static void main(String[] args) {
        int count = 20;
        Phaser phaser = new Phaser(count);
//        phaser.register();
        for (int i = 0; i < count; i++) {
            InnerThread innerThread = new InnerThread(phaser);
            Thread thread = new Thread(innerThread);
            thread.start();
        }
//        phaser.arriveAndAwaitAdvance();
        System.out.println("all is done");
    }
    private static class InnerThread implements Runnable{
        Phaser phaser;

        private InnerThread(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
//            phaser.register();

            System.out.println(Thread.currentThread().getName() + " done and wait ");
            phaser.arriveAndAwaitAdvance();
//            phaser.arriveAndDeregister();
            System.out.println(Thread.currentThread().getName() + "go on");
        }

    }
}
