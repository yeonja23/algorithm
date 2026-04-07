package baekjoon.silver5.B1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long nCr(int N, int n, int r) {
        long[][] C = new long[N + 1][N + 1];

        for (int i = 0; i < N + 1; i++) {
            C[i][i] = C[i][0] = 1;
        }

        for (int i = 2; i < N + 1; i++) {
            for (int j = 1; j < i; j++) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]);
            }
        }

        return C[n][r];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] n = new int[N];
        int[] m = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n[i] = Integer.parseInt(st.nextToken());
            m[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            System.out.println(nCr(30, m[i], n[i]));
        }
    }
}
