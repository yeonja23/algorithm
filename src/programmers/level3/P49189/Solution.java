package programmers.level3.P49189;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    static int N;
    static ArrayList<Integer>[] neighbors;
    static int[] distances;

    static int[] BFS() {
        distances = new int[N + 1];
        Arrays.fill(distances, -1);

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { 1, 0 });

        while (queue.size() > 0) {
            int[] u = queue.remove();
            int node = u[0];
            int distance = u[1];

            if (distances[node] >= 0) continue;
            distances[node] = distance;

            for (int neighbor : neighbors[node]) {
                queue.add(new int[] { neighbor, distance+1 });
            }
        }

        return distances;
    }

    public int solution(int n, int[][] edge) {
        N = n;

        neighbors = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            neighbors[i] = new ArrayList<>();
        }

        for (int[] e : edge) {
            int a = e[0], b = e[1];
            neighbors[a].add(b);
            neighbors[b].add(a);
        }

        int[] distances = BFS();

        int max = 0;
        for (int i = 1; i < distances.length; i++) {
            if (distances[i] > max) max = distances[i];
        }

        int answer = 0;
        for (int i = 1; i < distances.length; i++) {
            if (max == distances[i]) answer++;
        }

        return answer;
    }
}