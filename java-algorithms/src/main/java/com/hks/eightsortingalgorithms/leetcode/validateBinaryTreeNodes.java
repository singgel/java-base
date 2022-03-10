package com.hks.eightsortingalgorithms.leetcode;

public class validateBinaryTreeNodes {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // 记录每个节点的入度
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                indegree[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                indegree[rightChild[i]]++;
            }
        }
        // 按道理应该有且只有根节点的入度为 0，
        // 其他节点的入度都必须为 1
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                if (root != -1) {
                    // 有多个入度为 0 的节点
                    return false;
                }
                root = i;
            } else if (indegree[i] != 1) {
                // 除了根节点外其他节点的入度都必须为 1
                return false;
            }
        }

        // 如果没有根节点，那肯定不是合法二叉树
        if (root == -1) {
            return false;
        }

        // 为了凸显二叉树遍历框架，我把这些都作为全局变量
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.visited = new boolean[n];

        // 用二叉树遍历框架进行遍历，
        // 保证树中只有一个联通分量且不成环
        traverse(root);
        // 遍历过程中发现成环了，说明肯定不是二叉树
        if (hasCycle) {
            return false;
        }
        // 如果一次遍历没有经过所有节点，也说明不是二叉树
        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                return false;
            }
        }
        // 能通过上面的检测，判定是一棵二叉树
        return true;
    }

    int[] leftChild, rightChild;
    // 记录遍历过的节点，防止成环
    boolean[] visited;
    boolean hasCycle = false;

    // 二叉树遍历函数
    void traverse(int root) {
        if (root == -1 || hasCycle) {
            return;
        }
        // 走了回头路，说明成环了
        if (visited[root]) {
            hasCycle = true;
            return;
        }
        visited[root] = true;

        traverse(leftChild[root]);
        traverse(rightChild[root]);
    }

}
