//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PathSumIi {
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
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
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> result = new ArrayList<>();
            backTrack(root, new ArrayList<>(), result, sum);
            return result;
        }

        private void backTrack(TreeNode node, List<Integer> path, List<List<Integer>> result, int sum) {
            if (node == null) return;
            if (node.left == null && node.right == null) {
                if (node.val == sum) {
                    path.add(node.val);
                    result.add(new ArrayList<>(path));
                    path.remove(path.size()-1);
                }
                return;
            }
            sum -= node.val;
            path.add(node.val);
            backTrack(node.left, path, result, sum);
            backTrack(node.right, path, result, sum);
            path.remove(path.size()-1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
