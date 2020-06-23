//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        private List<Integer> result = new ArrayList<Integer>();

        public List<Integer> inorderTraversal(TreeNode root) {
            if(root!=null){
                inorderTraversal(root.left);
                result.add(root.val);
                inorderTraversal(root.right);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
