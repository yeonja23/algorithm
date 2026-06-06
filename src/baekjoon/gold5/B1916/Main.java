package baekjoon.gold5.B1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int city;
    static int bus;
    static ArrayList<int[]>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        city = Integer.parseInt(br.readLine());
        bus = Integer.parseInt(br.readLine());

        edges = new ArrayList[city + 1];
        for (int i = 1; i <= city; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i <= bus; i++) {
            st = new StringTokenizer(br.readLine());
            int bStart = Integer.parseInt(st.nextToken());
            int bGoal = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            edges[bStart].add(new int[] { bGoal, price });
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, goal));
    }

    static int dijkstra(int start, int goal) {
        boolean[] visited = new boolean[city + 1];
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        queue.add(new int[] { start, 0});

        while (!queue.isEmpty()) {
            int[] u = queue.remove();
            int node = u[0], distance = u[1];

            if (visited[node]) continue;
            visited[node] = true;

            if (node == goal) return distance;

            for (int[] edge : edges[node]) {
                queue.add(new int[]{ edge[0], distance+edge[1] });
            }
        }

        return -1;
    }
}
