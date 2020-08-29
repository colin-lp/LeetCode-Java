import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        boolean b=s.canFinish(2,new int[][]{{0,1}});
        System.out.println(b);
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] flags=new int[numCourses];
        List<List<Integer>> ag=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            flags[i]=0;
            ag.add(new ArrayList<>());
        }
        for(int[] i : prerequisites){
            ag.get(i[1]).add(i[0]);
        }
        for(int i=0;i<numCourses;i++){
            if(!dfs(ag,i,flags)) return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> ag,int cur,int[] flags){
        if(flags[cur]==1) return false;
        if(flags[cur]==-1) return true;
        flags[cur]=1;
        for(int i:ag.get(cur)){
            if(!dfs(ag,i,flags)) return false;
        }
        flags[cur]=-1;
        return true;
    }
}