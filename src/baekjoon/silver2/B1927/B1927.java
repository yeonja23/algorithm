package baekjoon.silver2.B1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        MinHeap heap = new MinHeap();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(br.readLine());

            if (X == 0) {
                System.out.println(heap.deleteMin());;
            } else {
                heap.insert(X);
            }

        }
    }

    static class MinHeap {
        private List<Integer> heap;
        StringBuilder sb = new StringBuilder();

        public MinHeap() {
            this.heap = new ArrayList<>();
        }

        public void insert(int value) {
            heap.add(value);
            if (heap.size() == 1) {
                return;
            }

            int index = heap.size() - 1;
            while (index > 0) {
                int parent = (index - 1) / 2;
                if (heap.get(parent) > heap.get(index)) {
                    swap(parent, index);
                }
                index = parent;
            }
        }

        public int deleteMin() {
            int index = 0;
            if (heap.isEmpty()) {
                return 0;
            }
            int result = heap.get(index);
            int temp = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            if (heap.isEmpty()) {
                return result;
            }
            heap.set(index, temp);

            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            while (index < heap.size() - 1) {
                if (
                        left < heap.size() &&
                        right < heap.size() &&
                        heap.get(left) > heap.get(right)
                ) {
                    smallest = right;
                } else if (
                        left < heap.size() &&
                        right < heap.size() &&
                        heap.get(left) < heap.get(right)
                ) {
                    smallest = left;
                } else if (left < heap.size()) {
                    smallest = left;
                } else {
                    return result;
                }

                if (heap.get(index) > heap.get(smallest)) {
                    swap(index, smallest);
                }

                index = smallest;
                left = 2 * index + 1;
                right = 2 * index + 2;
            }

            return result;
        }

        public void swap(int i, int j) {
            int temp = this.heap.get(i);
            this.heap.set(i, this.heap.get(j));
            this.heap.set(j, temp);
        }
    }
}
