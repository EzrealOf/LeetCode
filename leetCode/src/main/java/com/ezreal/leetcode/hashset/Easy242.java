package com.ezreal.leetcode.hashset;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *  
 * <p>
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Easy242 {

    public static void main(String[] args) {
        String s = "anagraq", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            resultMap.put(sChars[i] - 'a', resultMap.getOrDefault(sChars[i] - 'a', 0) + 1);
        }
        char[] tChars = t.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            int orDefault = resultMap.getOrDefault(tChars[i] - 'a', 0) - 1;
            if (orDefault < 0) {
                return false;
            }
            resultMap.put(tChars[i] - 'a', orDefault);
        }
        for (Integer value : resultMap.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
