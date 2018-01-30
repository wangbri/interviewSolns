/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode detectCycle(ListNode a) {
        ListNode fast = a;
        ListNode slow = a;
        
        boolean hasCycle = false;
        while(fast != null && fast.next != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                hasCycle = true;
                break;
            }
        }
        
        if(!hasCycle) return null;
        
        else{
            fast = a;
            while(fast != slow){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
	}
}

