import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/***
 *
 * @author zhengchunguang
 * @date 2020/1/3
 */
public class TestMy {
    public static void main(String[] args) {
//        for (int j = 0; j < 100; j++) {
            test();
//        }
    }

    public static int test(){
//        int totalBase = 100;
//        int random = new Random().nextInt(totalBase);
//        List<String> returnMultiple = new ArrayList<String>();
//        returnMultiple.add("10");
//        returnMultiple.add("15");
//        returnMultiple.add("20");
//        returnMultiple.add("30");
//        returnMultiple.add("50");
//        List<String> returnProbability = new ArrayList<String>();
//        returnProbability.add("50");
//        returnProbability.add("70");
//        returnProbability.add("85");
//        returnProbability.add("95");
//        returnProbability.add("100");
//        List<Integer> probability = returnProbability.stream().map(Integer::valueOf).collect(Collectors.toList());
//        int size = probability.size();
//        for (int i = 0; i < size; i++) {
//            if(i == 0){
//                if(random < probability.get(0)){
//                    return Integer.parseInt(returnMultiple.get(i));
//                }else {
//                    continue;
//                }
//            }
//            if(probability.get(i-1)<=random && random < probability.get(i)){
//                return Integer.parseInt(returnMultiple.get(i));
//            }
//        }
//        return -1;
        int total = 0;
        for (Integer integer : splitRedPackets(1500000, 96, 5000, 200000)) {
            total = total + integer;
            System.out.println(integer);
        }
        System.out.println(total);
        deal(1,2,3,4,5,6,7,8);
        System.out.println("-----");
        deal(1,2,3,4);
        return -1;
    }

    private static void deal(int... intArray){
        for (int i : intArray) {
            System.out.println(i);
        }
    }

    private static  List<Integer> splitRedPackets(int money, int count,int minMoney ,int maxMoney) {
        int times = 2;
        List<Integer> list = new ArrayList<Integer>();
        //红包最大金额为平均金额的times倍
        int max = (int) (money * times / count);
        max = max > maxMoney ? maxMoney : max;
        for (int i = 0; i < count; i++) {
            int one = random(money, minMoney, max, count - i,minMoney,maxMoney);
            list.add(one);
            money -= one;
        }
        return list;
    }

    private static int random(int money, int minS, int maxS, int count, int minMoney, int maxMoney) {
        //红包数量为1，直接返回金额
        if (count == 1) {
            return money;
        }
        //如果最大金额和最小金额相等，直接返回金额
        if (minS == maxS) {
            return minS;
        }
        int max = maxS > money ? money : maxS;
        //随机产生一个红包
        int one = ((int)Math.rint(Math.random() * (max - minS) + minS)) % max + 1;
        int money1 = money - one;
        //判断该种分配方案是否正确
        if (isRight(money1, count - 1,minMoney,maxMoney)) {
            return one;
        } else {
            double avg = money1 / (count - 1);
            if (avg < minMoney) {
                //递归调用，修改红包最大金额
                return random(money, minS, one, count, minMoney, maxMoney);
            }else if (avg > maxMoney) {
                //递归调用，修改红包最小金额
                return random(money, one, maxS, count, minMoney, maxMoney);
            }
        }
        return one;
    }

    private static boolean isRight(int money, int count, int minMoney, int maxMoney) {
        double avg = money / count;
        if (avg < minMoney) {
            return false;
        }
        if (avg > maxMoney) {
            return false;
        }
        return true;
    }
}
