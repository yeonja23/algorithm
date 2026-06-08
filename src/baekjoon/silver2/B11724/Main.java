package baekjoon.silver2.B11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int count;
    static ArrayList<Integer>[] neighbors;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        neighbors = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            neighbors[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            neighbors[u].add(v);
            neighbors[v].add(u);
        }

        visited = new boolean[N + 1];

        graphCount();
        System.out.println(count);
    }

    static void graphCount() {
        for (int node = 1; node <= N; node++) {
            if (!visited[node]) {
                ++count;
                DFS(node);
            }
        }
    }

    static void DFS(int node) {
        if (visited[node]) return;
        visited[node] = true;
        for (int neighbor : neighbors[node]) {
            DFS(neighbor);
        }
    }
}
