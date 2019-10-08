/***
 *
 * @author zhengchunguang
 * @date 2019-10-08 17:54
 * 插入排序
 */
public class InsertSort {
    public static void insertSort(int[] array){
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int value = array[i];
            int j = i - 1;
            for(;j >= 0;j--){
                if(array[j] > value){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1]= value;
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{882,199,2828,199182,2882,2929};
        insertSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
