package com.wyh.demo.hope;

/**
 * @author imai
 * @since 2022/9/1 4:27 下午
 * 恢复二叉搜索树
 */
public class LeetCode99 {
    /**
     * 不需要额外空间 进行二叉树 恢复 莫里斯遍历的变形 中序遍历
     * @param root
     */
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode y = null;
        TreeNode x = null;
        TreeNode tmp = null;
        TreeNode pre = null;
        while(root != null){
            if(root.left != null){
                tmp = root.left;
                // 不断的找到当前节点的最右节点 以便于节点的有指针只想root节点 形成闭环
                // 当联结完成是 作用就是找到root为前面的节点的最有节点 进行最右子树的节点切除
                while(tmp.right != null && tmp.right != root){
                    tmp = tmp.right;
                }
                if(tmp.right == null){
                    tmp.right = root;
                    root = root.left;
                }else{
                    if(pre != null && pre.val > root.val){
                        y = root;
                        if(x == null){
                            x = pre;
                        }
                    }
                    pre = root;
                    tmp.right = null;
                    root = root.right;
                }
            }else{
                if(pre != null && pre.val > root.val){
                    y = root;
                    if(x == null){
                        //因为只有两个数字的变换
                        //所以直接记住中间的家伙 在与最后一次错误的家伙 进行交换 就是一个具有顺序的搜索树了
                        x = pre;
                    }
                }
                //因为能到这里说明左子树的最右节点全部 与上面的节点进行了连接结束了
                pre = root;
                root = root.right;
            }
        }
        swap(x,y);
    }

    /**
     * 超级简单的置换方法
     * @param a
     * @param b
     */
    public void swap(TreeNode a,TreeNode b){
        if(a != null && b != null) {
            int tmp = b.val;
            b.val = a.val;
            a.val = tmp;
        }
    }
}
