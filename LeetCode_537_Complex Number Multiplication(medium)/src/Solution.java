public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.complexNumberMultiply("1+-1i", "1+-1i"));
    }

    public String complexNumberMultiply(String num1, String num2) {
        String[] s1 = num1.split("\\+|i");
        String[] s2 = num2.split("\\+|i");
        return String.format("%d+%di",
                (Integer.valueOf(s1[0]) * Integer.valueOf(s2[0]) - Integer.valueOf(s1[1]) * Integer.valueOf(s2[1])),
                (Integer.valueOf(s1[1]) * Integer.valueOf(s2[0]) + Integer.valueOf(s1[0]) * Integer.valueOf(s2[1])));
    }
}
