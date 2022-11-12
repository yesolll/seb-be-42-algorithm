package com.yesolll.programmers.day3;

public class The2016 {

    public String solution(int a, int b) {

        String answer = "";
        String[] weekdays = {"THU", "FRI", "SAT","SUN", "MON", "TUE", "WED"};
        int days[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dayOfYear = 0;

        for (int i = 0; i < a - 1; i++) {
            dayOfYear += days[i];
        }
        dayOfYear += b;
        
        answer = weekdays[dayOfYear % 7];

        return answer;
    }

    public static void main(String[] args) {

        The2016 q = new The2016();
        String output = q.solution(1, 3);
        System.out.println(output);

    }

}
