package com.ezreal.leetcode.hashset;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答案。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * <p>
 * 输入：words = ["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] 由小写英文字母组成
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Easy1002 {

    public static void main(String[] args) {
       String[] words = {"bella","label","roller"};
        List<String> result = commonChars(words);
        System.out.println(result);

    }

    public static List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        if (words.length == 0)
            return result;
        int[] hash = new int[26];
        String word = words[0];
        //init hash
        for (int i = 0; i < word.length(); i++) {
            hash[word.charAt(i) - 'a']++;
        }

        for (int i = 1; i < words.length; i++) {
            int[] otherHash = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                otherHash[words[i].charAt(j) - 'a']++;
            }
            for (int r = 0; r < hash.length; r++) {
                hash[r] = Math.min(hash[r], otherHash[r]);
            }
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i]>0){
                char c= (char) (i+'a');
                hash[i]--;
                result.add(String.valueOf(c));
            }
        }
        return result;
    }
}
