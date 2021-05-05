import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> l=new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(2);
        l.add(1);
        list.add(l);
        l=new ArrayList<>();
        l.add(3);
        l.add(1);
        l.add(2);
        list.add(l);
        l=new ArrayList<>();
        l.add(1);
        l.add(3);
        l.add(2);
        list.add(l);
        l=new ArrayList<>();
        l.add(2);
        l.add(4);
        list.add(l);
        l=new ArrayList<>();
        l.add(3);
        l.add(1);
        l.add(2);
        list.add(l);
        l=new ArrayList<>();
        l.add(1);
        l.add(3);
        l.add(1);
        l.add(1);
        list.add(l);
        l=new ArrayList<>();
        s.leastBricks(list);
    }
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<wall.size();i++){
            int sum=0;
            for(int j=0;j<wall.get(i).size()-1;j++){
                sum+=wall.get(i).get(j);
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        int rst=wall.size();
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            rst=Math.min(wall.size()-m.getValue(),rst);
        }
        return rst;
    }
}
