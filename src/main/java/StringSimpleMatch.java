import com.google.common.base.Strings;

/***
 *
 * @author zhengchunguang
 * @date 2019-11-06 14:43
 * 朴素匹配算法
 */
public class StringSimpleMatch {
    public int match(String str1, String str2){
        if(Strings.isNullOrEmpty(str1)){
            return -1;
        }
        if(Strings.isNullOrEmpty(str2)){
            return -1;
        }
        int length1 = str1.length();
        int length2 = str2.length();
        int i = 0;
        int j = 0;
        while (i < length1 && j<length2){
            if(str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }else{
                i++;
                j = 0;
            }
        }
        if(j == length2){
            return (i - j);
        }else{
            return -1;
        }
    }
}
