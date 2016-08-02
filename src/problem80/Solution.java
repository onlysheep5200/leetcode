package problem80;

/**
 * Created by yaodong.hyd on 2016/8/2.
 */
public class Solution {

    /**
     * 回溯法
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
       return false;
    }

    public static void main(String[] args){
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        Solution s = new Solution();
        System.out.println(s.exist(board,"SEE"));
    }
}
