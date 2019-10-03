/***
 *
 * @author zhengchunguang
 * @date 2019-10-01 09:02
 */
public class Heap {
    private int[] a = null;
    private int n;
    private int count;

    public Heap(int capacity) {
        this.n = capacity;
        count = 0;
        a = new int[capacity+1];
    }

    /**
     * 在堆中插入数据
     * @param value
     */
    public void insert(int value){
        if(count >= n){
            return;
        }
        count++;
        a[count] = value;
        int i = count;
        while(i/2 > 0 && a[i]>a[i/2]){
            swap(a,i,i/2);
            i = i/2;
        }
    }

    /**
     * 删除堆定元素
     */
    public void delete(){
        if(count == 0){
            return;
        }
        a[1] = a[count];
        count--;
        heapify(a);
    }

    /**
     * 删除后堆化
     * @param a
     */
    private void heapify(int[] a) {
        int max = 1;
        while (true){
            int i = max;
            if(2*max <= count && a[2*max]> a[max]){
                swap(a,max,2*max);
                max = 2*max;
                continue;
            }
            if(2*max +1 <= count && a[2*max+1]> a[max]){
                swap(a,max,2*max+1);
                max = 2*max+1;
                continue;
            }
            if(i == max){
                break;
            }

        }
    }

    private void swap(int[] a, int i, int i1) {
        int tmp  = a[i];
        a[i] =  a[i1];
        a[i1] = tmp;
    }


}
