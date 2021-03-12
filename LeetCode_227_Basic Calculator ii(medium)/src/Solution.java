import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.calculate("1+2*2"));
    }
    LinkedList<Integer> nums=new LinkedList<>();
    LinkedList<Character> opts=new LinkedList<>();
    public int calculate(String s) {
        HashMap<Character,Integer> optMap=new HashMap<>();
        optMap.put('+',0);
        optMap.put('-',0);
        optMap.put('*',1);
        optMap.put('/',1);
        int tempNum=0;
        nums.push(0);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                continue;
            }else if(Character.isDigit(s.charAt(i))){
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    tempNum = tempNum * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                nums.push(tempNum);
                tempNum=0;
            }else{
                char c=s.charAt(i);
                while(!opts.isEmpty()){
                    //如果栈中有操作符优先级更高，先出栈需要的操作数计算出结果，将结果重新入栈。
                    if(optMap.get(c)<=optMap.get(opts.peek())) {
                        cal();
                    }else {
                        break;
                    }
                }
                opts.push(c);
            }
        }
        //按顺序计算剩余元素
        while(!opts.isEmpty()){
            cal();
        }
        return nums.pop();
    }

    public void cal(){
        Integer b=nums.pop();
        Integer a=nums.pop();
        Integer ans = 0;
        switch (opts.pop()){
            case '+':
                ans=a+b;
                break;
            case '-':
                ans=a-b;
                break;
            case '*':
                ans=a*b;
                break;
            case '/':
                ans=a/b;
                break;
            default:
                break;
        }
        nums.push(ans);
    }
}
