public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        s.addStrings("9","99");
        System.out.println(1);
    }

    public String addStrings(String num1, String num2) {
        int maxIndex=Math.max(num1.length(),num2.length());
        int num1l=num1.length();
        int num2l=num2.length();
        int carry=0;
        StringBuilder sb=new StringBuilder();
        for(int i=maxIndex-1;i>=0;i--){
            int n1=0,n2=0;
            if(num1l>0) n1=Integer.parseInt(String.valueOf(num1.charAt(num1l-1)));
            if(num2l>0) n2=Integer.parseInt(String.valueOf(num2.charAt(num2l-1)));
            sb.insert(0,String.valueOf((carry+n1+n2)%10));
            carry=(carry+n1+n2)/10;
        }
        if(carry!=0) sb.insert(0,String.valueOf(carry));
        return sb.toString();
    }
}
