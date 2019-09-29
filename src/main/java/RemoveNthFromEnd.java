import java.util.Objects;

/***
 *
 * @author zhengchunguang
 * @date 2019-05-09 18:39
 * 找到
 * 快慢指针法
 */
public class RemoveNthFromEnd {
    public static ListNode find(ListNode head, int n){
        if(Objects.isNull(head)){
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < n - 1; i++) {
            p = p.next;
        }
        while(Objects.nonNull(p.next)){
            p = p.next;
            q = q.next;
        }
        return q;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(10);
        ListNode p2 = new ListNode(30);
        ListNode p3 = new ListNode(40);
        ListNode p4 = new ListNode(5);
        ListNode p5 = new ListNode(35);
        p5.next = null;
        p4.next = p5;
        p3.next = p4;
        p2.next = p3;
        p1.next = p2;

        System.out.println(find(p1, 3).value);
    }

}
