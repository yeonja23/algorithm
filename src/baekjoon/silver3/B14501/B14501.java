package baekjoon.silver3.B14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N];
        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        TreeSet<Integer> set = getIntegers();
        int sum = 0;
        int temp;

        for (int i = 0; i < N; i++) { // N: 7
            int days = T[i]; // days: 3
            temp = N - i - 1; // temp: 6
            sum += P[i]; // sum: 10
            while (temp > 0) { // 1
                sum += P[i + days]; // sum: 20
                temp = N - days; // 4
                days = P[i + days]; // 여기서 막힘,, for문으로
            }
            set.add(sum);
            sum = 0;
        }

        sb.append(set.last());
        System.out.println(sb);
    }

    private static TreeSet<Integer> getIntegers() {
        TreeSet<Integer> set = new TreeSet<>();
        return set;
    }
}
