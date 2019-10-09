/***
 *
 * @author zhengchunguang
 * @date 2019-10-09 10:00
 *
 */
public class QuickSort {
    /**
     *
     * @param array 要排序的数组
     * @param p   起始点下标
     * @param q   终止点下标
     */
    public static void quickSort(int[] array,int p,int q){
        if(null == array || array.length == 0){
            return;
        }
        if(p >= q){
            return;
        }
        int index = partition(array,p,q);
        quickSort(array,p,index-1);
        quickSort(array,index+1,q);
    }

    /**
     * partition函数
     * @param array
     * @param p
     * @param q
     * @return
     */
    private static int partition(int[] array, int p, int q) {
        int last = array[q];
        int i = p;
        for (int j = p; j <= q; j++) {
            if(array[j] > last){
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i ++;
            }
        }
        int tmp  = array[q];
        array[q] = array[i];
        array[i] = tmp;
        return i;
    }

    public static void main(String[] args) {
        int[] array = new int[]{12,92,9390,8828,32,873,727};
        System.out.println("before");
        for (int i : array) {
            System.out.println(i);
        }
        quickSort(array,0,array.length-1);
        System.out.println("after");
        for (int i : array) {
            System.out.println(i);
        }
    }
}
