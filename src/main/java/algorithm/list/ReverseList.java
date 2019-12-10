package algorithm.list;

import java.util.Objects;

/***
 *
 * @author zhengchunguang
 * @date 2019-12-10 15:23
 */
public class ReverseList {

    public static ListNode reverse(ListNode head){
        if(Objects.isNull(head)){
            return head;
        }
        //一个节点
        if(Objects.isNull(head.next)){
            return head;
        }
        ListNode next = head.next;
        ListNode nextnext = next.next;
        if(Objects.isNull(nextnext)){
            head.next = null;
            next.next = head;
            return next;
        }

        ListNode p = head.next;
        ListNode q = p.next;
        head.next = null;
        p.next = head;
        while (Objects.nonNull(q)){
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        return p;
    }

    public static void main(String[] args) {

    }

}
