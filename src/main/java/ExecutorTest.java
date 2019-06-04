import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 *
 * @author zhengchunguang
 * @date 2019-06-04 11:16
 */
public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.shutdown();
    }
}
