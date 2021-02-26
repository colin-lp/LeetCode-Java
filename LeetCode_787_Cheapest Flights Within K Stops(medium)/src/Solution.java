import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    Integer min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.findCheapestPrice(3,new int[][]{{0,1,100},{1,2,100},{0,2,500}},0,2,1));

    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        HashMap<Integer, List<int[]>> map=new HashMap<>();
        for(int i=0;i<flights.length;i++){
            if(map.containsKey(flights[i][1])){
                map.get(flights[i][1]).add(flights[i]);
            }else{
                List<int[]> list=new ArrayList<>();
                list.add(flights[i]);
                map.put(flights[i][1],list);
            }
        }
        dfs(map,src,dst,K,0);
        return min==Integer.MAX_VALUE?-1:min;
    }

    public void dfs(HashMap<Integer, List<int[]>> map,int oSrc,int src,int K,int cost){
        if(oSrc==src){
            min=Math.min(min,cost);
            return;
        }
        if(!map.containsKey(src)||K<0){
        }else{
            for(int[] i:map.get(src)){
                if(cost+i[2]>min){
                    continue;
                }
                dfs(map,oSrc,i[0],K-1,cost+i[2]);
            }
        }
    }
}
