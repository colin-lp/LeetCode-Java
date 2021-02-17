import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int minKBitFlips(int[] A, int K) {
        int n=A.length;
        int rst=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(!q.isEmpty()&&q.peek()+K==i){
                q.poll();
            }
            if(q.size()%2==A[i]){
                if(i+K>n) return -1;
                rst++;
                q.offer(i);
            }
        }
        return rst;
    }
}
