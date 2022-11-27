package com.yesolll.programmers.day7;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public static int[] solution(int[] lottos, int[] win_nums) {
        
        int[] answer = new int[2];          // 정답 배열: length 2
        int[] rank = {6, 6, 5, 4, 3, 2, 1}; // 등수 배열: 0개면 6등, 1개면 6등, 2개면 5등 ..., 6개면 1등

        List<Integer> sortedLotto = Arrays.stream(lottos).sorted().boxed().collect(Collectors.toList());
        List<Integer> sortedWin = Arrays.stream(win_nums).sorted().boxed().collect(Collectors.toList());

        if (sortedLotto.containsAll(sortedWin)) return new int[] {1, 1}; // 전부 일치하면 1등

        int zeroCnt = 0;
        int sameCnt = 0;
        for (int num : sortedLotto) {   
            if (num == 0) {                 // 0 개수 구하기
                zeroCnt++;
                continue;
            }
            if (sortedWin.contains(num)) {  // 맞은 개수 구하기
                sameCnt++;
            }
        }

        if (zeroCnt == 6) return new int[] {1, 6};  // 0만 6개면 1등 or 6등

        answer[0] = rank[sameCnt + zeroCnt];    // 0으로 들어온 게 다 맞았을 때 == 최고 등수
        answer[1] = rank[sameCnt];              // 0으로 들어온 게 다 틀렸을 때 == 최저 등수 (현재 맞은 개수의 등수)
        
        return answer;
    }

    public static void main(String[] args) {
        int[] output = solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
        for (int i : output) {
            System.out.println(i);
        }
    }
}
