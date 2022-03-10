package com.hks.eightsortingalgorithms.leetcode;

public class bstFromPreorder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length - 1);
    }

    // 定义：将 preorder[start..end] 区间内的元素生成 BST，并返回根节点
    private TreeNode build(int[] preorder, int start, int end) {
        if(start > end) {
            return null;
        }
        int rootVal = preorder[start];
        TreeNode root = new TreeNode(rootVal);
        int index = start + 1;
        while(index < end && preorder[index] < rootVal) {
            index++;
        }
        root.left = build(preorder, start+1, index-1);
        root.right = build(preorder, index, end);
        return root;
    }
}
