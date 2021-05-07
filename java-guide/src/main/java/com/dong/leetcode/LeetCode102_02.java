package com.dong.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author dongliyang
 */
public class LeetCode102_02 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        LeetCode102_02 code = new LeetCode102_02();
        TreeNode root = code.buildTree();
        List<List<Integer>> lists = code.levelOrder(root);
        System.out.println("lists = " + lists);
    }

    //DFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode node,List<List<Integer>> result,int level) {
        if (node == null) {
            return;
        }
        if (level > result.size() - 1) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(node.val);

        if (node.left != null) {
            dfs(node.left, result, level + 1);
        }
        if (node.right != null) {
            dfs(node.right, result, level + 1);
        }

    }

    private TreeNode buildTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        return root;
    }
}
