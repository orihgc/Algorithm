//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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
         */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> re = new ArrayList<>();
//        dp(root, re, 0);
//        return re;
//    }
//
//    private void dp(TreeNode root, List<List<Integer>> re, int level) {
//        if (root != null) {
//            if (re.size() <= level) re.add(new ArrayList<>());
//            re.get(level).add(root.val);
//            dp(root.left, re, level + 1);
//            dp(root.right, re, level + 1);
//        }
//    }
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> re = new ArrayList<>();
            if (root == null) return re;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<TreeNode> cur = new ArrayList<>(queue);
                re.add(0,cur.stream().map(x -> x.val).collect(Collectors.toList()));
                queue.clear();
                for (TreeNode treeNode : cur) {
                    if (treeNode.left != null) {
                        queue.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.add(treeNode.right);
                    }
                }
            }
            return re;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
