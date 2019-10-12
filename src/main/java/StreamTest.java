
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/***
 *
 * @author zhengchunguang
 * @date 2019-05-24 16:11
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> testList = new ArrayList<>();
        testList.add("你好");
        testList.add("我好");
        testList.add("大家好");
        List<String> resultList = testList.stream().filter( e -> !e.equalsIgnoreCase("你好")).collect(Collectors.toList());
        String[] strings = new String[]{"11","22"};
        List<String> arrayList = Arrays.asList(strings);
        System.out.println(arrayList);
        System.out.println(resultList);
        List<String> test2List = new ArrayList<>();
        test2List.add("aba");
        test2List.add("llal");
        test2List.add("sss");
        System.out.println(test2List.stream().map(e -> e.toUpperCase()).collect(Collectors.toList()));
        String content  = "ksks,slkslk,sllsksm,llsl";
//        System.out.println(Splitter.on(",").trimResults().splitToList(content));
        List<Item> list =  new ArrayList<>();
        list.add(new Item(11));
        list.add(new Item(93));
        list.add(new Item(198));
        list.add(new Item(1));
        Collections.sort(list);
        System.out.println(list);



    }

}
