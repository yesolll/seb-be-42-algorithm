package com.yesolll.programmers.day6;

public class Ranking {
    public static int[] solution(int[][] score) {
        /*
         * 1. 평균 배열을 만든다 [75, 70, 55, 65] 
         * 
         * 2. 순회하면서 등수를 매긴다 [1, 2, 4, 3]
         *    2-1) 비교해서 점수가 낮은 애 등수++
         *    2-2) 동점일 때 자기 자신이면 등수++, 다른 사람이면 더하지 않는다. (문제조건 공동석차)
         * 
         */

        int[] answer = new int[score.length];
        double[] averageArr = new double[score.length];

        int idx = 0;
        for (int[] arr : score) {
            averageArr[idx] = (arr[0] + arr[1]) / (double)2;
            idx++;
        }

        for (int i = 0; i < averageArr.length; i++) {
            for (int j = i; j < averageArr.length; j++) {
                if (averageArr[i] < averageArr[j]) {
                    // System.out.printf("%f보다 %f가 큽니다, %d번째 올려\n" , averageArr[i], averageArr[j], i);
                    answer[i]++;
                } else if ( i != j && averageArr[i] == averageArr[j]) {
                    // System.out.println("동점");
                } else {
                    // System.out.printf("%f보다 %f가 작거나 본인입니다, %d번째 올려\n" , averageArr[i], averageArr[j], j);
                    answer[j]++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] output = solution(new int[][] {{1, 1}, {1, 1}, {0,1}, {1, 2}});
        // int[] output = solution(new int[][] {{80, 70}, {90, 50}, {40, 70}, {50, 80}});
        // int[] output = solution(new int[][] {{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}});
        for (int i : output) System.out.println(i);
    }
}
