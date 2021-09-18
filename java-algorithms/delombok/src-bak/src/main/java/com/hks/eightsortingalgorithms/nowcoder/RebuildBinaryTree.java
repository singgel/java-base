package com.hks.eightsortingalgorithms.nowcoder;

/**
 * @Author: hekuangsheng
 * @Date: 2018/10/25
 * <p>
 * <p>
 * <p>
 * 递归思想，每次将左右两颗子树当成新的子树进行处理，中序的左右子树索引很好找，
 * <p>
 * 前序的开始结束索引通过计算中序中左右子树的大小来计算，然后递归求解，
 * <p>
 * 直到startPre>endPre||startIn>endIn说明子树整理完到。
 * <p>
 * 方法每次返回左子树活右子树的根节点
 */
public class RebuildBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }

}
