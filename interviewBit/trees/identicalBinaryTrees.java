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
    public int isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        }
        
        if (A != null && B != null) {
            if (A.val == B.val) {
                if (isSameTree(A.left, B.left) + isSameTree(A.right, B.right) == 2) {
                    return 1;
                }
            }
        }
        
        return 0;
    }
}

