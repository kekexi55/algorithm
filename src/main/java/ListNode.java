import java.util.Objects;

/***
 *
 * @author zhengchunguang
 * @date 2019-05-07 14:06
 */
public class ListNode {
     int value;
     ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void traverse(){
        ListNode next = this.next;
        System.out.println(this.value);
        while (Objects.nonNull(next)){
            System.out.println(next.value);
            next = next.next;
        }
    }

}
