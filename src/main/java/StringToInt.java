import java.util.ArrayList;
import java.util.List;

/***
 *
 * @author zhengchunguang
 * @date 2019-10-03 12:42
 */
public class StringToInt {
    public static int myAtoi(String str) {
        if(null == str || "".equals(str)){
            return 0;
        }
        List<String> nums = new ArrayList<String>();
        nums.add("0");
        nums.add("1");
        nums.add("2");
        nums.add("3");
        nums.add("4");
        nums.add("5");
        nums.add("6");
        nums.add("7");
        nums.add("8");
        nums.add("9");
        String minusSign = "-";
        boolean flag = false;
        StringBuilder sb =new StringBuilder();
        int size = str.length();
        for(int i = 0;i<size;i++){
            String caStr = String.valueOf(str.charAt(i));
            if(" ".equals(caStr)){
                continue;
            }
            if(caStr.equals(minusSign)){
                flag = true;
            }
            if(nums.contains(caStr)){
                sb.append(caStr);
            }
        }
        if("".equals(sb.toString())){
            return 0;
        }
        String str1 = sb.toString();
        int length  = str1.length();
        if(length == 0){
            return 0;
        }
        int result = 0;
        for(int i = 0;i < length ; i++){
            result = result + ((int)Math.pow(10,(length - 1 - i)))*Integer.valueOf(String.valueOf(str1.charAt(i)));
        }
        int two31 = (int)Math.pow(2,31)-1;
        if(result > two31){
            if(flag){
                return two31*(-1);
            }
            return two31;
        }
        if(flag){
            return result*(-1);
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(myAtoi("4193 with words"));
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        double start = 0;
        double end = x;
        double half = x / 2;
        while(half * half - x >=1e-6){
            if(half*half>x){
                end = half;
            }
            if(half*half<x){
                start = half;
            }
            half = start + (end -start)/2;
            System.out.println(half);
            if(half*half == x){
                break;
            }
        }
        return (int)half;
    }
}
