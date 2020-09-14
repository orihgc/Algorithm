//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划 
// 👍 796 👎 0

package leetcode.editor.cn;

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        solution.coinChange(new int[]{1, 2, 5}, 11);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            for (int i = 0; i < dp.length; i++) {
                dp[i]=amount+1;
            }
            dp[0] = 0;
            for (int i = 0; i < dp.length; i++) {
                for (int coin : coins) {
                    if (i >= coin) {
                        dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                    }
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }


        /**
         * 递归遍历所有可能的情况
         */
        private int dp(int[] coins, int amount) {
            if (amount == 0) return 0;
            if (amount < 0) return -1;
            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                int subProblem = dp(coins, amount - coin);
                if (subProblem == -1) continue;
                res = Math.min(res, subProblem + 1);
            }
            if (res == Integer.MAX_VALUE) {
                return -1;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}