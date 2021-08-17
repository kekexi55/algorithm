/***
 *
 * @author zhengchunguang
 * @date 2019-07-03 13:15
 * 快速排序
 */
public class FastSort {

    public static void quickSort(int[] array,int p, int r){
        if(null == array || array.length == 0){
            return;
        }
        if(p >= r){
            return;
        }
        int i = partition(array,p,r);
        quickSort(array,p,i-1);
        quickSort(array,i+ 1,r);
    }

    private static int partition(int[] array, int p, int r) {
        int last =  array[r];
        int i = p;
        for (int j = p; j<=r;j ++){
            if(array[j] < last){
                exchange(array,j,i);
                i++;
            }
        }
        exchange(array,i,r);
        return i;
    }

    private static void exchange(int[] array, int j, int i) {
        int tmp =  array[j];
        array[j] = array[i];
        array[i] = tmp;
    }


    public static void main(String[] args) {

        String test = "alal 你好 ll";
        test = test.replaceAll("[^a-z^A-Z]", "");
        System.out.println(test);
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
