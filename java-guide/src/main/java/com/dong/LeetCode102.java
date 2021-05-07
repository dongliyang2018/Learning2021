package com.dong;


import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author dongliyang
 */
public class LeetCode102 {

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
        LeetCode102 code = new LeetCode102();
        TreeNode root = code.buildTree();
        List<List<Integer>> lists = code.levelOrder(root);
        System.out.println("lists = " + lists);
    }

    //BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        //每次进入循环，开启新的层级
        while(q.size() > 0) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();

            //当前层级
            while(size > 0) {
                TreeNode cur = q.poll();
                list.add(cur.val);

                if(cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                size = size - 1;
            }

            result.add(new ArrayList<>(list));
        }
        return result;
    }

    private TreeNode buildTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        return root;
    }
}
