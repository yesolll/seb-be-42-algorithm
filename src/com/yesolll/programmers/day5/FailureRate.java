package com.yesolll.programmers.day5;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FailureRate {
    public static int[] solution(int N, int[] stages) {
        // [2, 1, 2, 6, 2, 4, 3, 3]
        List<Integer> stageList = Arrays.stream(stages).boxed().collect(Collectors.toList());
        int[] answer = {};
        int failure = 0;

        // <스테이지, 실패율>
        Map<Integer, Double> map = new HashMap<>();
        // 스테이지 1, 2, 3, ..., N까지 반복하면서
        for (int i = 1; i <= N; i++) {
            // stateList에 i가 몇 개 있는 지 세어준다.
            // == 스테이지 i에 아직 클리어하지 못 한 유저가 몇 명인지 세어준다
            failure = Collections.frequency(stageList, i);

            // put(클리어하지 못한 유저가 0명이면) ?  0 : 클리어하지 못한 유저 / 도전자 수              (문제 조건)
            map.put(i, failure == 0 ? 0 : failure/(double)stages.length);

            // 현재 스테이지 도전자 수    == 총 도전자 수 (stages.length) - 이전 스테이지를 클리어하지 못한 사람 수 (failure)
            // ex) 2번 스테이지 도전자 수 == 총 도전자 수(8)              - 1번 스테이지 클리어하지 못한 사람(1) => 7명
            //     3번 스테이지 도전자 수 == 2번 스테이지 도전자 수(7)     - 2번 스테이지 클리어하지 못한 사람(3) => 4명
            stages = Arrays.copyOfRange(stages, failure, stages.length);
        }

        /* 맵 결과 확인 */
        // for(Entry<Integer, Double> entry : map.entrySet()) {
        //     System.out.print("key: " +  entry.getKey());
        //     System.out.println("value " + entry.getValue());
        // }

        // 최종적으로 만들어진 {스테이지 = 실패율} map을 실패율 기준 내림차순으로 정렬                   (문제 조건)
        List<Entry<Integer, Double>> sorted =  map.entrySet().stream()
                                                            .sorted(Collections.reverseOrder(Entry.comparingByValue()))
                                                            // Stream<Map.Entry<Integer,Double>> -> List
                                                            .collect(Collectors.toList());

        // 스테이지(key)만 뽑아서 배열로 변환
        answer = sorted.stream().mapToInt(el -> el.getKey()).toArray();

        return answer;
    }

    public static void main(String[] args) {
        int[] output = solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3});
        // for (int i : output) {
        //     System.out.println(i);
        // }
    }
}
