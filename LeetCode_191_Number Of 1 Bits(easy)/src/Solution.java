public class Solution {
    public int hammingWeight(int n) {
        int rst=0;
        while(n!=0){
            if((n&1)==1){
                rst++;
            }
            n>>>=1;
        }
        return rst;
    }
}
