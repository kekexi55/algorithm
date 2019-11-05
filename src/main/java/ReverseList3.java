import java.util.Objects;

/***
 *
 * @author zhengchunguang
 * @date 2019-11-05 15:37
 */
public class ReverseList3 {
    /**
     * 将单链表反转
     * @param head
     */
    public static ListNode reverse(ListNode head){
        //一个节点
        if(Objects.isNull(head) || Objects.isNull(head.next)){
            return head;
        }
        //两个节点
        if(Objects.isNull(head.next.next)){
            ListNode next = head.next;
            head.next = null;
            next.next = head;
            return next;
        }
        ListNode p = head.next;
        ListNode q = p.next;
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
        p1.traverse();
        System.out.println("================");
        reverse(p1).traverse();

    }
}
