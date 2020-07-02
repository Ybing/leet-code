package tag.sort;

import java.util.Arrays;

/**
 * @Description: 根据数字二进制下 1 的数目排序
 * @Author: 杨亚兵
 * @Date: 2020/7/2 17:17
 */
public class SortByBits {
    /**
     * 思路：
     * 因为二进制1的个数是首要排序要求，即占排序的绝对权重，那么就拿一个很大的数来乘以1的个数，再加上它本身的值，最后排序
     * 排序后，将数值恢复原本大小，即用乘以的数来求余数即可
     *
     * @param arr 至少有一个数字的整型数组且0 <= arr[i] <= 10^4
     * @return 按二进制下 1 的数目排序的数组，当 1 的个数相同时，按数值大小升序排列
     */
    public int[] sortByBits(int[] arr) {
        int[] result = new int[arr.length];
        int i = 0;
        for (; i < arr.length; i++) {
            result[i] = Integer.bitCount(arr[i]) * 100000 + arr[i];
        }
        Arrays.sort(result);
        for (i = 0; i < arr.length; i++) {
            result[i] = result[i] % 100000;
        }
        return result;
    }

    public static void main(String[] args) {
        SortByBits sortByBits = new SortByBits();
        int[] nums = {0,1,2,3,4,5,6,7,8};
        int[] result = sortByBits.sortByBits(nums);
        for (int item:result){
            System.out.println(item);
        }
    }
}
