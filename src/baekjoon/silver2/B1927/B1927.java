package baekjoon.silver2.B1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinHeap heap = new MinHeap();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(br.readLine());

            if (X == 0) {
                System.out.println(heap.remove());;
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
            heapifyUp(heap.size() - 1);
        }

        private void heapifyUp(int index) {
            while (index > 0) {
                int parentIndex = (index - 1) / 2;
                if (heap.get(parentIndex) <= heap.get(index)) {
                    break;
                }
                swap(parentIndex, index);
                index = parentIndex;
            }
        }

        public int remove() {
            if (heap.isEmpty()) {
                return 0;
            }
            int min = heap.get(0);
            int end = heap.remove(heap.size() - 1);
            if (!heap.isEmpty()) {
                heap.set(0, end);
                heapifyDown(0);
            }
            return min;
        }

        private void heapifyDown(int index) {
            while (index < heap.size()) {
                int left = 2 * index + 1;
                int right = 2 * index + 2;
                int smallest = index;

                if ( left < heap.size() && heap.get(left) < heap.get(smallest) ) {
                    smallest = left;
                }

                if ( right < heap.size() && heap.get(right) < heap.get(smallest) ) {
                    smallest = right;
                }

                if (smallest == index) {
                    break;
                }

                swap(index, smallest);
            }
        }

        public void swap(int i, int j) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }
}
