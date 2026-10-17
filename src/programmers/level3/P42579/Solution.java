package programmers.level3.P42579;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] result = solution(genres, plays);
        for (int v : result) {
            System.out.print(v + " ");
        }
    }

    static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreMap = new HashMap<>();   // 장르, 장르별 재생수 합산 값
        HashMap<Integer, String> songMap = new HashMap<>();     // 고유번호, 장르
        HashMap<Integer, Integer> songMap2 = new HashMap<>();   // 고유번호, 재생수
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            if (genreMap.containsKey(genres[i])) {
                genreMap.put(genres[i], genreMap.get(genres[i]) + plays[i]);
                songMap.put(i, genres[i]);
                songMap2.put(i, plays[i]);
                continue;
            }
            genreMap.put(genres[i], plays[i]);
            songMap.put(i, genres[i]);
            songMap2.put(i, plays[i]);
        }

        List<String> keyList1 = new ArrayList<>(genreMap.keySet());
        keyList1.sort((a, b) -> genreMap.get(b).compareTo(genreMap.get(a)));

        List<Integer> keyList2 = new ArrayList<>();     // 장르별 인기곡 임시용 키리스트
        for (String key : keyList1) {
            for(Map.Entry<Integer, String> entry : songMap.entrySet()){
                if (!(key.equals(entry.getValue()))) {
                    continue;
                }

                if (!(keyList2.isEmpty())) {
                    if (!(songMap.get(keyList2.getLast()).equals(key))) {
                        Collections.sort(keyList2, (a, b) -> {
                            if (songMap2.get(a).equals(songMap2.get(b))) {
                                return a - b;
                            }
                            return songMap2.get(b).compareTo(songMap2.get(a));
                        });

                        list.add(keyList2.get(0));
                        if (keyList2.size() >= 2) {
                            list.add(keyList2.get(1));
                        }
                        keyList2.clear();
                        keyList2.add(entry.getKey());
                        continue;
                    }
                }
                keyList2.add(entry.getKey());
            }
        }

        Collections.sort(keyList2, (a, b) -> {
            if (songMap2.get(a).equals(songMap2.get(b))) {
                return a - b;
            }
            return songMap2.get(b).compareTo(songMap2.get(a));
        });

        list.add(keyList2.get(0));
        if (keyList2.size() >= 2) {
            list.add(keyList2.get(1));
        }

        int[] answer = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return answer;
    }
}
