class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        int i = s.trap(new int[]{4,2,3});
        System.out.println(i);
    }

    public int trap(int[] height) {
        if(height.length==0) return 0;
        int[] lMax=new int[height.length];
        int[] rMax=new int[height.length];
        lMax[0]=height[0];
        rMax[height.length-1]=height[height.length-1];
        int result=0;
        for(int i=1;i<height.length;i++){
            lMax[i]=Math.max(height[i],lMax[i-1]);
        }
        for(int i=height.length-2;i>=0;i--){
            rMax[i]=Math.max(height[i],rMax[i+1]);
        }
        for(int i=0;i<height.length;i++){
            result+=Math.min(lMax[i],rMax[i])-height[i];
        }
        return result;
    }
}