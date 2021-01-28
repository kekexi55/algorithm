import com.google.common.base.Strings;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

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

    /**
     * 第二种匹配算法
     * @param str1
     * @param str2
     */
    public static void match2(String str1,String str2){
        int length1 = str1.length();
        int length2 = str2.length();
        int i = 0;
        int j = 0;
        while(i<length1&&j<length2){
            if(str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }else{
                i++;
                j = 0;
            }
        }
        if(j == length2){
            System.out.println(i-j);
        }else{
            System.out.println(-1);
        }
    }



    private static int isMatch(int j, char theChar,String str) {
         return theChar == str.charAt(j)?j:-1;
    }


    /**
     *
     * @param param  0 本周  -1 上周
     * @return
     */
    public static String getWeekNum(int param) {
        LocalDate date = LocalDate.now();
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int week = date.get(weekFields.weekOfWeekBasedYear());
        if(param == -1){
            week--;
        }
        return  String.valueOf(week);
    }

    public static void main(String[] args) {

        int cardTreasureMarker = 3;
        int boxSn  = 2;
        cardTreasureMarker |= (int)Math.pow(2, boxSn - 1);
        System.out.println(cardTreasureMarker);
    }
}
