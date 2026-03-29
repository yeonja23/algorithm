package programmers.level2.P12909;

import java.util.ArrayDeque;
import java.util.Deque;

public class P12909 {
    static boolean solution(String s) {
        boolean answer = true;

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "(()(";
        System.out.println(solution(s));
    }
}
