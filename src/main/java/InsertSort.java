/***
 *
 * @author zhengchunguang
 * @date 2019-10-08 17:54
 * 插入排序
 */
public class InsertSort {


    public static void main(String[] args) {
        int[] array = new int[]{882,199,2828,199182,2882,2929};
        insertSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * 插入排序
     * @param array
     */
    private static void insertSort(int[] array) {
        if(null == array || array.length == 0){
            return;
        }
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int j = i - 1;
            int tmp = array[i];
            for (; j >= 0; j--) {
                if(array[j]>array[i]){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
}
