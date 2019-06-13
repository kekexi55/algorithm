import java.util.concurrent.*;

/***
 *
 * @author zhengchunguang
 * @date 2019-06-13 14:33
 */
public class FastCache {
    private ConcurrentHashMap<Integer, FutureTask<Integer>> cache = new ConcurrentHashMap<>();
    private final Computable computor;

    public FastCache(Computable computor) {
        this.computor = computor;
    }

    public Integer getResult(int inbound){
        if(this.cache.get(inbound) == null){
            FutureTask task = new FutureTask<Integer>(()->{
                return this.computor.compute(inbound);
            });
            task.run();
            cache.putIfAbsent(inbound,task);
        }
        FutureTask<Integer> result = this.cache.get(inbound);
        try {
            return result.get(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
            result.cancel(true);
        }
        return null;
    }

    private interface Computable{
        Integer compute(int inbound);
    }

    private class MyComputor implements Computable{

        @Override
        public Integer compute(int inbound) {
            return 1;
        }
    }
}
