import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/***
 *
 * @author zhengchunguang
 * @date 2019-05-30 15:05
 */
public class Item{

    private Integer weight;

    public Item(Integer weight) {
        this.weight = weight;
    }

//    @Override
//    public int compareTo(Item o) {
//        return this.weight>o.weight? 1:-1;
//    }

    /**
     * INSERT INTO table_name ( field1, field2,...fieldN )
     *                        VALUES
     *                        ( value1, value2,...valueN );
     * @param args
     */
    public static void main(String[] args) {
//        FileInputStream is = null;
//        try {
//            File fout = new File("/Users/zhengchunguang/Desktop/local/fanti.txt"); // 创建文件输出对象
//            FileWriter out = new FileWriter(fout); // 创建文件字符流 写 对象，传递文件对象
//            is = new FileInputStream("/Users/zhengchunguang/Desktop/local/done.xlsx");
//            XSSFWorkbook workbook =  new XSSFWorkbook(is);
//            //获取第一个sheet
//            Sheet sheet = workbook.getSheetAt(0);
//            //第0行是表名，忽略，从第二行开始读取
//            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
//                String string =  "INSERT INTO i18n_resource (`biz`,`key`,`val`,`remark`) " +
//                        " VALUES ('fish',";
//                Row row = sheet.getRow(rowNum);
//                Cell keyCell = row.getCell(0);
//                Cell valueCell = row.getCell(1);
//                Cell fanCell = row.getCell(2);
//                String key = keyCell.getStringCellValue();
//                String value = valueCell.getStringCellValue();
//                String fan = fanCell.getStringCellValue();
//                string =  string + "'" + key +"'" +",";
//                string =  string + "'" + fan +"'" +",";
//                string =  string + "'" + value +"'" +");";
//                out.write(string);
//                out.write("\n");
//            }
//            out.flush();
//            out.close();
//
//        } catch (IOException e) {
//
//        } finally {
//            IOUtils.closeQuietly(is);
//        }
        int[] array =new int[]{1,2,3,4,5,6,7};
        rotate(array,3);
        for (int i : array) {
            System.out.println(i);
        }

        System.out.println(climbStairs(45));
    }

    public static  void rotate(int[] nums, int k) {
        int length = nums.length;
        if(k%length == 0){
            return;
        }
        k = k % length;
        k = length - k;
        rever(nums,0,k-1);
        rever(nums,k,length-1);
        rever(nums,0,length-1);
    }

    private static void rever(int[] nums, int start, int end) {
        int y =  start+end;
        int middle = (end -start)/2;
        middle = middle + start;
        for (int i = start; i <= middle; i++) {
            int temp = nums[i];
            nums[i] = nums[y-i];
            nums[y-i] = temp;
        }
    }

    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length ==0){
            return false;
        }
        HashSet set = new HashSet();
        for (int num : nums) {
            if(set.contains(num)){
                return true;
            }else {
                set.add(num);
            }
        }
        return false;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int size1 =  nums1.length;
        int size2 = nums2.length;

        int p = 0;
        int q = 0;

        List<Integer> list = new ArrayList<Integer>();
        while (p<size1&&q<size2){
            if(nums1[p]==nums2[q]){
                list.add(nums1[p]);
                p++;
                q++;
            }else if(nums2[q] > nums1[p]){
                p++;
            }else {
                q++;
            }
        }
        int [] array = new int[list.size()];
        int i = 0;
        for (int o : list) {
            array[i] = o;
            i++;
        }
        return array;

    }

    public static int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }

        return climbStairs(n-1)+climbStairs(n-2);
    }



}
