//你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N 共有 N 层楼的建筑。 
//
// 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。 
//
// 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。 
//
// 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。 
//
// 你的目标是确切地知道 F 的值是多少。 
//
// 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？ 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：K = 1, N = 2
//输出：2
//解释：
//鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
//否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
//如果它没碎，那么我们肯定知道 F = 2 。
//因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
// 
//
// 示例 2： 
//
// 输入：K = 2, N = 6
//输出：3
// 
//
// 示例 3： 
//
// 输入：K = 3, N = 14
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= K <= 100 
// 1 <= N <= 10000 
// 
// Related Topics 数学 二分查找 动态规划 
// 👍 475 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class SuperEggDrop {
    public static void main(String[] args) {
        Solution solution = new SuperEggDrop().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int superEggDrop(int K, int N) {
            return dp(K, N);
        }

        Map<Integer, Integer> memo = new HashMap();

        public int dp(int K, int N) {
            if (!memo.containsKey(N * 100 + K)) {
                int ans;
                if (N == 0)
                    ans = 0;
                else if (K == 1)
                    ans = N;
                else {
                    int lo = 1, hi = N;
                    while (lo + 1 < hi) {
                        int x = (lo + hi) / 2;
                        int t1 = dp(K - 1, x - 1);
                        int t2 = dp(K, N - x);

                        if (t1 < t2)
                            lo = x;
                        else if (t1 > t2)
                            hi = x;
                        else
                            lo = hi = x;
                    }

                    ans = 1 + Math.min(Math.max(dp(K - 1, lo - 1), dp(K, N - lo)),
                            Math.max(dp(K - 1, hi - 1), dp(K, N - hi)));
                }

                memo.put(N * 100 + K, ans);
            }

            return memo.get(N * 100 + K);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

