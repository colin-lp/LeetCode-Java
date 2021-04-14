import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }

    //todo 官方 贪心 空间O(1)

    //双栈 空间O(n)
    public boolean checkValidString(String s) {
        Deque<Integer> stars=new LinkedList<>();
        Deque<Integer> paren=new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                paren.push(i);
            } else if(s.charAt(i)==')'){
                if(paren.peek()!=null){
                    paren.pop();
                }else if(stars.peek()!=null){
                    stars.pop();
                }else{
                    return false;
                }
            } else if(s.charAt(i)=='*'){
                stars.push(i);
            }
        }
        if(paren.isEmpty()) return true;

        //stars.peek()>paren.peek()
        //stars.pop();  这两个地方没想出来 标记一下
        while(stars.peek()!=null && !paren.isEmpty() && stars.peek()>paren.peek()){
            paren.pop();
            stars.pop();
        }
        return paren.isEmpty();
    }
}
