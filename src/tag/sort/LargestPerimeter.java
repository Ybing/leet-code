package tag.sort;

import java.util.Arrays;

/**
 * @Description: 三角形的最大周长
 * @Author: 杨亚兵
 * @Date: 2020/7/7 2:41 下午
 */
public class LargestPerimeter {
    /**
     * 思路：
     * 先排序，然后看最大的三个能不能形成三角形，如果行则直接输出，如果不行，就把最大的边舍弃
     *
     * @param A 数组 3 <= A.length <= 10000
     * @return 最大周长
     */
    public int largestPerimeter(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i - 1] + A[i - 2] > A[i]) {
                return A[i - 1] + A[i - 2] + A[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {3,6,2,3};
        LargestPerimeter largestPerimeter = new LargestPerimeter();
        System.out.println(largestPerimeter.largestPerimeter(A));
    }
}
