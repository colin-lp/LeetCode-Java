public class Solution {
    public int[][] generateMatrix(int n) {
        int len=n*n;
        int[][] rst=new int[n][n];
        int[][] direction=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] visited=new boolean[n][n];
        int directionIndex=0,row=0,col=0,nextRow,nextCol;
        for(int i=0;i<len;i++){
            rst[row][col]=i+1;
            visited[row][col]=true;
            nextRow=row+direction[directionIndex][0];
            nextCol=col+direction[directionIndex][1];
            if(visited[nextRow][nextCol] || nextRow>=n || nextRow<0||nextCol>=n||nextCol<0){
                directionIndex=(directionIndex+1)%4;
            }
            row+=direction[directionIndex][0];
            col+=direction[directionIndex][1];
        }
        return rst;
    }
}
