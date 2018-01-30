/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode headDeep = new RandomListNode(head.label);
        RandomListNode headCopy1 = headDeep;
        RandomListNode headCopy2 = head;
        
        HashMap<RandomListNode, RandomListNode> addrMap = new HashMap<>();
        addrMap.put(head, headDeep);
        
        while (head.next != null) { // add next nodes
            RandomListNode nextNode = new RandomListNode(head.next.label);
            headDeep.next = nextNode;
            addrMap.put(head.next, headDeep.next);
            
            headDeep = headDeep.next;
            head = head.next;
        }
        
        headDeep = headCopy1;
        head = headCopy2;
        
        if (head.random != null) {
            headDeep.random = addrMap.get(head.random);
        }
        
        while (head.next != null) {
            if (head.next.random != null) {
                headDeep.next.random = addrMap.get(head.next.random);
            }
            
            headDeep = headDeep.next;
            head = head.next;
        }
        
        return headCopy1;
    }
}

