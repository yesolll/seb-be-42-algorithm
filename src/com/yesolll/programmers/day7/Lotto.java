package com.yesolll.programmers.day7;

/*
 * 정답 배열: int[2] answer => [최고등수, 최저등수]
 * 
 *                          0  1  2  3  4  5  6
 * 등수 배열: int[] rank = {6, 6, 5, 4, 3, 2, 1}; index: 맞힌 개수, value: 등수
 * 
 * ※ 전부 일치하면 return [1, 1]
 * 
 * 1. 내 로또번호 순회하면서 0개수, 맞힌 개수 구하기
 * 
 * 2-1. 0만 6개면 1등 or 6등
 * 2-2. 0으로 들어온 게 다 맞았을 때 == 맞힌 개수 + 0 개수
 * 2-3. 0으로 들어온 게 다 틀렸을 때 == 맞힌 개수
 */
public class Lotto {
    public static int[] solution(int[] lottos, int[] win_nums) {
        
        int[] answer = new int[2];          // 정답 배열 [최고등수, 최저등수]

        //            0  1  2  3  4  5  6   // index: 맞힌 개수, value: 등수
        int[] rank = {6, 6, 5, 4, 3, 2, 1}; // 등수 배열 

        if (lottos.equals(win_nums)) return new int[] {1, 1}; // 전부 일치하면 1등

        int zeroCnt = 0;
        int sameCnt = 0;
        for (int num : lottos) {            // 내 로또번호 순회하면서
            if (num == 0) {                 // 0 개수 구하기
                zeroCnt++;
                continue;
            }
            for (int i : win_nums) {        
                if (num == i) sameCnt++;    // 맞힌 개수 구하기
            }
        }
        // 6개 전부 0이면  1등 or 6등
        if (zeroCnt == 6) return new int[] {1, 6};  

        answer[0] = rank[sameCnt + zeroCnt];    // 0으로 들어온 게 다 맞았을 때 == 맞힌 개수 + 0 개수 [최고]
        answer[1] = rank[sameCnt];              // 0으로 들어온 게 다 틀렸을 때 == 맞힌 개수          [최저]
        
        return answer;
    }

    public static void main(String[] args) {
        int[] output = solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
        for (int i : output) {
            System.out.println(i);
        }
    }
}
