import java.util.Objects;

/***
 *
 * @author zhengchunguang
 * @date 2019-05-07 14:06
 * 反转单链表
 */
public class ReverseList {

    public static ListNode reverse(ListNode listNode){
        if(null == listNode || null == listNode.next){
            return listNode;
        }
        if(null == listNode.next.next){
            ListNode newHead = listNode.next;
            listNode.next = null;
            newHead.next = listNode;
            return newHead;
        }

        ListNode  p = listNode.next;
        ListNode q = p.next;
        listNode.next = null;
        p.next =  listNode;
        while(null != q){
            ListNode next =  q.next;
            q.next = p;
            p =  q;
            q = next;
        }
        return p;

    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode5.next = null;
        listNode4.next = listNode5;
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode1.next=  listNode2;
        System.out.println(reverse(listNode1).value);
    }





}
