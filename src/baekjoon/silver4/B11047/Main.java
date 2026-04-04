package baekjoon.silver4.B11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int tmp;
        for (int i = N - 1; i >= 0; i--) {
            tmp = (K - (K % coin[i])) / coin[i];
            count += tmp;
            K -= coin[i] * tmp;
        }

        System.out.println(count);
    }
}
