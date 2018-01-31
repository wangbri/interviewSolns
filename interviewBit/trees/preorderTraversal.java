/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> trav = new ArrayList<>();
        
        if (A == null) {
            return trav;
        }
        
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(A);
        
        while(!nodes.empty()) {
            TreeNode node = nodes.peek();
            trav.add(node.val);
            nodes.pop();
            
            if (node.right != null) {
                nodes.push(node.right);
            }
            
            if (node.left != null) {
                nodes.push(node.left);
            }
        }
        
        return trav;
    }
}

