import java.util.Objects;

/***
 *
 * @author zhengchunguang
 * @date 2019-10-12 17:18
 * 反转列表
 */
public class ReverseList2 {
    public static ListNode reverse(ListNode head){
        if(null == head || Objects.isNull(head.next)){
            return head;
        }
        ListNode p = head.next;
        ListNode q = p.next;
        if(Objects.isNull(q)){
            head.next = null;
            p.next = head;
            return p;
        }
        head.next = null;
        p.next = head;
        while(Objects.nonNull(q)){
            ListNode next = q.next;
            q.next = p;
            p = q;
            q = next;
        }
        return p;
    }




    public static void main(String[] args) {
        ListNode p1 = new ListNode(10);
        ListNode p2 = new ListNode(30);
        ListNode p3 = new ListNode(40);
        ListNode p4 = new ListNode(5);
        ListNode p5 = new ListNode(35);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = null;
        ListNode head = reverse(p1);
        System.out.println(head.value);
        ListNode next= head.next;
        while (Objects.nonNull(next)){
            System.out.println(next.value);
            next = next.next;
        }

    }
}
