package baekjoon.gold3.B2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int maxMagic = 1;

    static int BFS() {
        boolean[][][] visited = new boolean[N][M][maxMagic + 1];
        Deque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[] { 0, 0, 0, 0 });

        while (!queue.isEmpty()) {
            int[] u = queue.remove();
            int r = u[0], c = u[1], magic = u[2], distance = u[3];

            if (map[r][c] == 1) {
                if (magic == maxMagic) continue;
                ++magic;
            }

            if (visited[r][c][magic]) continue;
            visited[r][c][magic] = true;

            if (r + 1 == N && c + 1 == M) return distance + 1;

            if (r > 0) queue.add(new int[] { r-1, c, magic, distance+1 });
            if (r < N-1) queue.add(new int[] { r+1, c, magic, distance+1 });
            if (c > 0) queue.add(new int[] { r, c-1, magic, distance+1 });
            if (c < M-1) queue.add(new int[] { r, c+1, magic, distance+1 });
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        System.out.println(BFS());
    }
}
