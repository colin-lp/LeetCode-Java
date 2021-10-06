import java.util.Arrays;

public class Solution {
    public int findMinMoves(int[] machines) {
        int sum = Arrays.stream(machines).sum();
        if (sum % machines.length != 0) {
            return -1;
        }
        int avg = sum / machines.length;
        int rst = 0;
        sum = 0;
        for (int machine : machines) {
            /*
            需要这些变量的比较来找到正确答案。
            第一个max是要在 -1 +1 0（在avg和machine相等时machine将会为被赋为0，sum也将会为0）
            第二个max 1 -2 1（是要排除machine为负数的答案，正数才会是洗衣机最多的移动次数，如果是负数则可能有多个洗衣机移动给你，这样就在一次操作步数中获得了多件衣服）
            abs是在-2 -2 2 2（洗衣机能被分为 A -> B两组：A组成员不会给组内其他成员传递，而会一直给B组传递，这样只能一件一件操作，使用abs(sum)来记录这种情况下的最大值不丢失）
             */

            machine = machine - avg;
            sum += machine;
            rst = Math.max(rst, Math.max(Math.abs(sum), machine));
        }
        return rst;
    }
}
