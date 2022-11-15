package com.yesolll.programmers.myself;

public class IceAmericano {
    public int[] solution(int money) {
        int[] answer = new int[2];
        final int AMERICANO_PRICE = 5500;

        answer[0] = (int) money / AMERICANO_PRICE;
        answer[1] = money % AMERICANO_PRICE;
        
        return answer;
    }
}
