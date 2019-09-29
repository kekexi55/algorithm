import java.util.Objects;

/***
 *
 * @author zhengchunguang
 * @date 2019-05-07 14:06
 * 反转单链表
 */
public class ReverseList {
    public static ListNode reverse(ListNode head){
        if(Objects.isNull(head)){
            return null;
        }
        //一个节点
        if(Objects.isNull(head.next)){
            return head;
        }
        //两个节点
        if(Objects.isNull(head.next.next)){
            ListNode result = head.next;
            head.next.next = head;
            head.next = null;
            return result;
        }

        ListNode p = head.next;
        ListNode q = p.next;
        head.next = null;
        p.next = head;
        while (Objects.nonNull(q)){
           ListNode next = q.next;
           q.next = p;
           p = q;
           q = next;
        }
        return p;
    }

    public static void main(String[] args) throws Exception {
        ListNode p1 = new ListNode(10);
        ListNode p2 = new ListNode(30);
        ListNode p3 = new ListNode(40);
        ListNode p4 = new ListNode(5);
        ListNode p5 = new ListNode(35);
        p4.next = p5;
        p3.next = p4;
        p2.next = p3;
        p5.next = null;


        System.out.println("分割线================");

//        ReverseList reverseList = new ReverseList();
//        ListNode result = reverseList.reverse(p4);

//        result.traverse();
        System.out.println(IsCircleList.isCircle(p2));


    }
}
