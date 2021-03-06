import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LeetCode3 {
    /**
     * 遍历一遍 滑动窗口跳窗口
     * 非重复或者重复的元素在minIndex之前都有效，然后放入map
     * 重复并且在minIndex之后，要更新minIndex为重复元素索引的后一个
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        int maxLen = 0;
        int minIndex = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                minIndex = Math.max(map.get(c) + 1, minIndex);
            }
            map.put(c, i);
            maxLen = Math.max(maxLen, i - minIndex + 1);
        }
        return maxLen;
    }

    /**
     * 网上的优化方法，用数组代替map 因为数组初始化为0，为了速度不初始化为-1，所以索引都要加1
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if(s == null){
            return 0;
        }
        int maxLen = 0;
        int minIndex = 0;
        int[] nums = new int[128];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(nums[c] != 0){
                minIndex = Math.max(nums[c], minIndex);
            }
            nums[c] = i + 1;
            maxLen = Math.max(maxLen, i - minIndex + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LeetCode3 leetCode3 = new LeetCode3();
        System.out.println(leetCode3.lengthOfLongestSubstring("abba"));
    }
}
