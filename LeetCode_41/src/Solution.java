public class Solution {
    int firstMissingPositive(int a[], int len)
    {
        int i,temp;
        i = 0;
        while(i<len)
        {
            if (a[i] < 0 || a[i] > len || a[a[i] - 1] == a[i])
            {
                i++;
            }
            else
            {
                temp = a[a[i] - 1];
                a[a[i] - 1] = a[i];
                a[i] = temp;
                i++;
            }
        }
        for (i = 0; i < len; i++)
        {
            if (a[i] != i + 1)
                return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        int i=s.firstMissingPositive(new int[]{-5,-4,-3,-7,-6},5);
        System.out.println(i);
    }
}


