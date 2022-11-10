package com.yesolll.programmers.day3;

import java.util.ArrayList;

public class Controlz {

    // public int solution(String s) {
    //     int answer = 0;
    //     String[] strArr = s.split(" ");
        
    //     // 배열의 마지막은 빼고 순회 ([i+1]에서 index exception)
    //     // 현재 글자가 Z가 아니면서(&&) 다음 글자가 Z가 아니면
    //     // parseInt해서 더해주기
    //     for (int i = 0; i < strArr.length - 1; i++) {
    //         if (!strArr[i].equals("Z") && !strArr[i+1].equals("Z")) {
    //             answer += Integer.parseInt(strArr[i]);
    //         }
    //     }
        
    //     // 배열 마지막 요소 처리: Z 아니면 더하기
    //     String lastChar = strArr[strArr.length - 1];
    //     if (!lastChar.equals("Z"))
    //         answer += Integer.parseInt(lastChar);
        
    //     return answer;
    // }

    public int solution(String s) {
        int answer = 0;
        String[] strArr = s.split(" ");
        ArrayList<Integer> sumList = new ArrayList<>();
        for (String str : strArr) {
            if (!str.equals("Z")) {
                sumList.add(Integer.parseInt(str));
            } else if (!sumList.isEmpty() && str.equals("Z")) {
                sumList.remove(sumList.size()-1);
            }
        }
        
        answer = sumList.stream().mapToInt(i -> i).sum();
        
        return answer;
    }

    public static void main(String[] args) {
        Controlz q = new Controlz();
        int output = q.solution("Z Z 1 2 3 Z Z");
        System.out.println(output);
    }
    
}
