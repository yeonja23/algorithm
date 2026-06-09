package baekjoon.silver1.B2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int size;
    static char[][] A;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new char[N][N];
        for (int r = 0; r < N; r++) {
            String line = br.readLine();
            A[r] = line.toCharArray();
        }

        visited = new boolean[N][N];

        List<Integer> sizes = count();
        Collections.sort(sizes);
        System.out.println(sizes.size());
        for (int size : sizes) {
            System.out.println(size);
        }
    }

    static ArrayList<Integer> count() {
        ArrayList<Integer> sizes = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (A[r][c] == '1' && !visited[r][c]) {
                    size = 0;
                    DFS(r, c);
                    sizes.add(size);
                }
            }
        }
        return sizes;
    }

    static void DFS(int r, int c) {
        if (A[r][c] == '0' || visited[r][c]) return;
        visited[r][c] = true;
        ++size;

        if (r > 0) DFS(r-1, c);
        if (r < N-1) DFS(r+1, c);
        if (c > 0) DFS(r, c-1);
        if (c < N-1) DFS(r, c+1);
    }
}
