package programmers.level1.P389478;

class Solution {
    public static void main(String[] args) {
        solution(22, 6, 8);
    }

    static public int solution(int n, int w, int num) {
        int answer = 0;
        int [][] box = new int[n / w + 1][w];

        int numRow = 0;
        int numColumn = 0;
        for (int i = 0; i < n; i++) {
            int row = i / w;
            if (row % 2 == 0) {
                box[row][i % w] = i;
                if (i + 1 == num) {
                    numRow = row;
                    numColumn = i % w;
                }
            } else {
                box[row][w - (i - (row * w)) - 1] = i;
                if (i + 1 == num) {
                    numRow = row;
                    numColumn = w - (i - (row * w)) - 1;
                }
            }
        }

        if (box[box.length - 1][numColumn] == 0) {
            answer = box.length - numRow - 1;
        } else {
            answer = box.length - numRow;
        }

        return answer;
    }
}
