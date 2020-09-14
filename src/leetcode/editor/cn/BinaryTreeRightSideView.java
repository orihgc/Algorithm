//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 305 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
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
        private int level = 0;

        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> list=new ArrayList<>();
            dfs(root,list,0);
            return list;
        }

        private void dfs(TreeNode node, List<Integer> list, int depth) {
            if (node == null) return;
            if (depth >= level) {
                list.add(node.val);
                level++;
            }
            dfs(node.right, list, depth + 1);
            dfs(node.left, list, depth + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}