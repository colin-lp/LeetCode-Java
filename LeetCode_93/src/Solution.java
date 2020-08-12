import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s= new Solution();
        List<String> result=s.restoreIpAddresses("255255255255");
        System.out.println(result.get(0));
    }
    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb=new StringBuilder();
        List<String> result=new ArrayList<>();
        for(int l1=3;l1<4;l1++){
            for(int l2=3;l2<4;l2++){
                for(int l3=3;l3<4;l3++){
//                     for(int l4=1;l4<4;l4++){
                    int l4=s.length()-l1-l2-l3;
                    if(l4<=0 || l4>5) continue;
                    if(l1+l2+l3+l4==s.length()){
                        int n1=Integer.parseInt(s.substring(0,l1));
                        int n2=Integer.parseInt(s.substring(l1,l1+l2));
                        int n3=Integer.parseInt(s.substring(l1+l2,l1+l2+l3));
                        int n4=Integer.parseInt(s.substring(l1+l2+l3));
                        if(n1<=255 && n2<=255 && n3 <=255 && n4<=255){
                            sb.append(n1).append(".").append(n2).append(".").append(n3).append(".").append(n4);
                            if(l1+l2+l3+l4+3==sb.length()) result.add(sb.toString());
                            sb.delete(0,sb.length());
                        }
                    }
//                     }
                }
            }
        }
        return result;
    }
}