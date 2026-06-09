package baekjoon.silver3.B15655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static ArrayList<Integer> selected;
    static ArrayList<ArrayList<Integer>> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        selected = new ArrayList<>();
        result = new ArrayList<>();

        DFS(0, N-M);

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                int tmp = result.get(i).get(j);
                System.out.print(arr[tmp] + " ");
            }
            System.out.println();
        }

    }

    static void DFS(int from, int to) {
        if (selected.size() == M) {
            result.add(new ArrayList<>(selected));
            return;
        }

        for (int i = from; i <= to; i++) {
            selected.add(i);
            DFS(i+1, to+1);
            selected.removeLast();
        }
    }
}
