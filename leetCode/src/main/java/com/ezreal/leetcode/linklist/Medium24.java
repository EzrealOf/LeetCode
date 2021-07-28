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
        int[] nums = {};
        ListNode head = createLinkList(nums);
        printLinkList(head);
        ListNode listNode = swapPairs(head);
        printLinkList(listNode);
    }

    public static ListNode swapPairs(ListNode node) {
        if (node == null) {
            return null;
        }
        if (node.next == null) {
            return node;
        }
        ListNode head = new ListNode();
        head.next = node.next;
        ListNode next = node.next.next;
        node.next.next = node;
        node.next =  swapPairs(next);;
        return head.next;
    }

}
