package baekjoon.silver2.B4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int getPrimeNumbersCount(int n, int m) {
        boolean[] prime = new boolean[m + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i * i <= m; i++) {
            if (prime[i]) {
                for (int j = i * 2; j <= m; j += i) {
                    prime[j] = false;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = n + 1; i <= m; i++) {
            if (prime[i]) result.add(i);
        }
        return result.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) break;
            sb.append(getPrimeNumbersCount(num, 2 * num)).append("\n");

        }

        System.out.print(sb);
    }
}
