package programmers.level3.P43163;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    static int N;
    static ArrayList<Integer>[] neighbors;
    static String[] allWords;

    static int BFS(String target) {
        int[] distances = new int[N+1];
        Arrays.fill(distances, -1);
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { 0, 0 });

        while (queue.size() > 0) {
            int[] u = queue.remove();
            int node = u[0], distance = u[1];
            if (distances[node] >= 0) continue;
            distances[node] = distance;
            if (allWords[node].equals(target)) return distance;
            for (int neighbor : neighbors[node]) {
                queue.add(new int[] { neighbor, distance+1 });
            }
        }

        return 0;
    }

    public int solution(String begin, String target, String[] words) {
        N = words.length;
        neighbors = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            neighbors[i] = new ArrayList<>();
        }

        allWords = new String[N + 1];
        allWords[0] = begin;
        for (int i = 0; i < N; i++) {
            allWords[i + 1] = words[i];
        }

        for (int i = 0; i < neighbors.length; i++) {
            for (int j = i + 1; j < neighbors.length; j++) {
                if (isAdjacent(allWords[i], allWords[j])) {
                    neighbors[i].add(j);
                    neighbors[j].add(i);
                }
            }
        }

        int answer = BFS(target);
        return answer;
    }

    public boolean isAdjacent(String a, String b) {
        int diffCount = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffCount++;
                if (diffCount > 1) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        Solution sol = new Solution();
        System.out.println(sol.solution(begin, target, words));
    }
}
