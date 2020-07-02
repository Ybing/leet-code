package tag.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 非递增顺序的最小子序列
 * @Author: 杨亚兵
 * @Date: 2020/7/2 14:23
 */
public class MinSubsequence {
    /**
     * 思路：
     * 先排序，再计算总和，再从尾开始减，直到后面数字和大于前面数字和，再把后面数字输出
     *
     * @param nums 数组
     * @return 最小子序列
     */
    public List<Integer> minSubsequence(int[] nums) {
        //如果仅有一个数据，直接返回
        List<Integer> result = new LinkedList<>();
        if (nums.length == 1){
            result.add(nums[0]);
            return result;
        }
        //排序
        Arrays.sort(nums);
        //求和
        int total = 0;
        for (int item:nums){
            total += item;
        }
        //用于计算尾数和
        int tailTotal = 0;
        for (int i = nums.length - 1; i >= 0; i--){
            tailTotal += nums[i];
            result.add(nums[i]);
            //尾数和大于剩余数据和时，跳出循环，结束程序
            if (tailTotal > total - tailTotal){
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinSubsequence minSubsequence = new MinSubsequence();
        int[] nums = {84,64,3,2,56,4,1,100};
        List<Integer> integers = minSubsequence.minSubsequence(nums);
        System.out.println(integers.toString());
    }
}
