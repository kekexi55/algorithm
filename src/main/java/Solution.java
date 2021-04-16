import java.util.ArrayList;
import java.util.List;

class Solution {
    public static ListNod deleteDuplicates(ListNod head) {
        if(null == head){
            return head;
        }
        //返回值
        ListNod current = head;
        int currentValue = head.val;
        List<Integer> values = new ArrayList<>();
        while(null != current){
            if(current.val != currentValue){
                values.add(current.val);
                currentValue = current.val;
            }
            current = current.next;
        }
        int size =  values.size();

        ListNod curr  = new ListNod(head.val);
        ListNod  pre  = curr;
        for(int index = 0; index < size; index++){
            curr.next = new ListNod(values.get(index));
            curr = curr.next;
        }
        return pre;
    }

    public static void main(String[] args) {
        if(true) System.out.println(111);
        System.out.println(222);
    }
}


