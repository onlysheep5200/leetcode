package problem80;

import java.util.Stack;

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
        boolean isExists = false;
        Stack<Item> stack = new Stack<>();
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return false;
        int m = board.length,n = board[0].length;
        if (m*n<word.length())
            return false;
        for (int i = 0;i<m;i++){
            for (int j =0;j<n;j++){
                if (board[i][j] == word.charAt(0))
                {
                    stack.push(new Item(i,j,board[i][j],0));
                    int current = 1;
                    board[i][j] = '*';
                    while (!stack.empty()){
                        if (current >= word.length())
                            return true;
                        Item peek = stack.peek();
                        if (peek.direction == 0 )
                        {
                            peek.direction = 1;
                            if (peek.x > 0 && board[peek.x-1][peek.y] == word.charAt(current)){
                                stack.push(new Item(peek.x-1,peek.y,board[peek.x-1][peek.y],0));
                                board[peek.x-1][peek.y] = '*';
                                current ++;
                                continue;
                            }
                        }
                        if (peek.direction == 1)
                        {
                            peek.direction = 2;
                            if (peek.x < m-1 && board[peek.x+1][peek.y] == word.charAt(current)){
                                stack.push(new Item(peek.x+1,peek.y,board[peek.x+1][peek.y],0));
                                board[peek.x+1][peek.y] = '*';
                                current += 1;
                                continue;
                            }
                        }
                        if (peek.direction == 2)
                        {
                            peek.direction = 3;
                            if (peek.y > 0 && board[peek.x][peek.y-1] == word.charAt(current)){
                                stack.push(new Item(peek.x,peek.y-1,board[peek.x][peek.y-1],0));
                                board[peek.x][peek.y-1] = '*';
                                current += 1;
                                continue;
                            }
                        }

                        if (peek.direction == 3)
                        {
                            peek.direction = 4;
                            if (peek.y < n-1 && board[peek.x][peek.y+1] == word.charAt(current)){
                                stack.push(new Item(peek.x,peek.y+1,board[peek.x][peek.y+1],0));
                                board[peek.x][peek.y+1] = '*';
                                current += 1;
                                continue;
                            }
                        }
                        Item p = stack.pop();
                        board[p.x][p.y] = p.c;
                        current--;
                    }
                }
            }
        }

        return false;
    }

    class Item {
        int x;
        int y;
        char c;
        int direction; //0-上，1-下,2-左,3-右

        public Item(int x, int y, char c, int direction) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.direction = direction;
        }
    }

    public static void main(String[] args){
        char[][] board = {
                {'A', 'B'},
                {'C','D'},
        };
        Solution s = new Solution();
        System.out.println(s.exist(board,"DBAC"));
    }
}
