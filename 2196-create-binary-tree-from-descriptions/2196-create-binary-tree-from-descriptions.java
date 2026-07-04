import java.util.*;

class Solution {
    public TreeNode createBinaryTree(int[][] desc) {
        
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int[] des : desc){
            int parentVal = des[0];
            int childVal = des[1];
            int isLeft = des[2];

            TreeNode parent = map.computeIfAbsent(parentVal , k -> new TreeNode(parentVal) );
            TreeNode child = map.computeIfAbsent(childVal , k -> new TreeNode(childVal) );

            if(isLeft == 1){
                parent.left = child;
            }else{
                parent.right = child;
            }

            set.add(childVal);
        }

        for(int temp : map.keySet()){
            if(!set.contains(temp)){
                return map.get(temp);
            }
        }

        return null ;
    }
}