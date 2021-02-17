public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r*c!=nums.length*nums[0].length) return nums;
        int[][] rst=new int[r][c];
        for(int j=0;j<r*c;j++){
            rst[j/c][j%c]=nums[j/nums[0].length][j%nums[0].length];
        }
        return rst;
    }
}
