package programmers.level2.P1835;

import java.util.ArrayList;
import java.util.List;

// 중복X, 순서O - 순열
class Solution {
    String[] list;
    int r = 8;
    List<String> result, selected;
    int count = 0;
    int xIndex, yIndex;
    int distance;
    int distanceTmp;
    boolean flag = true;

    public void DFS(String[] data) {
        if (selected.size() == r) {
            for (int i = 0; i < data.length; i++) {
                xIndex = selected.indexOf(data[i].substring(0, 1));
                yIndex = selected.indexOf(data[i].substring(2, 3));
                distance = Math.abs(xIndex - yIndex) - 1;
                distanceTmp = Integer.parseInt(data[i].substring(4, 5));

                switch (data[i].substring(3, 4)) {
                    case "<":
                        if (!(distance < distanceTmp)) {
                            flag = false;
                        }
                        break;
                    case "=":
                        if (!(distance == distanceTmp)) {
                            flag = false;
                        }
                        break;
                    case ">":
                        if (!(distance > distanceTmp)) {
                            flag = false;
                        }
                        break;
                }
            }

            if (flag) {
                count++;
            }

            flag = true;

            return;
        }

        for (String tmp : list) {
            if (!selected.contains(tmp)) {
                selected.add(tmp);
                DFS(data);
                selected.remove(selected.size() - 1);
            }
        }
    }

    public int solution(int n, String[] data) {
        String[] list = { "A", "C", "F", "J", "M", "N", "R", "T" };
        this.list = list;
        this.result = new ArrayList<>();
        this.selected = new ArrayList<>();

        DFS(data);

        int answer = count;

        return answer;
    }
}
