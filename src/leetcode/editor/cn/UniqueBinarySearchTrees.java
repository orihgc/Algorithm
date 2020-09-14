//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划 
// 👍 765 👎 0

package leetcode.editor.cn;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
        System.out.println(solution.numTrees(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * G(n)表示长度为n能构成的二叉搜索树的个数
         * F(i,n)表示以i为根长度为n的不同二叉搜索树的个数
         * F(i,n)=G(i-1)*G(n-i)左子树和右子树集合的笛卡尔积
         */
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];
        }

        /**
         * 直接有递推公式G(n)=G(n-1)*2*(2n+1)/(n+2)
         *
         * */
    }
//leetcode submit region end(Prohibit modification and deletion)

}