import java.util.*;
import java.util.Map.Entry;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> participantMap = new HashMap<>();
        for (int i = 0; i < participant.length; i++) { 
            if (participantMap.get(participant[i]) == null) {  
                participantMap.put(participant[i], 1); 
            } else {
                participantMap.put(
                    participant[i], participantMap.get(participant[i]) + 1      
                ); 
            }
        }

        for (int i = 0; i < completion.length; i++) {
            participantMap.put(
                completion[i], participantMap.get(completion[i]) - 1
            );
        }

        Set<Entry<String, Integer>> entrySet =  participantMap.entrySet();
        Iterator<Entry<String, Integer>> iterator = entrySet.iterator();

        while(iterator.hasNext()) {
            Entry<String, Integer> currentEntry = iterator.next();
            if (currentEntry.getValue() != 0) return currentEntry.getKey();
        }

        return answer;
    }
}