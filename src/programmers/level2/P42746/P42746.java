package programmers.level2.P42746;

import java.util.ArrayList;
import java.util.Collections;

public class P42746 {
    public String P42746(int[] numbers) {
        String answer = "";
        int size = numbers.length;

        ArrayList<String> str = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            str.add(numbers[i] + "");
        }

        Collections.sort(str, (a, b) -> (b + a).compareTo(a + b));

        for (String ans : str) {
            answer += ans;
        }

        if (answer.equals("0".repeat(size))) {
            answer = "0";
        }

        return answer;
    }
}
