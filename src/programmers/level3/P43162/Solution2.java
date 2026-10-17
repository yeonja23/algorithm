package programmers.level3.P43162;

class Solution2 {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ++answer;
                dfs(i, computers);
            }
        }

        return answer;
    }

    void dfs(int v, int[][] computers) {
        if (visited[v]) return;

        visited[v] = true;

        for (int i = 0; i < computers[0].length; i++) {
            if (v == i) continue;
            if (computers[v][i] == 1) {
                dfs(i, computers);
            }
        }
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int n = sol.solution(
                3,
                new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}
        );

        System.out.println(n);
    }
}
