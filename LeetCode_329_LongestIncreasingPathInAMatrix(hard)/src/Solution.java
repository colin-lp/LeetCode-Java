class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0) return 0;
        int result=1;
        int[][] m=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int count=CountRoads(matrix,i,j,m);
                result=Math.max(count,result);
            }
        }
        return result;
    }

    public int CountRoads(int[][] matrix,int curi,int curj,int[][] m){
        if(curi>=0&&curi<matrix.length&&curj>=0&&curj<=matrix[0].length&&m[curi][curj]!=0) return m[curi][curj];
        m[curi][curj]=1;
        if(curj>0){
            if(matrix[curi][curj]<matrix[curi][curj-1]){
                m[curi][curj]=Math.max(CountRoads(matrix,curi,curj-1,m)+1,m[curi][curj]);
            }
        }
        if(curj<matrix[0].length-1){
            if(matrix[curi][curj]<matrix[curi][curj+1]){
                m[curi][curj]=Math.max(CountRoads(matrix,curi,curj+1,m)+1,m[curi][curj]);
            }
        }
        if(curi>0){
            if(matrix[curi][curj]<matrix[curi-1][curj]){
                m[curi][curj]=Math.max(CountRoads(matrix,curi-1,curj,m)+1,m[curi][curj]);
            }
        }
        if(curi<matrix.length-1){
            if(matrix[curi][curj]<matrix[curi+1][curj]){
                m[curi][curj]=Math.max(CountRoads(matrix,curi+1,curj,m)+1,m[curi][curj]);
            }
        }
        return m[curi][curj];
    }
}