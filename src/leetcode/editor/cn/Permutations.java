//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 773 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> re=new ArrayList<>();
            backTrack(new ArrayList<>(),re,nums);
            return re;
        }

        private void backTrack(List<Integer> path, List<List<Integer>> result, int[] nums) {
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (path.contains(nums[i])) continue;
                path.add(nums[i]);
                backTrack(path, result, nums);
                path.remove(path.size() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}