package main.lesson2;
/**
 *  统计一棵二叉树中好节点的个数
 *
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 *
 * 示例 1：
 * 输入：root = [3,1,4,3,null,1,5]
 * 输出：4
 * 解释：图中蓝色节点为好节点。
 * 根节点 (3) 永远是个好节点。
 * 节点 4 -> (3,4) 是路径中的最大值。
 * 节点 5 -> (3,4,5) 是路径中的最大值。
 * 节点 3 -> (3,1,3) 是路径中的最大值。
 *
 * 示例 2：
 * 输入：root = [3,3,null,4,2]
 * 输出：3
 * 解释：节点 2 -> (3, 3, 2) 不是好节点，因为 "3" 比它大。
 * */
public class Code03_SlidingWindow {

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

    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        //根节点 永远是好节点
        return 1+dfn(root.left,root.val) + dfn(root.right,root.val);
    }

    //当前节点  父节点的值
    public static int dfn(TreeNode node,int value){
        if(node == null){
            return 0;
        }
        //当前节点值 >=  父节点的值  左右递归 更新此条路径上的父节点最大值
        if(node.val >= value){
            return 1+dfn(node.left,node.val) + dfn(node.right,node.val);
        }else { //否则  左右递归  值不变
            return dfn(node.left,value) + dfn(node.right,value);
        }
    }
}
