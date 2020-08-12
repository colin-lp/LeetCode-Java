import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        List<List<Integer>> result=s.palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"});
        for(List<Integer> l : result){
            System.out.println(l.get(0)+","+l.get(1));
        }
    }
    public List<List<Integer>> palindromePairs(String[] words) {

    }
}
