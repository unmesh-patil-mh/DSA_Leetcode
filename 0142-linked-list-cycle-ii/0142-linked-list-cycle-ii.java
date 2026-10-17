/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int lengthCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;

        if (fast == slow) {
            ListNode temp = slow;
            int length = 0;

            do {
                temp = temp.next;
                length++;
            } while (temp != slow);

            return length;
        }
    }

    return 0;
}

public ListNode detectCycle(ListNode head) {
    int length = 0;
    ListNode fast = head;
    ListNode slow = head;

    // Step 1: Detect the cycle
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;

        if (fast == slow) {
            length = lengthCycle(slow);
            break;
        }
    }

    // Step 2: No cycle found
    if (length == 0) {
        return null;
    }

    // Step 3: Move end ahead by cycle length
    ListNode start = head;
    ListNode end = head;

    while (length > 0) {
        end = end.next;
        length--;
    }

    // Step 4: Find the cycle starting node
    while (start != end) {
        start = start.next;
        end = end.next;
    }

    return start;
}
}