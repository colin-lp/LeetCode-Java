class Solution {
    int[] arr;

    public static void main(String[] args) {
        String[] s=new String[]{"tars","rats","arts","star"};
        Solution sol=new Solution();
        System.out.println(sol.numSimilarGroups(s));
    }

    public int numSimilarGroups(String[] strs) {
        arr=new int[strs.length];
        for(int i=0;i<arr.length;i++){
            arr[i]=i;
        }
        for(int i=0;i<strs.length;i++){
            for(int j=i+1;j<strs.length;j++){
                int ii=find(arr[i]);
                int ij=find(arr[j]);
                if(ii==ij){
                    continue;
                }
                if(check(strs[i],strs[j])){
                    arr[ii]=ij;
                }
            }
        }
        int result=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==i){
                result++;
            }
        }
        return result;
    }

    private int find(int n){
        return arr[n]==n?n:find(arr[n]);
    }

    private boolean check(String a,String b){
        int count=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                count++;
                if(count>2){
                    return false;
                }
            }
        }
        return true;
    }
}