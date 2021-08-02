package com.ezreal.leetcode.linklist;

import static com.ezreal.leetcode.linklist.ListNode.createLinkList;
import static com.ezreal.leetcode.linklist.ListNode.printLinkList;

/**
 * Created on 2021/7/28.
 *
 * @author Ezreal
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Medium19 {

    public static void main(String[] args) {
        int[] nums = {1, 2};
        ListNode head = createLinkList(nums);
        printLinkList(head);
        ListNode listNode = removeNthFromEnd(head, 1);
        printLinkList(listNode);
    }

    public static ListNode removeNthFromEnd(ListNode node, int n) {
        if (node == null) {
            return null;
        }
        ListNode head = new ListNode();
        head.next = node;
        ListNode pre = node;
        ListNode cur = node;
        while (n > 0 && pre != null) {
            pre = pre.next;
            n--;
        }
        if (n > 0) {
            return head.next;
        }
        if (pre != null) {
            while (pre.next != null) {
                pre = pre.next;
                cur = cur.next;
            }
            if (cur.next != null) {
                cur.next = cur.next.next;
            }
        } else {
            head.next = cur.next;
        }

        return head.next;
    }


}
