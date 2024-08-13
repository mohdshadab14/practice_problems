package leetcode;

import java.util.Stack;

public class InvertBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                TreeNode temp;
                if(node!=null){
                    temp = node.left;
                    node.left=node.right;
                    node.right=temp;
                    if(node.left!=null) stack.push(node.left);
                    if(node.right!=null) stack.push(node.right);

                }
            }
            return root;
        }

    }
}
