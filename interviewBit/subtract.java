/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode subtract(ListNode A) {
        ListNode curNode = A;
        ListNode tempNode = A;
        int tempCount = 1;
        int listSize = 1;
        int halfSize = 0;
        
        while (curNode.next != null) { // iterate to last node
            curNode = curNode.next;
            listSize++;
        }
        
        halfSize = listSize/2;
        curNode = A;
        
        for (int i = 0; i < halfSize; i++) { // for each node in the first half
            while (tempCount != listSize) { // iterate to second half of nodes
                tempNode = tempNode.next;
                tempCount++;
            }
            
            listSize--;
            curNode.val = tempNode.val - curNode.val;
            curNode = curNode.next;
            tempCount = 1;
            tempNode = A;
        }
        
        return A;
    }
}
