import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        s.numRabbits(new int[]{1,0,1,0,0});
        s.numRabbitsOfficial(new int[]{1,0,1,0,0});
    }

    //ceil
    public int numRabbitsOfficial(int[] answers){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<answers.length;i++){
            map.put(answers[i]+1,map.getOrDefault(answers[i]+1,0)+1);
        }
        int rst=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            rst+=ceil(entry.getValue(),entry.getKey());
        }
        return rst;
    }

    private int ceil(int x,int y){
        return x%y==0?x/y*y:((x/y)+1)*y;
    }

    //count
    public int numRabbits(int[] answers) {
        int rst = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            if(answers[i]==0) {
                rst++;
                continue;
            }
            if (map.containsKey(answers[i] + 1)) {
                if (map.get(answers[i] + 1) == 0) {
                    map.put(answers[i] + 1, answers[i]);
                } else {
                    map.put(answers[i] + 1, map.get(answers[i] + 1) - 1);
                    if (map.get(answers[i] + 1) == 0) {
                        rst += answers[i] + 1;
                    }
                }
            } else {
                map.put(answers[i] + 1, answers[i]);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()==0) continue;
            rst += entry.getKey();
        }
        return rst;
    }
}
