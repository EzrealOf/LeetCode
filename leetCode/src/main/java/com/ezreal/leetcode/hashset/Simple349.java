package com.ezreal.leetcode.hashset;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Simple349 {

    public static void main(String[] args) {
        int[] nums1 = {};
//        int[] nums1 = {1,2,5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] intersection = intersection(nums1, nums2);
        for (int i = 0; i < intersection.length; i++) {
            System.out.print(intersection[i] + "\t");
        }

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0)
            return new int[0];
        HashSet<Integer> sameSet = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();
        for (int j : nums1) {
            sameSet.add(j);
        }
        for (int j : nums2) {
            if (sameSet.contains(j)) {
                resultSet.add(j);
            }
        }
        int[] result = new int[resultSet.size()];
        Iterator<Integer> iterator = resultSet.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            result[i] = iterator.next();
            i++;
        }
        return result;
    }


}
