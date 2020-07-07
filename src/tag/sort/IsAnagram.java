package tag.sort;

/**
 * @Description: 有效的字母异位词
 * @Author: 杨亚兵
 * @Date: 2020/7/7 2:22 下午
 */
public class IsAnagram {
    /**
     * 思路：
     * 桶计数
     *
     * @param s 字符串
     * @param t 字符串
     * @return true:是 false:不是
     */
    public boolean isAnagram(String s, String t) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        char[] sChars = s.toCharArray();
        for (char c:sChars){
            arr1[c-'a']+=1;
        }
        char[] tChars = t.toCharArray();
        for (char c:tChars){
            arr2[c-'a']+=1;
        }
        for (int i = 0; i<26;i++){
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "";
        String t = "";
        IsAnagram isAnagram = new IsAnagram();
        System.out.println(isAnagram.isAnagram(s,t));
    }
}
