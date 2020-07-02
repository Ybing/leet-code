package tag.sort;

/**
 * @Description: 上升下降字符串
 * @Author: 杨亚兵
 * @Date: 2020/7/2 11:02
 */
public class SortString {
    /**
     * 思路：
     * 采用桶计数
     *
     * @param s 源字符串
     * @return 结果字符串
     */
    public String sortString(String s) {
        //用于计数的桶
        int[] barrels = new int[26];
        char[] chars = s.toCharArray();
        //统计字符总数用于下面循环取出时判断是否完全取出
        int count = chars.length;
        int temp;
        for (char c : chars) {
            //计算应该把字符放进哪个桶
            temp = c - 'a';
            //给相应的桶计数
            barrels[temp] += 1;
        }
        StringBuilder builder = new StringBuilder();
        while (count > 0) {
            //正向遍历
            for (int i = 0; i < 26; i++) {
                if (barrels[i] > 0) {
                    builder.append((char) ('a' + i));
                    barrels[i]--;
                    count--;
                }
            }
            //逆向遍历
            for (int i = 25; i >= 0; i--) {
                if (barrels[i] > 0) {
                    builder.append((char) ('a' + i));
                    barrels[i]--;
                    count--;
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        SortString sortString = new SortString();
        String s = "aaabbbccc";
        System.out.println(sortString.sortString(s));
    }
}
