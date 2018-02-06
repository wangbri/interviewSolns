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
    public int maxDepth(TreeNode A) {
        if (A == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(A.left);
            int rightDepth = maxDepth(A.right);
            
            if (leftDepth > rightDepth) {
                return leftDepth + 1;
            } else {
                return rightDepth + 1;
            }
        }
    }
}

