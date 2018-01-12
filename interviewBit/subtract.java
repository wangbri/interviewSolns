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
        ListNode secondHalfHead;
        int firstHalfSize = 1;
        int listSize = 1;
        boolean isOdd = false;
        
        while (curNode.next != null) {
            listSize++;
            curNode = curNode.next;
        }
        
        if (listSize == 1) {
            return A;
        }
        
        curNode = A;
        
        while (tempNode.next != null && tempNode.next.next != null) { // iterate to middle of linked list
            tempNode = tempNode.next.next;
            curNode = curNode.next;
            firstHalfSize++;
        }
   
        tempNode = A;
        curNode = curNode.next;
        curNode = reverseList(curNode); // reverse second half of list
        secondHalfHead = curNode; // save head of second half of list
        
        if (listSize % 2 != 0) { // if list is odd-sized, round down
            firstHalfSize--;
            isOdd = true;
        }
        
        for (int i = 0; i < firstHalfSize; i++) {
            tempNode.val = curNode.val - tempNode.val;
            
            if (i != firstHalfSize - 1) {
                tempNode = tempNode.next;
            }
            curNode = curNode.next;
        }
        
        if (isOdd) { // skip middle element for odd cases
            tempNode = tempNode.next;
        }
        
        curNode = reverseList(secondHalfHead);
        tempNode.next = curNode;
        
        return A;
    }
    
    public ListNode reverseList(ListNode A) {
        ListNode curNode = A;
        ListNode prevNode = null;
        ListNode nextNode = null;
        
        while (curNode != null) {
            nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }

        A = prevNode;
        
        return A;
    }
}

