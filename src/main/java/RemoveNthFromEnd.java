/***
 *
 * @author zhengchunguang
 * @date 2019-05-09 18:39
 * 删除链表倒数第N个值
 */
public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head ,int n){
        if(head == null){
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < n; i++) {
            p =  p.next;
        }
        while(p.next !=null){
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return q;
    }
}
