package tag.sort;

import java.util.HashSet;

/**
 * @Description: 两个数组的交集
 * @Author: 杨亚兵
 * @Date: 2020/7/2 15:50
 */
public class Intersection {
    /**
     * 思路：
     * 用两个HashSet，原因，set本就是用来去重，hash可以加快速度
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
        HashSet<Integer> set1 = new HashSet<>();
        for (int item:nums1){
            set1.add(item);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int item:nums2){
            if (set1.contains(item)){
                set2.add(item);
            }
        }
        int[] result = new int[set2.size()];
        int pointer = 0;
        for (int item:set2){
            result[pointer++] = item;
        }
        return result;
    }

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        int[] num1 = {2,2,3,45,3,1};
        int[] num2 = {2,3,6,5};
        int[] resultArray = intersection.intersection(num1, num2);
        for (int item: resultArray){
            System.out.println(item);
        }
    }
}
