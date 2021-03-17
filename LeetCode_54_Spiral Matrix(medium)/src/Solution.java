import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rst = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0, col = 0, nextRow, nextCol;
        int directionIndex = 0;
        int total = matrix.length * matrix[0].length;
        for (int i = 0; i < total; i++) {
            visited[row][col] = true;
            rst.add(matrix[row][col]);
            nextRow = row + direction[directionIndex][0];
            nextCol = col + direction[directionIndex][1];
            if (nextRow >= matrix.length || nextRow < 0 || nextCol >= matrix[0].length || nextCol < 0 || visited[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += direction[directionIndex][0];
            col += direction[directionIndex][1];
        }
        return rst;
    }
}
