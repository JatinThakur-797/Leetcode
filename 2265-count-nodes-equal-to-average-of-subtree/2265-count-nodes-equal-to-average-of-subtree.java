/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;
    public int[] helper(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int count = left[0] + right[0] + 1;
        int val = left[1] + right[1] + root.val;

        int avg = val / count;
        if(avg == root.val){
            ans++;
        }

        return new int[]{count,val};
    }

    public int averageOfSubtree(TreeNode root) {
            int[] arr = helper(root);
            return ans;
    }
}