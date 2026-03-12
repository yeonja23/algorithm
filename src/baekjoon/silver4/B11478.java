package baekjoon.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] targets = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = false;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (numbers[j] == targets[i]) {
                    flag = true;
                }
            }

            if (flag) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }

            flag = false;
        }

        System.out.printf(sb.toString());
    }
}
