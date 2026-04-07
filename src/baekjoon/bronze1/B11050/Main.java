package baekjoon.bronze1.B11050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int nCr(int N, int n, int r) {
        int[][] C = new int[N + 1][N + 1];

        for (int i = 0; i < N + 1; i++) {
            C[i][i] = C[i][0] = 1;
        }

        for (int i = 2; i < N + 1; i++) {
            for (int j = 1; j < i; j++) {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }

        return C[n][r];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(nCr(10, N, K));
    }
}
