/***
 *
 * @author zhengchunguang
 * @date 2019-10-05 16:12
 * 求解最长公共子串
 */
public class LongestCommonSubstring {
    public static String max(String str1,String str2){
        if(null ==  str1 || "".equals(str1)){
            return null;
        }
        if(null ==  str2 || "".equals(str2)){
            return null;
        }
        int length1 =  str1.length();
        int length2 =  str2.length();
        int[] previousLine = new int[length1];
        int[] currentLine = new int[length1];
        //最大值所在的列
        int column = 0;
        int max = 0;
        for (int i = 0; i < length2; i++) {
            char ca = str2.charAt(i);
            for (int j = 0; j < length1; j++) {
                if(ca == str1.charAt(j)){
                    //第一行
                    if(j == 0){
                        currentLine[j] = 1;
                    }else{
                        currentLine[j] = previousLine[j-1] +1;
                    }
                    if(currentLine[j] > max){
                        max = currentLine[j];
                        column = j;
                    }
                }
            }
            previousLine = currentLine;
            currentLine = new int[length1];
        }
        return str1.substring(column-(max-1),column+1);
    }

    public static void main(String[] args) {
        System.out.println(max("ablaooallal","lsooalsoss"));
    }
}
