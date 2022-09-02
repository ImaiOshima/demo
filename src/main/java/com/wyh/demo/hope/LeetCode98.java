package com.wyh.demo.hope;

/**
 * @author imai
 * @since 2022/9/1 10:09 上午
 * 验证二叉树
 */
public class LeetCode98 {
    long pre = Long.MIN_VALUE;

    /**
     * 总体逻辑 就是进行中序遍历 然后进行当前节点数据与前一个数据进行判断 大于的话 没问题 小于的话 直接返回结束
     * stack 把左节点的函数押进来处理 在弹出去 再把右节点的函数要进来 进行出来 在弹出来
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        //递归肯定得有个终止点 终止点
        if(root == null){
            return true;
        }
        //递归开始 可以想象成stack 有多个isValidBST函数被压进去了
        //你现在能执行下去的可能只能在终止点返回为true 即树中的叶子节点
        //当前函数是左节点放进去 所以是树的最左边的叶子节点
        if(!isValidBST(root.left)){
            return false;
        }
        //如果不是叶子节点的话 已当前节点的数据是否大于前一个节点的数据 进行判断来 进行二叉树的判断
        //第一次判断是 因为是树的叶子节点 没有其他认为可以比较的数值 只能设定一个 再次进行
        if(root.val < pre){
            return false;
        }
        //记住当前节点数据 一以便进行下一次判断
        pre = root.val;
        //右子树 判断当前右子树中的数据 是否大于中间节点 且 自己的子节点是否满足要求
        return isValidBST(root.right);
    }
    //树的含义 就是我来根据左右子树给我的东西进行处理
}
