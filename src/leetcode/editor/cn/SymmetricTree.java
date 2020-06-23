//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        /**
         * dp
         * */
//        public boolean isSymmetric(TreeNode root) {
//            if (root == null) return true;
//            return isMirror(root.left, root.right);
//        }
//
//        private boolean isMirror(TreeNode leftTree, TreeNode rightTree) {
//            if (leftTree == null && rightTree == null) return true;
//            if (leftTree == null || rightTree == null) return false;
//            if (leftTree.val != rightTree.val) return false;
//            return isMirror(leftTree.left, rightTree.right) && isMirror(leftTree.right, rightTree.left);
//        }

        /**
         * bp
         */
        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode t1 = queue.poll();
                TreeNode t2 = queue.poll();
                if (t1 == null && t2 == null) continue;
                if (t1 == null || t2 == null) return false;
                if (t1.val != t2.val) return false;
                queue.add(t1.left);
                queue.add(t2.right);
                queue.add(t1.right);
                queue.add(t2.left);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
