/***
 *
 * @author zhengchunguang
 * @date 2019-11-06 14:14
 * 快排
 */
public class QuickSort2 {
    public static void quickSort(int [] array, int p,int r){
        if(p >= r){
            return;
        }
        int i = partition(array,p,r);
        quickSort(array,p,i-1);
        quickSort(array,i+1,r);
    }

    /**
     * 中间节点
     * @param array
     * @param p
     * @param r
     * @return
     */
    private static int partition(int[] array, int p, int r) {
        int pvoit = array[r];
        int i = p;
        for(int j = p; j <= r;j++){
            if(array[j] < pvoit){
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
            }
        }
        int tmp = array[r];
        array[r] = array[i];
        array[i] = tmp;
        return i;
    }

    public static void main(String[] args) {
        int[] array = new int[]{12,192,1929,73,84,88,1029};
        quickSort(array,0,array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
