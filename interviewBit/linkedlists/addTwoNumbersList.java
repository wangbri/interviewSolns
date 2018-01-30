/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        int sum = A.val + B.val;
        int remainder = (A.val + B.val)%10;
        if (sum >= 10) {
            sum = sum%10;
            remainder = 1;
        } else {
            remainder = 0;
        }
        
        ListNode soln = new ListNode(sum);
        ListNode solnCopy = soln;
        A = A.next;
        B = B.next;
        
        while (A != null && B != null) {
            sum = A.val + B.val + remainder;
            if (sum >= 10) {
                sum = sum%10;
                remainder = 1;
            } else {
                remainder = 0;
            }
            
            soln.next = new ListNode(sum);
            
            A = A.next;
            B = B.next;
            soln = soln.next;
        }
        
        while (A != null) {
            sum = A.val + remainder;
            if (sum >= 10) {
                sum = sum%10;
                remainder = 1;
            } else {
                remainder = 0;
            }
            
            soln.next = new ListNode(sum);
            
            A = A.next;
            soln = soln.next;
        }
        
        while (B != null) {
            sum = B.val + remainder;
            if (sum >= 10) {
                sum = sum%10;
                remainder = 1;
            } else {
                remainder = 0;
            }
            
            soln.next = new ListNode(sum);
            
            B = B.next;
            soln = soln.next;
        }
        
        if (remainder == 1) {
            soln.next = new ListNode(1);
        }
        
        return solnCopy;
    }
}

