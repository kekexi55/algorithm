/***
 *
 * @author zhengchunguang
 * @date 2019-10-06 11:26
 * 兑换硬币
 */
public class CoinChange {
    /**
     * 硬币的种类
     */
    public static int[]coins = new int[]{1,2,5};

    public static int num(int amount){
        int ans[] = new int[amount+1];
        for (int coin : coins) {
            if(coin > amount){
                continue;
            }
            ans[coin] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            if(ans[i] != 0){
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if(i - coin < 0 || ans[i-coin] == 0){
                    continue;
                }
                min = Math.min(min,ans[i-coin] + 1);
            }
            ans[i] = min == Integer.MAX_VALUE?0:min;
        }
        return ans[amount];
    }

    public static void main(String[] args) {
        System.out.println(num(3));
    }
}
