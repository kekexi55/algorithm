/***
 *
 * @author zhengchunguang
 * @date 2019-07-03 13:15
 * 快速排序
 */
public class FastSort {
    public static void sort(int[]array,int q,int r){
        if(q>=r) return;
        int p = parition(array,q,r);
        sort(array,q,p-1);
        sort(array,p+1,r);
    }

    private static int parition(int[] array, int q, int r) {
        int pvoit = array[r];
        int i = q;
        for(int j = q;j< r;j++){
            if(array[j] <= pvoit){
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
            }
        }
        int tmpp = array[i];
        array[i] = array[r];
        array[r] = tmpp;
        return i;
    }

    public static void main(String[] args) {
        int[] array = new int[]{12,92,9390,8828,32,873,727};
        System.out.println("before");
        for (int i : array) {
            System.out.println(i);
        }
        sort(array,0,array.length-1);
        System.out.println("after");
        for (int i : array) {
            System.out.println(i);
        }
    }
}
