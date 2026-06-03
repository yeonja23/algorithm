package programmers.level1.P68644;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    int r = 2;
    List<Integer> result = new ArrayList<>();
    List<Integer> selected = new ArrayList<>();

    public int[] solution(int[] numbers) {
        DFS(numbers, 0, numbers.length - r);
        Collections.sort(result);
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    void DFS(int[] numbers, int from, int to) {
        if (selected.size() == r) {
            int sum = 0;
            for (int i = 0; i < r; i++) {
                sum += selected.get(i);
            }
            if (!result.contains(sum)) result.add(sum);
            return;
        }

        for (int i = from; i <= to; ++i) {
            selected.add(numbers[i]);
            DFS(numbers, i + 1, to + 1);
            selected.remove(selected.size() - 1);
        }
    }
}
