package programmers.level2.P1844;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    static int BFS(int ROW, int COL, int[][] maps) {
        boolean[][] visited = new boolean[ROW][COL];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0, 0, 1});

        while (queue.size() > 0) {
            int[] u = queue.remove();
            int r = u[0], c = u[1], distance = u[2];

            if (maps[r][c] == 0) continue;

            if (visited[r][c]) continue;

            visited[r][c] = true;

            if (r == ROW - 1 && c == COL - 1) return distance;

            if (r > 0) queue.add(new int[] {r - 1, c, distance + 1}); // 위로 이동
            if (c > 0) queue.add(new int[] {r, c - 1, distance + 1});   // 왼쪽으로 이동
            if (r < ROW - 1) queue.add(new int[] {r + 1, c, distance + 1}); // 아래로 이동
            if (c < COL - 1) queue.add(new int[] {r, c + 1, distance + 1}); // 오른쪽으로 이동
        }

        return -1;
    }

    public int solution(int[][] maps) {
        int ROW = maps.length;
        int COL = maps[0].length;
        int answer = Solution.BFS(ROW, COL, maps);
        return answer;
    }
}
