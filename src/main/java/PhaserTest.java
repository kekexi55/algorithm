import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.Phaser;

/***
 *
 * @author zhengchunguang
 * @date 2019-11-26 13:47
 * 测试Phaser类
 */
public class PhaserTest {
    public static void main(String[] args) {
        System.out.println("all is done");
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.systemDefault());
        LocalDateTime max = localDateTime.with(LocalTime.MAX);
        DateTimeFormatter  dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strDateTime = dateTimeFormatter.format(max);
        System.out.println(strDateTime);
        LocalDateTime localDateTime1 = LocalDateTime.parse(strDateTime,dateTimeFormatter);
        long timeTillis = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println(timeTillis);
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(date);

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
