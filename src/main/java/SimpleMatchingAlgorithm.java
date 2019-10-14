import com.google.common.base.Strings;

/***
 *
 * @author zhengchunguang
 * @date 2019-10-14 17:17
 * 朴素的字符串匹配算法
 */
public class SimpleMatchingAlgorithm {
    public static boolean match(String str1, String str2){
        if(Strings.isNullOrEmpty(str1)&&!Strings.isNullOrEmpty(str2)){
            return false;
        }
        if(Strings.isNullOrEmpty(str2)&&!Strings.isNullOrEmpty(str1)){
            return false;
        }
        int length1 =  str1.length();
        int length2 =  str2.length();
        int j = 0;
        boolean start = false;
        int min = -1;
        int max = -1;
        for (int i = 0; i < length1; i++) {
            char theChar = str1.charAt(i);
            int index = isMatch(j,theChar,str2);
            //匹配
            if(index >= 0 && !start){
                min = index;
                start = true;
                j++;
            }else if(start && index >= 0){
                max = j;
                j++;
            }else{
                j = 0;
            }
            if(j == length2 ){
                break;
            }
        }
        System.out.println(min);
        System.out.println(max);
        return true;

    }

    private static int isMatch(int j, char theChar,String str) {
         return theChar == str.charAt(j)?j:-1;
    }

    public static void main(String[] args) {
        match("1234562wer","345755");
    }
}
