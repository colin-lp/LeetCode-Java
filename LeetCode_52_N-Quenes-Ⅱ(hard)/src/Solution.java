class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        int result=s.totalNQueens(4);
        System.out.println(result);
    }
    int result = 0;

    public int totalNQueens(int n) {
        int[] pos=new int[n];
        dfs(0,n,pos);
        return result;
    }

    private void dfs(int cur,int n, int[] pos) {
        for(int i=0;i<n;i++){
            if(check(cur,i,n,pos)){
                pos[cur]=i;
                if(cur==n-1){
                    this.result++;
                }else{
                    dfs(cur+1,n,pos);
                }
            }
        }
    }

    private boolean check(int cur,int i,int n,int[] pos) {
        if(cur==0) return true;
        for(int j=0;j<cur;j++){
            //行间距和列差距一样则在对角线上
            if(pos[j]==i|| Math.abs(cur-j) == Math.abs(i-pos[j])){
                return false;
            }
        }
        return true;
    }
}