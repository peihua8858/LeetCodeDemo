package org.example;

/**
 * https://leetcode.cn/problems/linked-list-cycle/description/
 * 利用快慢指针方式
 *
 * @author dingpeihua
 * @version 1.0
 * @date 2024/3/13 18:08
 */
public class CycleLinkedList {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
