package baekjoon.silver2.B1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] minusParts = str.split("-");
        int[] plusParts = new int[minusParts.length];

        for (int i = 0; i < minusParts.length; i++) {
            String[] plus = minusParts[i].split("\\+");
            for (int j = 0; j < plus.length; j++) {
                plusParts[i] += Integer.parseInt(plus[j]);
            }
        }

        int result = plusParts[0];
        for (int i = 1; i < plusParts.length; i++) {
            result -= plusParts[i];
        }
        System.out.println(result);
    }
}
