package programmers.level2.P42626;

import java.util.PriorityQueue;

public class P42626 {
    static public int solution(int[] scoville, int K) {

        int answer = 0;

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pQ.add(scoville[i]);
        }

        while (pQ.peek() < K) {
            if (pQ.size() == 1) {
                answer = -1;
                return answer;
            }
            int min = pQ.poll();
            int minNext = pQ.poll();

            int newFood = min + (minNext * 2);

            pQ.add(newFood);

            answer++;
        }

        System.out.println(pQ);
        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = { 1, 2, 3, 9, 10, 12 };
        solution(scoville, 7);
    }
}
