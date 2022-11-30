package com.yesolll.programmers.day8;

public class FoodFighter {

    public static String solution(int[] food) {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < food.length; i++) {
            if (food[i] >= 2) // 1개면 못 쓰니까
                sb.append(String.valueOf(i).repeat(food[i] / 2)); // i를 food[i]/2 번 만큼 붙이기
        }

        String thisSide = sb + "0";
        return thisSide + sb.reverse().toString();

    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 6}));
    }
}
