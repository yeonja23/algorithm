package baekjoon.gold5.B7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 익은 토마토가 start
public class Main {
    static int COL;
    static int ROW;
    static int[][] tomatoes;
    static int goalCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        COL = Integer.parseInt(st.nextToken());
        ROW = Integer.parseInt(st.nextToken());

        tomatoes = new int[ROW][COL];

        int node;
        for (int i = 0; i < ROW; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < COL; j++) {
                node = Integer.parseInt(st.nextToken());
                if (node == 0) {
                    ++goalCount;
                }
                tomatoes[i][j] = node;
            }
        }

        System.out.println(BFS());
    }

    static int BFS() {
        if (goalCount == 0) return 0;

        boolean[][] visited = new boolean[ROW][COL];
        Deque<int[]> queue = new ArrayDeque<>();
        int meet0 = 0;

        for (int r = 0; r <ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (tomatoes[r][c] == 1) queue.add(new int[] { r, c, 0 });
            }
        }

        while (!queue.isEmpty()) {
            int[] u = queue.remove();
            int r = u[0], c = u[1], distance = u[2];

            if (visited[r][c]) continue;
            visited[r][c] = true;

            if (tomatoes[r][c] == -1) continue;

            if (tomatoes[r][c] == 0) ++meet0;

            if (goalCount == meet0) return distance;

            if (r > 0) queue.add(new int[] { r-1, c, distance+1});
            if (r < ROW-1) queue.add(new int[] { r+1, c, distance+1});
            if (c > 0) queue.add(new int[] { r, c-1, distance+1});
            if (c < COL-1) queue.add(new int[] { r, c+1, distance+1});
        }

        return -1;
    }
}
