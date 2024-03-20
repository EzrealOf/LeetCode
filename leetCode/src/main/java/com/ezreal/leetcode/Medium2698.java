package com.ezreal.leetcode;
//给你一个正整数 n ，请你返回 n 的 惩罚数 。
//
// n 的 惩罚数 定义为所有满足以下条件 i 的数的平方和：
//
//
// 1 <= i <= n
// i * i 的十进制表示的字符串可以分割成若干连续子字符串，且这些子字符串对应的整数值之和等于 i 。
//
//
//
//
// 示例 1：
//
//
//输入：n = 10
//输出：182
//解释：总共有 3 个整数 i 满足要求：
//- 1 ，因为 1 * 1 = 1
//- 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
//- 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
//因此，10 的惩罚数为 1 + 81 + 100 = 182
//
//
// 示例 2：
//
//
//输入：n = 37
//输出：1478
//解释：总共有 4 个整数 i 满足要求：
//- 1 ，因为 1 * 1 = 1
//- 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
//- 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
//- 36 ，因为 36 * 36 = 1296 ，且 1296 可以分割成 1 + 29 + 6 。
//因此，37 的惩罚数为 1 + 81 + 100 + 1296 = 1478
//
//
//
//
// 提示：
//
//
// 1 <= n <= 1000
//
//
// Related Topics 数学 回溯 👍 87 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Medium2698 {
    public static void main(String[] args) {
        int number = punishmentNumber(37);
        System.out.println(number);
    }


    public static int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int k = i * i;
            String pow = String.valueOf(k);
            if (test(pow, 0, i)) {
                res = res + Integer.valueOf(pow);
            }

        }
        return res;
    }


    private static boolean test(String pow, int start, int target) {
        int end = pow.length();
        for (int j = start; j < end; j++) {
            int result = 0;
            String substring = pow.substring(start, j + 1);
            Integer current = Integer.valueOf(substring);
            result = result + current;
            if (result == target && j + 1 == end) {
                return true;
            } else {
                if (target < result) {
                    continue;
                }
                if (test(pow, j + 1, target - result)) {
                    return true;
                }
            }

        }
        return false;
    }


}
