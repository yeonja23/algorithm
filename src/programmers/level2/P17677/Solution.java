package programmers.level2.P17677;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        String str1 = "aaab";
        String str2 = "ab";
        solution(str1, str2);
    }

    static public int solution(String str1, String str2) {
        String str11 = str1.toLowerCase();
        str11 = str11.replaceAll("[^a-z]", " ");
        String str22 = str2.toLowerCase();
        str22 = str22.replaceAll("[^a-z]", " ");

        String[] strArr1 = new String[str11.length() - 1];
        String[] strArr2 = new String[str22.length() - 1];
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();


        for (int i = 0; i < strArr1.length; i++) {
            if (str11.substring(i + 1, i + 2).equals(" ")
                    ||
                    str11.substring(i, i + 1).equals(" ")) {
                continue;
            }

            strArr1[i] = str11.substring(i, i + 2);
            map1.put(strArr1[i], map1.getOrDefault(strArr1[i], 0) + 1);
        }

        for (int i = 0; i < strArr2.length; i++) {
            if (str22.substring(i + 1, i + 2).equals(" ")
                    ||
                    str22.substring(i, i + 1).equals(" ")) {
                continue;
            }
            strArr2[i] = str22.substring(i, i + 2);
            map2.put(strArr2[i], map2.getOrDefault(strArr2[i], 0) + 1);
        }

        int x = 0;  // 교집합
        int y = 0;  // 합집합

        for (String s : map1.keySet()) {
            if (map2.containsKey(s)) {
                x += Math.min(map1.get(s), map2.get(s));
                y += Math.max(map1.get(s), map2.get(s));
            } else {
                y += map1.get(s);
            }
        }

        for (String s : map2.keySet()) {
            if (!map1.containsKey(s)) {
                y += map2.get(s);
            }
        }

        int answer;
        if (x == 0 && y == 0) {
            answer = 1 * 65536;
        } else {
            answer = (int)((double)x / y * 65536);
        }
        return answer;
    }
}
