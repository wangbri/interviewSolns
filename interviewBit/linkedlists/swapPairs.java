/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode A) {
        ListNode current = A;
        int temp = 0;
        ListNode firstNode = null;
        ListNode secondNode = null;
        int count = 0;
        
        while (current != null) {
            if (count < 1) {
                firstNode = current;
                current = current.next;
                count++;
            } else if (count < 2) {
                secondNode = current;
                current = current.next;
                count = 0;
                
                temp = secondNode.val;
                secondNode.val = firstNode.val;
                firstNode.val = temp;
            }
        }
        
        return A;
    }
}

