public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int total=0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0) {
                total += customers[i];
            }
        }
        int max;
        int increase=0;
        for(int i=0;i<X;i++){
            increase+=customers[i]*grumpy[i];
        }
        max=increase;
        for(int i=X;i<customers.length;i++){
            increase=increase-customers[i-X]*grumpy[i-X]+customers[i]*grumpy[i];
            max=Math.max(max,increase);
        }
        return max+total;
    }
}