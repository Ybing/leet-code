package tag.sort;

/**
 * @Description: 数组的相对排序
 * @Author: 杨亚兵
 * @Date: 2020/7/4 9:35 上午
 */
public class RelativeSortArray {
    /**
     * 思路：
     * 桶排序
     *
     * @param arr1 数组1，包含全部元素
     * @param arr2 数组2，所有元素都不相同，大小均小于1000
     * @return 排序后的数组1
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //初始化桶个数
        int[] nums = new int[1001];
        //对桶进行计数
        for (int item : arr1) {
            nums[item]++;
        }
        //用于记录数组1下表
        int pointer = 0;
        //遍历数组2
        for (int item : arr2) {
            //当桶计数为零时才去找下一个桶
            while (nums[item] > 0) {
                //将桶代表的指放如数组1
                arr1[pointer++] = item;
                //找一次桶就将此桶的计数减1
                nums[item]--;
            }
        }
        //对于没在数组2中的值，通过遍历桶寻找，并放入数组1
        for (int i = 0; i < nums.length; i++) {
            //注意：此处仍要使用while循环
            while (nums[i] > 0) {
                arr1[pointer++] = i;
                nums[i]--;
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1000, 666, 921, 366, 859, 743, 900, 334, 845, 154, 436, 494, 629, 838, 361, 109, 191, 52, 94, 815, 393, 220, 252, 451, 398, 262, 111, 28, 49, 11, 805, 668, 824, 564, 187, 333, 37, 929, 213, 388, 853, 61, 680, 487, 147, 939, 128, 389, 344, 637, 245};
        int[] arr2 = {1000, 11, 668, 487, 147, 929, 361, 388, 398, 680, 838, 805, 629, 262, 61, 28, 220, 52, 111, 451, 939, 344, 252, 213, 94, 333, 187, 436, 37, 743, 494, 245, 637, 853, 191, 900, 921, 815, 845, 154, 824, 49, 334, 564, 389, 109, 859, 666, 366, 128, 393};
        RelativeSortArray relativeSortArray = new RelativeSortArray();
        int[] result = relativeSortArray.relativeSortArray(arr1, arr2);
        for (int item : arr1) {
            System.out.println(item);
        }
    }
}
