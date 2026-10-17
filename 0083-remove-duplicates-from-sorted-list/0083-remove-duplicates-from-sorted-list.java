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
	public ListNode deleteDuplicates(ListNode head) {
		ListNode node = head;
		
		// TILL OUR LINKED LIST NOT END TILL LAST
		while(node != null && node.next != null) {
			if(node.val == node.next.val) {
				// Skip this to next
				node.next = node.next.next;
				
			}else {
				node = node.next; // If no duplicate move to next Node
			}
		}
        return head;
	}
}