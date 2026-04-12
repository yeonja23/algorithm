package baekjoon.bronze2.B2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main2 {
    static TreeSet<Integer> set = new TreeSet<>();

    public static void DFS(int max, int[] ar, int index, List<Integer> selected) {
        if (selected.size() > 3) return;

        if (index >= ar.length) {
            if (!(selected.size() == 3)) {
                return;
            }

            int sum = selected.get(0) + selected.get(1) + selected.get(2);
            if (sum > max) return;
            set.add(sum);
            return;
        }

        selected.add(ar[index]);
        DFS(max, ar, index + 1, selected);
        selected.remove(selected.size() - 1);
        DFS(max, ar, index + 1, selected);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        DFS(max, list, 0, new ArrayList<>());

        System.out.println(set.last());
    }
}
