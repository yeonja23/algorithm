package baekjoon.silver4.B10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
           list.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int count = 0;

        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < N; j++) {
               if (n == list.get(j)) {
                    count++;
               }
            }
            sb.append(count + " ");
            count = 0;
        }

        System.out.println(sb);
    }
}
