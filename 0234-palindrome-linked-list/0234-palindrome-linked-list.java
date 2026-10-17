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
	public ListNode mid(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public ListNode reverse(ListNode head) {
		
		ListNode prev = null;
		ListNode current = head;
		ListNode next = current.next;
		
		while(current != null) {
			current.next = prev;
			
			prev = current;
			current = next;
			if(next != null) {
				next = next.next;
			}
			
			head = prev;
			
		}
		return head;
	}
	
	public boolean isPalindrome(ListNode head) {
		ListNode mid = mid(head);
		ListNode shead = reverse(mid);
		
		ListNode reversed = shead;
		
		while(head != null && shead != null) {
			if(head.val != shead.val) {
				break;
			}
			head = head.next;
			shead = shead.next;
		}
		
		reverse(reversed);
		
		return head == null || shead == null;
	}
}