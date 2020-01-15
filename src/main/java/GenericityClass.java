import com.google.common.collect.Maps;

import java.util.Map;

/***
 *
 * @author zhengchunguang
 * @date 2020/1/15
 * 创建一个泛型方法
 */
public class GenericityClass {

    public static <T> Map<String,T> setValue(Map<String,T> map ,T  t){
        map.put("sss",t);
        return map;
    }

    public static void main(String[] args) {
        Map<String,String> map = Maps.newHashMap();
        System.out.println(setValue(map, "111"));
    }
}
