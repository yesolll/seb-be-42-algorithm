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
        // ex) N=5, stages = [2, 1, 2, 6, 2, 4, 3, 3]

        List<Integer> stageList = Arrays.stream(stages).boxed().collect(Collectors.toList());
        int ChallengerCnt = stages.length;
        int failure = 0;
        // <스테이지, 실패율>
        Map<Integer, Double> map = new HashMap<>();

        /* 1. 스테이지 별 실패율 구해서 map에 넣어주기 */
        // 스테이지 1, 2, 3, ..., N까지 반복하면서
        for (int i = 1; i <= N; i++) {
            // == 스테이지 i에 아직 클리어하지 못 한 유저가 몇 명인지 세어준다.
            failure = Collections.frequency(stageList, i);

            // put(클리어하지 못한 유저가 0명이면) ?  0 : 클리어하지 못한 유저 / 도전자 수          (* ?)
            map.put(i, failure == 0 ? 0 : failure/(double)ChallengerCnt);

            // 현재 스테이지 도전자 수    == 총 도전자 수 (ChallengerCnt) - 이전 스테이지를 클리어하지 못한 사람 수 (failure)
            // ex) 2번 스테이지 도전자 수 ==        총 도전자 수(8)       - 1번 스테이지 클리어하지 못한 사람(1) => 7명
            //     3번 스테이지 도전자 수 == 2번 스테이지 도전자 수(7)    - 2번 스테이지 클리어하지 못한 사람(3) => 4명
            ChallengerCnt = ChallengerCnt - failure;
        }

        /* 맵 결과 확인 */
        for(Entry<Integer, Double> entry : map.entrySet()) {
            System.out.print("key: " +  entry.getKey() + " ");
            System.out.println("value " + entry.getValue());
        }

        /* 2. 실패율을 기준으로 정렬해주기 */
        // 최종적으로 만들어진 {스테이지 K = 실패율 V} map을 실패율(V) 기준 내림차순으로 정렬                   (문제 조건)
        List<Entry<Integer, Double>> sorted =  map.entrySet().stream()
                                                            .sorted(Collections.reverseOrder(Entry.comparingByValue()))
                                                            // Stream<Map.Entry<Integer,Double>> -> List
                                                            .collect(Collectors.toList());

        /* 3. 정렬된 entry의 key들을 배열로 만들어주기 */
        // 스테이지(key)만 뽑아서 배열로 변환
        int[] answer = sorted.stream().mapToInt(el -> el.getKey()).toArray();

        return answer;
    }

    public static void main(String[] args) {
        int[] output = solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3});
        for (int i : output) {
            System.out.println(i);
        }
    }
}
