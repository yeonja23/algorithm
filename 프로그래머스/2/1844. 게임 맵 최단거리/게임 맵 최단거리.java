import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    static boolean[][] visited;

    public static int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];

        return BFS(maps, 0, 0);
    }

    public static int BFS(int[][] maps, int startRow, int startCol) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { startRow, startCol, 1 });
        while (!queue.isEmpty()) {
            int[] tmp = queue.remove();

            int row = tmp[0];
            int col = tmp[1];
            int distance = tmp[2];

            if (visited[row][col]) {
                continue;
            }
            visited[row][col] = true;
            if (row == maps.length - 1 && col == maps[0].length - 1) return distance;

            if (col + 1 < maps[0].length && maps[row][col + 1] != 0) { queue.add(new int[] { row, col + 1, distance + 1 }); }  // 동
            if (col - 1 >= 0 && maps[row][col - 1] != 0) { queue.add(new int[] { row, col - 1, distance + 1 }); }  // 서
            if (row + 1 < maps.length && maps[row + 1][col] != 0) { queue.add(new int[] { row + 1, col, distance + 1 }); }  // 남
            if (row - 1 >= 0 && maps[row - 1][col] != 0) { queue.add(new int[] { row - 1, col, distance + 1 }); }  // 북
        }

        return -1;
    }
}
