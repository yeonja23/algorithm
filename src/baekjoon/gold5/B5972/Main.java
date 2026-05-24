package baekjoon.gold5.B5972;

import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static int[] d = new int[50001];
    public static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];

        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, dist));
            graph.get(b).add(new Node(a, dist));
        }

        dijkstra(1);

        System.out.println(d[N]);
    }

    public static void dijkstra(int start) {
        Arrays.fill(d, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node temp = pq.poll();
            int nodeB = temp.nodeB;
            int distance = temp.distance;

            if(d[nodeB] < distance) continue;
            for(int i=0;i<graph.get(nodeB).size();i++) {
                int cost = d[nodeB] + graph.get(nodeB).get(i).distance;
                if( cost < d[graph.get(nodeB).get(i).nodeB]) {
                    d[graph.get(nodeB).get(i).nodeB] = cost;
                    pq.offer(new Node( graph.get(nodeB).get(i).nodeB, cost));
                }
            }
        }
    }

}


class Node implements Comparable<Node>{
    int nodeB;
    int distance;
    public Node(int nodeB, int distance) {
        this.nodeB = nodeB;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node other) {
        if(this.distance > other.distance) {
            return 1;
        }else if(this.distance == other.distance) {
            return 0;
        }else {
            return -1;
        }
    }
}
