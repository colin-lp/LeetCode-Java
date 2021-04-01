import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.clumsy(4));
    }

    //stack 9ms
    private int stack(int N){
        LinkedList<Integer> list=new LinkedList<>();
        int opt=0;
        list.push(N);
        N--;
        while(N>0){
            opt%=4;
            if(opt==0){
                list.push(list.pop()*N);
            }else if(opt==1){
                list.push(list.pop()/N);
            }else if(opt==2){
                list.push(N);
            }else {
                list.push(-N);
            }
            N--;
            opt++;
        }
        int rst=0;
        while(!list.isEmpty()){
            rst+=list.pop();
        }
        return rst;
    }

    //math 2ms
    private int clumsy(int N) {
        return calc(0, N, 0);
    }

    private int calc(int opt, int cur, int rst) {
        while (cur > 0) {
            opt %= 4;
            switch (opt) {
                case 0:
                    if (cur >= 3) {
                        int a = cur;
                        int b = --cur;
                        int c = --cur;
                        rst += a * b / c;
                        opt = 1;
                    } else if (cur == 2) {
                        int a = cur;
                        int b = --cur;
                        rst += a * b;
                        return rst;
                    } else if (cur == 1) {
                        rst *= cur;
                        return rst;
                    }
                    break;
                case 1:
                    break;
                case 2:
                    rst += cur;
                    break;
                case 3:
                    if (cur >= 3) {
                        int a = cur;
                        int b = --cur;
                        int c = --cur;
                        rst -= a * b / c;
                        opt = 1;
                    } else if (cur == 2) {
                        int a = cur;
                        int b = --cur;
                        rst -= a * b;
                        return rst;
                    } else if (cur == 1) {
                        rst -= cur;
                        return rst;
                    }
                    break;
                default:
                    break;
            }
            cur--;
            opt++;
        }
        return rst;
    }
}
