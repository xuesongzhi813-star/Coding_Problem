# 寻找二叉搜索树的第K小的数笔记

## 题目解析

寻找整个二叉搜索树中第k个小的数，利用二叉搜索树的性质：  
- 左子树一定小于根节点
- 右子树一定大于根节点

## 解题策略

采用中序遍历：二叉搜索树经过中序遍历是“有序升序数组”，因此，进行中序遍历，找到第K个即可


细节补充：
- 关注计数器count==0，则结束
- 判断完再--k，提前赋值第k个小的数

```
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
    //定义全局变量，count作为记录求第几小的数，res记录最终答案
    int count;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        //判断是否是空树
        if(root==null){
            return -1;
        }
        count=k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root){
        //递归出口
        if(root==null){
            return;
        }
        //中序遍历：左->中->右
        dfs(root.left);
        //判断k是否已经找到，找到则退出
        if(count==0){
            return;
        }
        //判断是否找到第K个赋值
        if(--count==0){
            res=root.val;
        }
        //寻找右子树
        dfs(root.right);
    }
}
```
