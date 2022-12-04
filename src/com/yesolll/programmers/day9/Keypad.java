package com.yesolll.programmers.day9;

import java.util.HashMap;
import java.util.Map;

public class Keypad {
    public static String solution(int[] numbers, String hand) {
        Map<String, Integer> currentButton = new HashMap<>(); // 어느 손으로 어떤 버튼 누르고 있는지 담을 map
        currentButton.put("L", 10); // currentButton.put("L", *);
        currentButton.put("R", 12); // currentButton.put("R", #);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            // 1) 1 or 4 or 7 -> 왼손
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer.append("L");
                currentButton.put("L", numbers[i]);
            // 2) 3 or 6 or 9 -> 오른손
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {      
                answer.append("R");          
                currentButton.put("R", numbers[i]);
            // 3) 2 or 5 or 8 or 0 -> 거리 확인
            } else {
                int LeftDistance = getDistance(currentButton.get("L"), numbers[i]);
                int RightDistance = getDistance(currentButton.get("R"), numbers[i]);
                // 3-1) 거리가 같으면 왼손/오른손잡이 대로
                if (LeftDistance == RightDistance) {
                    String finger = hand.equals("left") ? "L" : "R";
                    answer.append(finger);
                    currentButton.put(finger, numbers[i]);
                // 3-2) 왼쪽 손이 가까우면 l
                } else if (LeftDistance < RightDistance){
                    answer.append("L");
                    currentButton.put("L", numbers[i]);
                // 3-3) 오른쪽 손이 가까우면 R
                } else if (LeftDistance > RightDistance){
                    answer.append("R");
                    currentButton.put("R", numbers[i]);
                }
            }
        }
        return answer.toString();
    }

    public static int getDistance(int current, int next) {
        Map<Integer, int[]> locate = new HashMap<>();
        locate.put(1, new int[]{0,0});
        locate.put(2, new int[]{0,1});
        locate.put(3, new int[]{0,2});
        locate.put(4, new int[]{1,0});
        locate.put(5, new int[]{1,1});
        locate.put(6, new int[]{1,2});
        locate.put(7, new int[]{2,0});
        locate.put(8, new int[]{2,1});
        locate.put(9, new int[]{2,2});
        locate.put(10, new int[]{3,0});
        locate.put(0, new int[]{3,1});
        locate.put(12, new int[]{3,2});
        // {
        //     1 {0,0}, 2 {0,1}, 3 {0,2},
        //     4 {1,0}, 5 {1,1}, 6 {1,2},
        //     7 {2,0}, 8 {2,1}, 9 {2,2},
        //     * {3,0}, 0 {3,1}, # {3,2},
        // };
        int[] currentXy = locate.get(current);
        int[] nextXy = locate.get(next);
        int distance = Math.abs(currentXy[0] - nextXy[0]) + Math.abs(currentXy[1] - nextXy[1]);
        return distance;
    }
    public static void main(String[] args) {
        int[] input = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String output = solution(input, "left");
        System.out.println(output);
        //"LRLLRRLLLRR"
    }
    
}
