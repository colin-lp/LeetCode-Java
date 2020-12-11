import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution t=new Solution();
        String r=t.predictPartyVictory("RRRRRDDDDDD");
        System.out.print(r);
    }

    public String predictPartyVictory(String senate) {
        Queue<Integer> rq=new LinkedList<>();
        Queue<Integer> dq=new LinkedList<>();
        for(int i=0;i<senate.length();i++){
            char t=senate.charAt(i);
            if(t=='R'){
                rq.offer(i);
            }
            if(t=='D'){
                dq.offer(i);
            }
        }
        while(!rq.isEmpty() && !dq.isEmpty()){
            Integer r=rq.poll();
            Integer d=dq.poll();
            if(r<d){
                rq.offer(r+senate.length());
            }else{
                dq.offer(d+senate.length());
            }
        }
        return rq.isEmpty()?"Dire":"Radiant";
    }
}
