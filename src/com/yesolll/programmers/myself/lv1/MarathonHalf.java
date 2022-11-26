package com.yesolll.programmers.myself.lv1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MarathonHalf {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        List<String> completionList = Arrays.stream(completion).collect(Collectors.toList());

        for (String name : participant){                // 참가자 전원 배열을 순회하면서
            int idx = completionList.indexOf(name);
            if (idx > -1) completionList.remove(idx);   // 현재 참가자가 완주 목록에 있으면 (index가 -1보다 크면) List에서 삭제
            else answer = name;                         // 그렇지 않으면 (index가 -1이면) 그 사람은 미완주가 된다.
            System.out.println(completionList);
        }

        return answer;
    }

    public static void main(String[] args) {
        String output = solution(new String[]{"leo", "kiki", "kiki", "eden", "kiki", "eden"}, new String[]{ "kiki", "eden", "eden", "kiki", "leo"});
        System.out.println(output);
    }
}
