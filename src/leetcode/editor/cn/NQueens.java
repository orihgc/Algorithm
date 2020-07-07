//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 455 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        solution.solveNQueens(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    str.append('.');
                }
                list.add(str.toString());
            }
            backTrack(list, 0);
            return res;
        }

        private void backTrack(List<String> path, int row) {
            if (row == path.size()) {
                res.add(new ArrayList<>(path));
                return;
            }
            int length = path.get(row).length();
            for (int col = 0; col < length; col++) {
                if (!isValid(path, row, col)) continue;
                path.set(row, change(path.get(row), col, 'Q'));
                backTrack(path, row + 1);
                path.set(row, change(path.get(row), col, '.'));
            }
        }

        private String change(String str, int index, char c) {
            String str1 = str.substring(0, index);
            String str2 = str.substring(index + 1);
            return str1 + c + str2;
        }

        private boolean isValid(List<String> board, int row, int col) {
            int size = board.size();
            for (int i = 0; i < size; i++) {
                if (board.get(i).charAt(col) == 'Q') return false;
            }
            for (int i = row - 1, j = col + 1; i >= 0 && j < size; i--, j++) {
                if (board.get(i).charAt(j) == 'Q') return false;
            }
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board.get(i).charAt(j) == 'Q') return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}