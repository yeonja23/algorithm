package baekjoon.gold5.B1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] arr;
    static int vowels, consonants;
    static ArrayList<Integer> selected;
    static ArrayList<ArrayList<Integer>> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        String string = br.readLine().replace(" ", "");
        arr = string.toCharArray();

        Arrays.sort(arr);

        selected = new ArrayList<>();
        result = new ArrayList<>();

        DFS(0, C - L);

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                int tmp = result.get(i).get(j);
                System.out.print(arr[tmp] + "");
            }
            System.out.println();
        }
    }

    static void DFS(int from, int to) {
        if (selected.size() == L) {
            count();
            if (vowels >= 1 && consonants >= 2) {
                result.add(new ArrayList<>(selected));
                return;
            }
            return;
        }

        for (int i = from; i <= to ; i++) {
            selected.add(i);
            DFS(i+1, to+1);
            selected.remove(selected.size() - 1);
        }
    }

    static void count() {
        vowels = 0;
        consonants = 0;
        for (int i = 0; i < L; i++) {
            int tmp = selected.get(i);

            switch (arr[tmp]) {
                case 'a':
                    vowels++;
                    break;
                case 'e':
                    vowels++;
                    break;
                case 'i':
                    vowels++;
                    break;
                case 'o':
                    vowels++;
                    break;
                case 'u':
                    vowels++;
                    break;
                default:
                    consonants++;
            }
        }
    }
}
