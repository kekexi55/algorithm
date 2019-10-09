/***
 *
 * @author zhengchunguang
 * @date 2019-07-03 13:15
 * 快速排序
 */
public class FastSort {

    public static void quickSort(int[] array,int p, int r){
        if(p >= r){
            return;
        }
        int i = partition(array,p,r);
        quickSort(array,p,i-1);
        quickSort(array,i+1,r);
    }

    /**
     * 选择最后的数据
     */
    private static int partition(int[] array, int p, int r) {
        int last = array[r];
        int size = r - p;
        int i = p;
        for (int j = p; j < size; j++) {
            if(array[j] <= last){
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
            }
        }
        int t = array[i];
        array[i] = array[r];
        array[r] = t;
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
