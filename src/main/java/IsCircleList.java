import java.util.Objects;

/***
 *
 * @author zhengchunguang
 * @date 2019-09-29 15:59
 * 判断链表是否有环
 */
public class IsCircleList {
    public static boolean isCircle(ListNode head) throws Exception {
        if(Objects.isNull(head)){
            throw new Exception("链表不能为空");
        }
        if(Objects.isNull(head.next)){
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next;
        while (Objects.nonNull(fast.next)){
            slow =  slow.next;
            fast =  fast.next.next;
            if(slow.equals(fast)){
                return true;
            }
        }
        return false;
    }
}
