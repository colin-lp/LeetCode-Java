class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        boolean result=s.judgeCircle("UD");
        System.out.println(result);
    }
    public boolean judgeCircle(String moves) {
        int x=0;
        int y=0;
        for(int i=0;i<moves.length();i++){
            switch (moves.charAt(i)){
                case 'R':
                    x=x+1;
                    break;
                case 'L':
                    x=x-1;
                    break;
                case 'U':
                    y=y+1;
                    break;
                case 'D':
                    y=y-1;
                    break;
            }
        }
        return x==0 && y==0;
    }
}