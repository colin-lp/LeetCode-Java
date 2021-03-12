import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.calculate(" 2-1 + 2 "));
    }
    public int calculate(String s) {
        LinkedList<Integer> list=new LinkedList<>();
        int sign=1;
        int rst=0;
        list.push(1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                continue;
            }else if(s.charAt(i)=='+'){
                //+(+)=+ -(+)=-
                sign=list.peek();
            }else if(s.charAt(i)=='-'){
                //+(-)=- -(-)=+
                sign=-list.peek();
            }else if(s.charAt(i)=='('){
                list.push(sign);
            }else if(s.charAt(i)==')'){
                list.pop();
            }else {
                int num=0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    num=num*10+s.charAt(i)-'0';
                    i++;
                }
                i--;
                rst+=num*sign;
            }
        }
        return rst;
    }
}
