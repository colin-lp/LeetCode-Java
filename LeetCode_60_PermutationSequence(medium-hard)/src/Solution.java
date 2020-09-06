import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String result = s.getPermutation(9, 1);
        System.out.print(result);
    }

    public String getPermutation(int n, int k) {
        int[] factorial= new int[n];
        factorial[0]=1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i-1]*i;
        }
        k--;
        StringBuilder sb=new StringBuilder();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=1;i<=n;i++){
            int order=k/factorial[n-i]+1;
            for(int j=1;j<=n;j++){
                if(!map.containsKey(j)){
                    order--;
                }
                if(order==0){
                    sb.append(j);
                    map.put(j,1);
                    break;
                }
            }
            k%=factorial[n-i];
        }
        return sb.toString();
    }
}