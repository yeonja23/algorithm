package programmers.level3.P43162;

import java.util.ArrayList;

class Solution {
    static ArrayList<Integer>[] neighbors;
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        neighbors = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            neighbors[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1) {
                    neighbors[i].add(j);
                    neighbors[j].add(i);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                ++answer;
                dfs(i);
            }
        }

        return answer;
    }

    public void dfs(int v) {
        if (visited[v]) return;

        visited[v] = true;

        for (int n : neighbors[v]) {
            if (!visited[n]) {
                dfs(n);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = sol.solution(
                3,
                new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}
                );

        System.out.println(n);
    }
}
