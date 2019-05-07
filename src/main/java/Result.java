import java.util.Arrays;
import java.util.List;

/***
 *
 * @author zhengchunguang
 * @date 2019-05-07 14:07
 * 各种算法的测试类
 */
public class Result {
    public static void main(String[] args) {
        //反转链表
        String str ="1,2,3,4,5";
        List<String> list  = Arrays.asList(str.split(","));
        for (String s : list) {
            ListNode node =  new ListNode(Integer.valueOf(s));
//            node.next
        }
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseList.reverse(head);
    }
}
