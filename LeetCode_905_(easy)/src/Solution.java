import java.util.Arrays;

class Solution {
    public int[] sortArrayByParity(int[] A) {
        if (A.length == 0) return A;
        int a = 0;
        int b = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[b] % 2 == 0) {
                int t = A[b];
                for(int j=b;j>a;j--){
                    A[j]=A[j-1];
                }
                A[a] = t;
                a++;
                b++;
            } else {
                b++;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 7, 4, 9, 8, 5, 6};
        Solution s=new Solution();
        System.out.println(Arrays.toString(s.sortArrayByParity(arr)));
    }
}