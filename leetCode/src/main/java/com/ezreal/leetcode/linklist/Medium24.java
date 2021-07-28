package com.ezreal.leetcode.linklist;

import static com.ezreal.leetcode.linklist.ListNode.createLinkList;
import static com.ezreal.leetcode.linklist.ListNode.printLinkList;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 输入：head = []
 * 输出：[]
 *
 * 输入：head = [1]
 * 输出：[1]
 *
 */
public class Medium24 {

    public static void main(String[] args) {
        int[] nums = {1, 2};
        ListNode head = createLinkList(nums);
        printLinkList(head);
        ListNode listNode = swapPairs(head);
        printLinkList(listNode);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode t = new ListNode();
        t.next = head.next;
        ListNode cur = head.next;
        ListNode nex = cur.next;

        while (nex != null) {
            cur.next = head;
            head.next = nex;
            cur = nex.next;
            nex = cur.next;
        }
        return t.next;
    }

}
