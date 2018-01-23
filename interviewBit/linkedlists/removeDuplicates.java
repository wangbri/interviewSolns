/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode A) {
        ListNode current = A;
        ListNode temp = null;
        ListNode prev = null;
        int currentVal = -1;
        
        while (current != null) {
            if (currentVal != current.val) {
                currentVal = current.val;
            } else { // deletion necessary
                temp = current;
                current = prev;
                current.next = temp.next;
            }
            
            prev = current;
            current = current.next;
        }
        
        return A;
    }
}

