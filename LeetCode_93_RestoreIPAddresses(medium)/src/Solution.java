import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> result = new ArrayList<>();
    private String str;

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> result = s.restoreIpAddresses2("255255255255");
        System.out.println(result.get(0));
    }

    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        for (int l1 = 3; l1 < 4; l1++) {
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
                            if (l1 + l2 + l3 + l4 + 3 == sb.length()) result.add(sb.toString());
                            sb.delete(0, sb.length());
                        }
                    }
//                     }
                }
            }
        }
        return result;
    }


    public List<String> restoreIpAddresses2(String s) {
        str = s;
        dfs(0, 0, new String[4]);
        return result;
    }

    public void dfs(int index, int start, String[] nums) {
        if (start >= str.length() || index >= 4) return;
        if (start == str.length() - 1 && index < 3) return;
        if (index == 3) {
            String s = str.substring(start);
            int num = Integer.parseInt(s);
            if (num <= 255 && num >= 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[0]).append(".")
                        .append(nums[1]).append(".")
                        .append(nums[2]).append(".")
                        .append(s);
                result.add(sb.toString());
            }
            return;
        }
        for (int i = 1; i < 4; i++) {
            String subStr = str.substring(start, start + i);
            int j = Integer.parseInt(subStr);
            if (j <= 255 && j >= 0) {
                nums[index] = subStr;
                dfs(index + 1, start + i, nums);
                nums[index] = "";
            }
        }
    }
}