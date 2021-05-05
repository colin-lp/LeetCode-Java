import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int rst=0;
        for(Integer i:set){
            if(!set.contains(i-1)){
                int conse=0;
                int num=i;
                while(set.contains(num)){
                    conse++;
                    num++;
                }
                rst=Math.max(conse,rst);
            }
        }
        return rst;
    }
}
