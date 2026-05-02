package programmers.level1.P131705;

import java.util.ArrayList;
import java.util.List;

// 중복 X, 순서 X - 조합
class Solution2 {
    int[] list;
    int r;
    int count;
    int sum;
    List<Integer> result, selected;

    public void DFS(int from, int to) {
        if (selected.size() == r) {
            for (int i = 0; i < r; i++) {
                sum += selected.get(i);
            }
            if (sum == 0) {
                count++;
            }
            sum = 0;
            return;
        }

        for (int i = from; i < to; i++) {
            selected.add(list[i]);
            DFS(i + 1, to);
            selected.removeLast();
        }
    }
    public int solution(int[] number) {
        this.list = number;
        this.r = 3;
        this.count = 0;
        this.sum = 0;
        this.result = new ArrayList<>();
        this.selected = new ArrayList<>();
        DFS(0, number.length);
        int answer = count;

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] list = { -1, 1, -1, 1 };
        System.out.println(sol.solution(list));
    }
}

