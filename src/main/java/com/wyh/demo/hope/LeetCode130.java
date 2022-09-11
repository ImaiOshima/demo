package com.wyh.demo.hope;

/**
 * @Classname LeetCode130
 * @Description TODO
 * @Date 2022/9/5 20:43
 * @Created by 61635
 * 被我围绕的区域
 */
public class LeetCode130 {
    public void solve(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                boolean flag = i == 0 || j == 0 || i == m -1 || j == n - 1;
                if(flag && board[i][j] == '0'){
                    dfs(board,i,j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board,int i,int j){
        if (i < 0 || j < 0 || i >= board.length ||
                j >= board[0].length || board[i][j] == '#' ||
                board[i][j] == 'X'){
            return;
        }
        board[i][j] = '#';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }
}
