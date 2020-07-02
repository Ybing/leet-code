package tag.sort;

/**
 * @Description: 按奇偶排序数组II
 * @Author: 杨亚兵
 * @Date: 2020/7/2 16:37
 */
public class SortArrayByParityII {
    /**
     * 思路：
     *
     * @param A 偶数长度的数组，一半奇数，一半偶数
     * @return 偶奇偶奇偶奇顺序排列的数组
     */
    public int[] sortArrayByParityII(int[] A) {
        //用来记录被挖的数的值
        int temp,i = 0, j = 1;
        int length = A.length;
        for (i = 0; i < length; i += 2) {
            if (A[i] % 2 == 1) {
                for (; j < length; j += 2) {
                    if (A[j] % 2 == 0) {
                        temp = A[i];
                        A[i] = A[j];
                        A[j] = temp;
                        break;
                    }
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
        int[] nums = {1,3,5,7,9,2,4,6,8,0};
        int[] ints = sortArrayByParityII.sortArrayByParityII(nums);
        for (int item : ints) {
            System.out.println(item);
        }
    }
}
