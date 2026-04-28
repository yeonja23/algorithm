package baekjoon.silver2.B15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        dfs(new ArrayList<Integer>());
    }

    public static void dfs(ArrayList<Integer> selected) {
        if (selected.size() == M) {
            for (int i = 0; i < selected.size(); i++) {
                System.out.print(selected.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!selected.contains(arr[i])) {
                selected.add(arr[i]);
                dfs(selected);
                selected.removeLast();
            }
        }
    }
}