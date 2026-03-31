package programmers.level1.P12940;

public class P12940 {
    public int[] solution(int n, int m) {
        int a = n;
        int b = m;

        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        int gcd = a;

        int lcm = n * m / gcd;

        int[] answer = { gcd, lcm };

        return answer;
    }
}
