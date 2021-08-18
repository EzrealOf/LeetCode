package com.ezreal.leetcode.linklist;

import static com.ezreal.leetcode.linklist.ListNode.createLinkList;

/**
 * Created on 2021/8/8.
 * <p>
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * <p>
 * <p>
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * <p>
 * listA 中节点数目为 m
 * listB 中节点数目为 n
 * 0 <= m, n <= 3 * 104
 * 1 <= Node.val <= 105
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
 * <p>
 * <p>
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ezreal
 * @since 2.0.0
 */
public class Simple02_07 {

    public static void main(String[] args) {
        int[] numsA = {4, 1, 8, 4, 5};
        int[] numsB = {5, 0, 1, 8, 4, 5};
        ListNode headA = createLinkList(numsA);
        ListNode headB = createLinkList(numsB);
        System.out.println(headA);
        System.out.println(headB);
        ListNode listNode = getIntersectionNode(headA, headB);
        System.out.println(listNode);
    }

    public static ListNode getIntersectionNode(ListNode nodeA, ListNode nodeB) {
        if (nodeA == null || nodeB == null) {
            return null;
        }
        //calculate node lengths;
        Integer nodeALength = calculateLength(nodeA);
        Integer nodeBLength = calculateLength(nodeB);
        //move nodes
        ListNode headA = nodeA;
        ListNode headB = nodeB;

        if (nodeALength > nodeBLength) {
            int i = nodeALength - nodeBLength;
            while (i > 0) {
                headA = headA.next;
                i--;
            }
            while (nodeBLength > 0) {
                if (headA.val == headB.val) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
                nodeBLength--;
            }
        } else {
            int i = nodeBLength - nodeALength;
            while (i > 0) {
                headB = headB.next;
                i--;
            }
            while (nodeALength > 0) {
                if (headA.val == headB.val) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
                nodeALength--;
            }

        }
        return null;
    }

    public static Integer calculateLength(ListNode node) {
        if (node == null)
            return 0;
        int count = 0;
        while (node.next != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public static ListNode moveNode(ListNode node, Integer index) {
        return null;

    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) { // 求链表A的长度
            lenA++;
            curA = curA.next;
        }
        while (curB != null) { // 求链表B的长度
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        // 让curA为最长链表的头，lenA为其长度
        if (lenB > lenA) {
            //1. swap (lenA, lenB);
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
            //2. swap (curA, curB);
            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        // 求长度差
        int gap = lenA - lenB;
        // 让curA和curB在同一起点上（末尾位置对齐）
        while (gap-- > 0) {
            curA = curA.next;
        }
        // 遍历curA 和 curB，遇到相同则直接返回
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }


}
