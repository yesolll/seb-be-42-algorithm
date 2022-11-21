package com.yesolll.programmers.day4;

import java.util.ArrayList;
import java.util.List;

public class SupozaFinal {
    public static void main(String[] args) {
        // 매개변수. main 메서드라 그냥 직접 선언했슴니다
        int[] answers = {3,3,1,1,2};

        // 0. 패턴대로 배열 저장
        int[] supo1 = {1,2,3,4,5};
        int[] supo2 = {2,1,2,3,2,4,2,5};
        int[] supo3 = {3,3,1,1,2,2,4,4,5,5};

        // 1. 패턴대로 반복해서 매개변수로 들어온 답안 길이만큼 늘인다.
        // ex) 정답 개수가 10개라면
        // 1,2,3,4,5            -> 1,2,3,4,5,1,2,3,4,5
        // 2,1,2,3,2,4,2,5      -> 2,1,2,3,2,4,2,5,2,1
        // 3,3,1,1,2,2,4,4,5,5  -> 3,3,1,1,2,2,4,4,5,5
        // 1-1. 늘인 답안을 넣을 배열 선언
        int[] supo1ToAnswerLength = new int[answers.length];
        int[] supo2ToAnswerLength = new int[answers.length];
        int[] supo3ToAnswerLength = new int[answers.length];

        // 1-2. 첫번째 값은 그대로 넣어주고, 나머지는 1번째부터 돌려서 나머지 구해서 넣기 (반복되니까)
        supo1ToAnswerLength[0] = supo1[0];
        supo2ToAnswerLength[0] = supo2[0];
        supo3ToAnswerLength[0] = supo3[0];
        for (int i = 1; i < answers.length; i++) {
            supo1ToAnswerLength[i] = supo1[i % supo1.length];
            supo2ToAnswerLength[i] = supo2[i % supo2.length];
            supo3ToAnswerLength[i] = supo3[i % supo3.length];
        }

        // 2. 정답이랑 비교하면서 맞은 개수를 센 변수 배열 만들기 ( == 채점하기 )
        // 2-1. 맞은 개수 저장할 변수 선언
        int supo1Correct = 0;
        int supo2Correct = 0;
        int supo3Correct = 0;
        for (int i = 0; i < answers.length; i++) {
            // 2-2. if (정답이랑 일치하면)             맞은 개수 ++;
            if (supo1ToAnswerLength[i] == answers[i]) supo1Correct++ ;
            if (supo2ToAnswerLength[i] == answers[i]) supo2Correct++ ;
            if (supo3ToAnswerLength[i] == answers[i]) supo3Correct++ ;
        }
        // 2-3. 맞은 개수 변수를 배열로 [수포자1 맞은 개수, 수포자2 맞은 개수, 수포자 3 맞은 개수]
        int[] correctCnt = {supo1Correct, supo2Correct, supo3Correct};

        // 3. 제일 많이 맞은 사람을 List에 넣기 (->추후에 배열로)
        // (비교한 값이 더 크면 원래 있던애를 빼야 돼서(clear()쓰려고) List에 넣었다가 마지막에 array로 바꿀 예정)
        // 3-1. 배열 선언
        List<Integer> resultList = new ArrayList<>();
        // 3-2. 우선 0을 넣어둠. ( == correctCnt의 index )
        resultList.add(0);

        for (int i = 0; i < 2; i++) {
            // 지금 들어가있는 애의 맞은 개수 < 그 바로 뒤에 애가 맞은 개수이면
            // ex) i = 0일 때
            // correctCnt[0] (수포자 1이 맞은 개수)   < correctCnt [1] (수포자 2가 맞은 개수)   일 때
            if (correctCnt[resultList.get(0)] < correctCnt[i+1]) {
                // 리스트 싹 비워주고
                resultList.clear();
                // 1을 넣어준다. (correctCnt의 index를 넣어주는 것)
                resultList.add(i+1); // == result.add(1);

            // 만약 correctCnt[0] == correct [1] (수포자 1이 맞은 개수 == 수포자 2가 맞은 개수일 때)
            } else if (correctCnt[resultList.get(0)] == correctCnt[i+1]) {
                // 1을 넣어준다. (correctCnt의 index를 넣어주는 것)
                resultList.add(i+1);
            }
        }
        
        // return값은 List to Array 해서. 맞은 개수 배열 index는 0,1,2이고 수포자 이름은 1,2,3이니까 + 1씩 해서 array로.
        resultList.stream().mapToInt(i -> i + 1).toArray();
    }
}
