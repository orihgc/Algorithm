//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 257 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            dp(result,0,root);
            return result;
        }

        private void dp(List<List<Integer>> result, int level, TreeNode node) {
            if (node == null) return;
            if (result.size() <= level) {
                result.add(new ArrayList<>());
            }
            if (level % 2 == 0) {
                result.get(level).add(node.val);
            } else {
                result.get(level).add(0, node.val);
            }
            dp(result, level + 1, node.left);
            dp(result, level + 1, node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}