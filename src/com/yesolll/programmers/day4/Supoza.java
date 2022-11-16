package com.yesolll.programmers.day4;

import java.util.ArrayList;
import java.util.List;

public class Supoza {
    public static void main(String[] args) {
        int[] answers = {3,3,1,1,2};
        // int[] answers = {3,3,1,1,2,2,4,4,5,5};

        int[] supo1 = {1,2,3,4,5};
        int[] supo2 = {2,1,2,3,2,4,2,5};
        int[] supo3 = {3,3,1,1,2,2,4,4,5,5};

        int[] supo1ToAnswerLength = new int[answers.length];
        int[] supo2ToAnswerLength = new int[answers.length];
        int[] supo3ToAnswerLength = new int[answers.length];
        supo1ToAnswerLength[0] = supo1[0];
        supo2ToAnswerLength[0] = supo2[0];
        supo3ToAnswerLength[0] = supo3[0];

        for (int i = 1; i < answers.length; i++) {
            supo1ToAnswerLength[i] = supo1[i % supo1.length];
            supo2ToAnswerLength[i] = supo2[i % supo2.length];
            supo3ToAnswerLength[i] = supo3[i % supo3.length];
        }

        int supo1Correct = 0;
        int supo2Correct = 0;
        int supo3Correct = 0;
        for (int i = 0; i < answers.length; i++) {
            if (supo1ToAnswerLength[i] == answers[i]) supo1Correct++ ;
            if (supo2ToAnswerLength[i] == answers[i]) supo2Correct++ ;
            if (supo3ToAnswerLength[i] == answers[i]) supo3Correct++ ;
        }
        int[] correct = {supo1Correct, supo2Correct, supo3Correct};
        System.out.println("supo1Correct: " + supo1Correct);
        System.out.println("supo2Correct: " + supo2Correct);
        System.out.println("supo3Correct: " + supo3Correct);
        List<Integer> resultList = new ArrayList<>();
        resultList.add(1);
        for (int i = 0; i < 2; i++) {
            System.out.println("correct[i]: " + correct[i]);
            System.out.println("correct[i+1]: " + correct[i+1]);
            System.out.println("correct[resultList.get(0)-1]: " + correct[resultList.get(0)-1]);
            System.out.println(correct[resultList.get(0)-1] < correct[i+1]);
            System.out.println(correct[i+1] != 0 && correct[resultList.get(0)-1] == correct[i+1]);
            if (correct[resultList.get(0)-1] < correct[i+1]) {
                System.out.println("i= " + (resultList.get(0)-1));
                System.out.println("i+2= " + (i+2));
                // resultList.remove(resultList.get(0)-1);
                resultList.remove(0);
                resultList.add(i+2);
            } else if (correct[i+1] != 0 && correct[resultList.get(0)-1] == correct[i+1]) {
                resultList.add(i+2);
            }
        }
        // if(correct[0] == 0 && correct[1] == 0 && correct[2] == 0){
        //     resultList.clear();
        // }
        System.out.println(resultList);
        resultList.stream().mapToInt(i -> i).toArray();
    }
}