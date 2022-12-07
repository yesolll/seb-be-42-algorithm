package com.yesolll.programmers.day10;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class NumberPair {
    public static String solution(String X, String Y) {
        // map에 요소, 개수 로 넣기
        // 맵 돌려서 같은 거 없으면 삭제
        // 더 작은 수만큼 반복
        Comparator<String> comparator = Comparator.reverseOrder();
        Map<String, Integer> xMap = new TreeMap<>(comparator); // key 기준 내림차순 정렬되는 TreeMap
        Map<String, Integer> yMap = new TreeMap<>(comparator);

        // "5525", "1255"
        for(int i = 0; i < X.length(); i++) {
            String cur = String.valueOf(X.charAt(i));
            xMap.put(cur, xMap.getOrDefault(cur, 0) + 1); 
        }
        for(int i = 0; i < Y.length(); i++) {
            String cur = String.valueOf(Y.charAt(i));
            yMap.put(cur, yMap.getOrDefault(cur, 0) + 1); 
        }
        /*
         * xMap: {5=3, 2=1}
         * yMap: {5=2, 2=1, 1=1}
         * 
         */

        for (Iterator<String> iterator = xMap.keySet().iterator(); iterator.hasNext();) {
            String key = iterator.next();
            if (yMap.get(key) == null) iterator.remove();
        }
        for (Iterator<String> iterator = yMap.keySet().iterator(); iterator.hasNext();) {
            String key = iterator.next();
            if (xMap.get(key) == null) iterator.remove();
        }
       /*
         * xMap: {5=3, 2=1}
         * yMap: {5=2, 2=1} 552
         * 
         */

        // 겹치는 거 없을 때: 두 맵 다 비었다    ===>    return -1
        if (xMap.size() == 0 && yMap.size() == 0) return "-1";

        String answer = "";
        //                              어차피 두 Map 키 같으니까 x에서
        for (Iterator<String> iterator = xMap.keySet().iterator(); iterator.hasNext();) {
            String key = iterator.next();
            int repeatMin = Math.min(xMap.get(key), yMap.get(key));
            answer += key.repeat(repeatMin);
        }

        // 00, 000 등등     ===>    return 0
        if (answer.replace("0", "").length() == 0) return "0";
        return answer;
    }
    public static void main(String[] args) {
        String output = solution("5525", "1255");
        // String output = solution("1000", "2030405");
        System.out.println(output);
    }
}
