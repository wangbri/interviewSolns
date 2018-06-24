/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        if (l1 == null && l2 == null) {
            return l1;
        }
        
        ListNode l1Next = l1;
        ListNode l2Next = l2;
        ListNode soln = l2;
        
        while (l1.next != null && l2.next != null) {
            l2Next = l2.next; // save next
            l2.next = l1Next;
            l2 = l2Next;
            l1Next = l1.next; // save next
            l1.next = l2Next;
            l1 = l1Next;
        }
        
        if (l1.next == null && l2.next == null) {
            l2.next = l1Next;
            return soln;
        }
        
        if (l2.next != null) { // l2.next is null
            l2Next = l2.next;
            l2.next = l1;
            l1.next = l2Next;
        }
        
        if (l1.next != null) { // l1.next is null
            l2.next = l1Next;
        }
        
        return soln;
    }
}
