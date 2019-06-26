import java.util.Stack;

/**
 * 129. 求根到叶子节点数字之和
 *
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 * 输入: [1,2,3]
 *        1
 *       / \
 *      2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 *
 * 示例 2:
 * 输入: [4,9,0,5,1]
 *         4
 *        / \
 *       9   0
 *      / \
 *     5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 */
public class LeetCode129 {
    /**
     * DFS非递归
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        int total = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left == null && node.right == null){
                total += node.val;
            }
            if(node.right != null){
                node.right.val = node.val * 10 + node.right.val;
                stack.push(node.right);
            }
            if(node.left != null){
                node.left.val = node.val * 10 + node.left.val;
                stack.push(node.left);
            }
        }
        return total;
    }

    /**
     * dfs递归
     * @param root
     * @return
     */
    public int sumNumbers2(TreeNode root) {
        if(root == null){
            return 0;
        }
        return sumNumbers(root,0);
    }

    private int sumNumbers(TreeNode root ,int sum) {
        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null){
            return sum;
        }
        int left = 0;
        if(root.left != null){
            left = sumNumbers(root.left, sum);
        }
        int right = 0;
        if(root.right != null){
            right = sumNumbers(root.right, sum);
        }
        return left + right;
    }

    public static void main(String[] args) {
        LeetCode129 leetCode129 = new LeetCode129();
        System.out.println(leetCode129.sumNumbers2(TreeNode.initTreeByLoop(new Integer[]{1,2,3})));
        System.out.println(leetCode129.sumNumbers2(TreeNode.initTreeByLoop(new Integer[]{4,9,0,5,1})));
    }
}