import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.removeDuplicates("abbaca"));

    }
    public String removeDuplicates(String S) {
        Deque<Character> queue=new LinkedList<>();
        char[] chars=S.toCharArray();
        queue.offer(chars[0]);
        for(int i=1;i<chars.length;i++){
            if(!queue.isEmpty() && queue.peekLast()==chars[i]){
                queue.removeLast();
            }else{
                queue.offerLast(chars[i]);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(Character c:queue){
            sb.append(c);
        }
        return sb.toString();
    }
}
