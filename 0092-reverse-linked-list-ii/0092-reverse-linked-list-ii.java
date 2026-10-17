class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

        // Move to the node before left
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;

        // Reverse the sublist
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Connect the reversed sublist
        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = current;

        return head;
    }
}