package com.yesolll.programmers.day8;

import java.util.*;
import java.util.Map.Entry;

/*
 * 1. 참가자(participant) 목록을 HashMap에 담는다. ex) {leo=1, eden=1, kiki=1}
 *    동명이인은 value++             ex) {leo=1, eden=2, kiki=1}
 * 
 * 2. 완주자 배열(completion)을 순회하면서, 완주자의 value를 1씩 빼준다.
 *     -> 완주하지 못 한 사람의 value만 0이 아님 ex) {leo=0, eden=1, kiki=0}
 * 
 * 3. iterator로 map을 순회하면서, value가 0이 아닌 (미완주) 사람 찾기
 * 
 */
public class Marathon {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        // 1. 참가자(participant) 목록을 HashMap에 담는다. ex) {leo=1, eden=1, kiki=1}
        Map<String, Integer> participantMap = new HashMap<>();              // 참가자 목록 Map을 생성
        for (int i = 0; i < participant.length; i++) {                      // 참가자 배열을 순회하면서
            if (participantMap.get(participant[i]) == null) {               // 현재 Map에 참가자가 없으면
                participantMap.put(participant[i], 1);                      //  value를 1로 추가
            } else {                                                        // Map에 현재 참가자가 있으면 (동명이인)
                participantMap.put( participant[i], participantMap.get(participant[i]) + 1);   
                                                                            //  value++
            }
        }
        System.out.println("참가자 HashMap");
        System.out.println(participantMap);

        
        // 2. 완주자 배열(completion)을 순회하면서, 완주자의 value를 1씩 빼준다.
        for (int i = 0; i < completion.length; i++) {
            participantMap.put(completion[i], participantMap.get(completion[i]) - 1);
        }   // -> 완주하지 못 한 사람의 value만 0이 아닐 것이다.
        System.out.println("완주자 -1");
        System.out.println(participantMap);

        // 3. iterator로 map을 순회하면서, value가 0이 아닌 (미완주) 사람 찾기
        Set<Entry<String, Integer>> entrySet =  participantMap.entrySet();
        Iterator<Entry<String, Integer>> iterator = entrySet.iterator();

        while(iterator.hasNext()) { 
            Entry<String, Integer> currentEntry = iterator.next();
            if (currentEntry.getValue() != 0) return currentEntry.getKey();
        }

        return answer;
    }

    public static void main(String[] args) {
        String output = solution(new String[]{"leo", "kiki", "eden"}, new String[]{"kiki", "eden"});
        System.out.println(output);
    }
}
