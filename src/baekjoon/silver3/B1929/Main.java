package baekjoon.silver3.B1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> getPrimeNumbers(int n, int m) {
        boolean[] prime = new boolean[m + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i * i <= m; i++) {
            for (int j = i * 2; j <= m; j+=i) {
                if (prime[j]) {
                    prime[j] = false;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = n; i <= m; i++) {
            if (prime[i]) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> result = getPrimeNumbers(N, M);

        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}
