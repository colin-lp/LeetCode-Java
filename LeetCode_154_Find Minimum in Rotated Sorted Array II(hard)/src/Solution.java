public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMin(new int[]{0, 0, 0, 2, 2}));
        System.out.println(s.findMinOfficial(new int[]{0, 0, 0, 2, 2}));
    }

    //官方
    public int findMinOfficial(int[] nums){
        int left = 0, right = nums.length - 1, middle;
        while(left<right){
            middle=(right-left)/2+left;
            if(nums[middle]>nums[right]){
                left=middle+1;
            }else if(nums[middle]<nums[right]){
                right=middle;
            }else{
                right--;
            }
        }
        return nums[left];
    }

    //直到两边不重复为止，才开始判断
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, middle;
        //使用标签或标识变量跳出多重循环
        //boolean flag=false;
        loop:
        while (left < right) {
            //flag=false;
            middle = (right - left) / 2 + left;
            while (left < right && nums[left] == nums[left + 1]) {
                left++;
                //flag=true;
                continue loop;
            }
            while (right > left && nums[right] == nums[right - 1]) {
                right--;
                //flag=true;
                continue loop;
            }
            //if(flag) continue;
            if (nums[middle] >= nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return nums[left];
    }
}