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
	public ListNode rotateRight(ListNode head, int k) {
		// Edge case Checking 
		if(k <= 0 || head == null || head.next == null) {
			return head;
		}
		
		ListNode last = head;
		int length = 1;
		// MOVING TOWARDS LAST NODE 
		while(last.next != null) {
			last = last.next;
			length++;
		}
		
		last.next = head;
		int rotations = k % length; // checking number of rotations that will be performed
		int skip = length - rotations;
		ListNode newLast = head;
		
		// Iterating to node where List will be rotated
		for(int i = 0; i < skip - 1 ; i++) {
			newLast = newLast.next;
		}
		
		head = newLast.next;
		newLast.next = null;
		return head;
	}
}