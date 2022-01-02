package com.wyh.demo.algorithm2;

/**
 * @author imai
 * @since 2021/4/26 9:21 下午
 * LeetCode 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class Solution200 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                     dfs(grid,i,j);
                     count++;
                }
            }
        }
        return count;
    }
    /**
     * 把一座岛到变成陆地
     */
    public void dfs(char[][] grid,int i,int j){
        //base
        if( i<0||i>grid.length-1||j<0||j>grid[0].length -1){
            return;
        }
        if(grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
    }
}
