/***
 *
 * @author zhengchunguang
 * @date 2019-05-07 14:06
 * 反转单链表
 */
public class ReverseList {
    public static ListNode reverse(ListNode head){
        //0个节点
        if(head == null ){
            return null;
        }
        //只有一个节点
        if(head.next == null){
            return head;
        }
        //只有两个节点
        if(head.next.next == null){
            ListNode newHead = head.next;
            head.next = null;
            newHead.next = head;
            return newHead;
        }
        ListNode node = head;
        ListNode next = head.next;
        node.next = null;
        while(next != null){
            ListNode node1 = next.next;
            next.next = node;
            node = next;
            next = node1;
        }
        return node;
    }

}
