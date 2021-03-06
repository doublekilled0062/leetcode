import java.util.LinkedList;
import java.util.Stack;

/**
 * 98. 验证二叉搜索树
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *       2
 *      / \
 *     1   3
 * 输出: true
 *
 * 示例 2:
 * 输入:
 *      5
 *     / \
 *    1   4
 *       / \
 *      3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class LeetCode98 {
    /**
     * 递归
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }else if(root.left != null && root.right == null){
            return root.val > root.left.val && isValidBST(root.left) && root.val > getMaxValue(root.left);
        }else if(root.left == null && root.right != null){
            return root.val < root.right.val && isValidBST(root.right) && root.val < getMinValue(root.right);
        }else {
            return root.val > root.left.val && isValidBST(root.left) && root.val < root.right.val && isValidBST(root.right) && root.val > getMaxValue(root.left) && root.val < getMinValue(root.right);
        }
    }

    /**
     * 取搜索树的最小值
     * @return
     */
    private int getMinValue(TreeNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        TreeNode node = root;
        while (node.left != null){
            node = node.left;
        }
        return node.val;
    }

    private int getMaxValue(TreeNode root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        TreeNode node = root;
        while (node.right != null){
            node = node.right;
        }
        return node.val;
    }

    /**
     * 非递归中序
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if(root == null){
            return true;
        }
        //中序遍历辅助栈
        Stack<TreeNode> stack = new Stack<>();
        //结果栈
        LinkedList<Integer> list = new LinkedList<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()){
            if(curNode != null){
                stack.push(curNode);
                curNode = curNode.left;
            }else {
                curNode = stack.pop();
                if(!list.isEmpty() && curNode.val <= list.peek()){
                    return false;
                }
                list.push(curNode.val);
                curNode = curNode.right;
            }
        }
        return true;
    }
}
