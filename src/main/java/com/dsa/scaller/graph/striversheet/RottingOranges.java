package com.dsa.scaller.graph.striversheet;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    class Pair{
        int r;
        int c;
        int t;

        Pair(int r, int c, int t){
            this.r = r;
            this.c= c;
            this.t=t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int row =grid.length;
        int col = grid[0].length;
        int totalOrange =0;

        Queue<Pair> queue = new LinkedList<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    queue.add(new Pair(i,j,0));
                }

                if(grid[i][j] !=0){
                    totalOrange++;
                }
            }
        }
        int res = 0;
        int[] dRow ={-1,0,1,0};
        int[] dCol ={0,1,0,-1};
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            totalOrange--;
            res = pair.t;

            for(int i=0;i<4;i++){
                int r = pair.r +dRow[i];
                int c = pair.c+dCol[i];
                if(r>=0 && r<row && c>=0 && c<col && grid[r][c]==1){
                    grid[r][c]=2;
                    queue.add(new Pair(r,c,pair.t+1));
                }
            }
        }
        if(totalOrange==0) return res;

        return -1;
    }

    public static void main(String[] args){
        new RottingOranges().orangesRotting(new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        });
    }
}
