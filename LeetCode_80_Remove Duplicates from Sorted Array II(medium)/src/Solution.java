public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.removeDuplicates(new int[]{1,1,1}));
    }

    //快慢指针
    public int removeDuplicatesOfficial(int[] nums){
        if(nums.length<=2) return nums.length;
        int slow=2,fast=2;
        while(fast<nums.length){
            if(nums[slow-2]!=nums[fast]){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    //两层循环
    public int removeDuplicates(int[] nums) {
        int index=1,rep=1,offset=0,absIndex=1;
        while(absIndex<nums.length){
            if(nums[index-1]==nums[index]){
                rep++;
                if(rep>2){
                    offset++;
                }
            }else if(nums[index-1]!=nums[index]){
                if(rep>2){
                    for(int i=index;i<nums.length;i++){
                        nums[i-offset]=nums[i];
                    }
                    index-=offset;
                    offset=0;
                }
                rep=1;
            }
            index++;
            absIndex++;
        }
        if(rep>2) index-=offset;
        return index;
    }
}
