import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10},5));
    }
    public int shipWithinDays(int[] weights, int D) {
        int count= Arrays.stream(weights).sum();
        int max=Arrays.stream(weights).max().orElse(0);

        int r=count,l=max;
        while(l<r){
            int mid=(r-l)/2+l;
            if(check(weights,mid,D)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return r;
    }

    private boolean check(int[] weights,int weight,int days){
        // *日期计算从1开始
        int tempDays=1,tempWeight=0;
        for(int i=0;i<weights.length;i++){
            if((tempWeight+weights[i])>weight){
                tempWeight=weights[i];
                tempDays++;
            }else{
                tempWeight+=weights[i];
            }
            if(tempDays>days) return false;
        }
        return true;
    }
}
