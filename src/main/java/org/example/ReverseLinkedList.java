package org.example;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * @author dingpeihua
 * @version 1.0
 * @date 2024/3/13 17:31
 */
public class ReverseLinkedList {


    /**
     * 递归反转Linked List
     *
     * @param head
     * @author dingpeihua
     * @date 2024/3/13 17:37
     * @version 1.0
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }

    /**
     * 非递归反转Linked List
     *
     * @param head
     * @author dingpeihua
     * @date 2024/3/13 17:37
     * @version 1.0
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;

    }

    public static void main(String[] args) {

    }
}
