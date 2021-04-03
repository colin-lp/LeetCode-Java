import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int lenx=intervals.length;
        int left=newInterval[0],right=newInterval[1];
        boolean contain=false;
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<lenx;i++){
            if(intervals[i][1]<left){
                list.add(intervals[i]);
            }else if(intervals[i][0]>right){
                if(!contain){
                    contain=true;
                    list.add(new int[]{left,right});
                }
                list.add(intervals[i]);
            }else{
                left=Math.min(left,intervals[i][0]);
                right=Math.max(right,intervals[i][1]);
            }
        }
        if(!contain){
            list.add(new int[]{left,right});
        }
        return list.toArray(new int[0][]);
    }
}
