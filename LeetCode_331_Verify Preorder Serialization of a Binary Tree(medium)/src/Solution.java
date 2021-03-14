import java.util.LinkedList;

public class Solution {
    public boolean isValidSerialization(String preorder) {
        int i=0,len=preorder.length();
        LinkedList<Integer> list=new LinkedList<>();
        list.push(1);
        while(i<len){
            if(list.isEmpty()){
                return false;
            }
            if(preorder.charAt(i)==','){
                i++;
            }else if(preorder.charAt(i)=='#'){
                int pop=list.pop()-1;
                if(pop>0){
                    list.push(pop);
                }
                i++;
            }else {
                while(i<len && Character.isDigit(preorder.charAt(i))){
                    i++;
                }
                int pop=list.pop()-1;
                if(pop>0){
                    list.push(pop);
                }
                list.push(2);
            }
        }
        return list.isEmpty();
    }
}
