package baekjoon.silver1.B11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) != Math.abs(b)) return Math.abs(a) - Math.abs(b);
            return a - b;
        });
        int x;
        for (int i = 0; i < N; i++) {
            x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pQ.isEmpty()) {
                    sb.append(0 + "\n");
                    continue;
                }
                sb.append(pQ.poll() + "\n");
            } else {
                pQ.add(x);
            }
        }

        System.out.println(sb);
    }
}
