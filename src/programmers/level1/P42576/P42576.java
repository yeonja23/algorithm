package programmers.level1.P42576;

import java.util.HashMap;
import java.util.Map;

public class P42576 {
    public String P42576(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();
        Map<String, Integer> completionMap = new HashMap<>();
        String answer = "";

        for (int i = 0; i < participant.length; i++) {
            participantMap.put(participant[i], participantMap.getOrDefault(participant[i], 0) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            completionMap.put(completion[i], completionMap.getOrDefault(completion[i], 0) + 1);
        }

        for (String key : participantMap.keySet()) {
            if (completionMap.getOrDefault(key, 0) == 0) {
                answer = key;
                break;
            }
            if (!participantMap.get(key).equals(completionMap.get(key))) {
                answer = key;
            }
        }

        return answer;
    }
}
