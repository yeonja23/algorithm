package baekjoon.gold5.B7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static final int RIPE = 1;
    private static final int UNRIPE = 0;

    private static final int[] ROW_DIR = {1, -1, 0, 0};
    private static final int[] COL_DIR = {0, 0, 1, -1};

    private static int rows;
    private static int cols;
    private static int[][] box;

    static class Position {
        final int row;
        final int col;
        final int day;

        Position(int row, int col, int day) {
            this.row = row;
            this.col = col;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        cols = Integer.parseInt(st.nextToken());
        rows = Integer.parseInt(st.nextToken());
        box = new int[rows][cols];

        Deque<Position> queue = new ArrayDeque<>();

        for (int r = 0; r < rows; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < cols; c++) {
                box[r][c] = Integer.parseInt(st.nextToken());
                if (box[r][c] == RIPE) {
                    queue.add(new Position(r, c, 0));
                }
            }
        }

        int result = bfs(queue);
        System.out.println(result);
    }

    private static int bfs(Deque<Position> queue) {
        int lastDay = 0;

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            lastDay = current.day;

            for (int i = 0; i < 4; i++) {
                int nextRow = current.row + ROW_DIR[i];
                int nextCol = current.col + COL_DIR[i];

                if (isInBounds(nextRow, nextCol) && box[nextRow][nextCol] == UNRIPE) {
                    box[nextRow][nextCol] = RIPE;
                    queue.add(new Position(nextRow, nextCol, lastDay + 1));
                }
            }
        }

        return hasUnripeTomato() ? -1 : lastDay;
    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private static boolean hasUnripeTomato() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (box[r][c] == UNRIPE) return true;
            }
        }
        return false;
    }
}