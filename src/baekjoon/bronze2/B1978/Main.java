package baekjoon.bronze2.B1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean getPrimeNumbersCount(int n) {
        if (n == 0 || n == 1) return false;
        double limit = Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0) return false; // 나누어 떨어지면 소수가 아니다
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (getPrimeNumbersCount(num)) count++;
        }
        System.out.println(count);
    }
}
