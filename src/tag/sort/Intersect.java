package tag.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 两个数组的交集
 * @Author: 杨亚兵
 * @Date: 2020/7/7 2:56 下午
 */
public class Intersect {
    /**
     * 思路：
     * 先排序，然后遍历
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 两个数组的交集
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        List<Integer> numList = new LinkedList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length) {
            while (j < nums2.length) {
                if (nums1[i] == nums2[j]) {
                    numList.add(nums1[i]);
                    i++;
                    j++;
                    break;
                } else if (nums1[i] > nums2[j]) {
                    j++;
                } else {
                    i++;
                    break;
                }
            }
            if (j >= nums2.length) {
                break;
            }
        }
        int[] result = new int[numList.size()];
        int count = 0;
        for (int item : numList) {
            result[count++] = item;
        }
        return result;
    }

    /**
     * 方法2（官方解答，思路不错，效率与方法1无异）
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect2(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static void main(String[] args) {
        int[] nums1 = {61,24,20,58,95,53,17,32,45,85,70,20,83,62,35,89,5,95,12,86,58,77,30,64,46,13,5,92,67,40,20,38,31,18,89,85,7,30,67,34,62,35,47,98,3,41,53,26,66,40,54,44,57,46,70,60,4,63,82,42,65,59,17,98,29,72,1,96,82,66,98,6,92,31,43,81,88,60,10,55,66,82,0,79,11,81};
        int[] nums2 = {5,25,4,39,57,49,93,79,7,8,49,89,2,7,73,88,45,15,34,92,84,38,85,34,16,6,99,0,2,36,68,52,73,50,77,44,61,48};
        Intersect intersect = new Intersect();
        int[] result = intersect.intersect2(nums1, nums2);
        for (int item : result) {
            System.out.println(item);
        }
    }
}
