package programmers.level3.P42579;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] result = solution(genres, plays);
        for (int v : result) {
            System.out.print(v + " ");
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, ArrayList<int[]>> songMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            if (!songMap.containsKey(genres[i])) {
                songMap.put(genres[i], new ArrayList<>());
            }
            songMap.get(genres[i]).add(new int[] {i, plays[i]});
        }

        List<String> genreList = new ArrayList<>(genreMap.keySet());
        genreList.sort((a, b) -> Integer.compare(genreMap.get(b), genreMap.get(a)));

        for (String genre: genreList) {
            songMap.get(genre).sort((a, b) -> {
                        if (a[1] == b[1]) {
                            return Integer.compare(a[0], b[0]);
                        }
                        return Integer.compare(b[1], a[1]);
                    });
            for (int i = 0; i < Math.min(2, songMap.get(genre).size()); i++) {
                list.add(songMap.get(genre).get(i)[0]);
            }
        }
        int[] answer = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;
    }
}