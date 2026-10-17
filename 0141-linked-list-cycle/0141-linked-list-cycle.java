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
        public boolean hasCycle(ListNode head) {
    	// FAST AND SLOW POINTER IN LINKED LIST
        ListNode fast = head;
        ListNode slow = head;
        
        // TILL WE DIDN'T GET TO LAST
        while(fast != null && fast.next != null) {
        	fast = fast.next.next; // moving two steps at a time
        	slow = slow.next; // moving one step at a time
        	
        	
        	// IF FAST AND SLOW MEET MEANS THE LINKED LIST IS CYCLIC
        	if(fast == slow) {
        		return true;
        	}
        }
        
        return false;
    }
}