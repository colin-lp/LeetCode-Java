import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        int result=s.totalNQueens(4);
        System.out.println(result);
    }
    int result = 0;

    HashSet<Integer> col=new HashSet<>();
    HashSet<Integer> diagonals1=new HashSet<>();
    HashSet<Integer> diagonals2=new HashSet<>();
    public int totalNQueens(int n) {
        return dfs(n,0);
    }

    private int dfs(int n,int row){
        if(row==n) return 1;
        int count=0;
        for(int i=0;i<n;i++){
            if(col.contains(i)) continue;
            int dia1=row-i;
            if(diagonals1.contains(dia1)) continue;
            int dia2=row+i;
            if(diagonals1.contains(dia2)) continue;
            col.add(i);
            diagonals1.add(i);
            diagonals2.add(i);
            count+=dfs(n,row+1);
            col.remove(i);
            diagonals1.remove(i);
            diagonals2.remove(i);
        }
        return count;
    }
}