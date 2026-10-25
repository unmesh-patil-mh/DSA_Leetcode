/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        // Base Condition Empty or Just one element in LinkedList
        if(head == null || head.next == null){
            return head;
        }

        // Three Pointers Method
        ListNode prev = null;
        ListNode current = head;
        ListNode next = head.next;

        // Movind current Node till Our Last
        while(current != null){
            current.next = prev; // reversing our List here
            prev = current;
            current = next;

            // Check for null pointer Exception for our next
            if(next != null){
                next = next.next;
            }
        }

        // head will be our previous node at last
        return prev;
    }
}