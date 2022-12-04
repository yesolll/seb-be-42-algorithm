package com.yesolll.programmers.day9;

import java.util.HashMap;
import java.util.Map;

public class Keypad {
    public static String solution(int[] numbers, String hand) {
        Map<String, Integer> map = new HashMap<>();
        map.put("L", 10); // map.put("L", *);
        map.put("R", 12); // map.put("R", #);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer.append("L");
                map.put("L", numbers[i]);
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {      
                answer.append("R");          
                map.put("R", numbers[i]);
            } else {
                int LeftDistance = getDistance(map.get("L"), numbers[i]);
                int RightDistance = getDistance(map.get("R"), numbers[i]);
                if (LeftDistance == RightDistance) {
                    String finger = hand.equals("left") ? "L" : "R";
                    map.put(finger, numbers[i]);
                    answer.append(finger);
                } else if (LeftDistance < RightDistance){
                    answer.append("L");
                    map.put("L", numbers[i]);
                } else if (LeftDistance > RightDistance){
                    answer.append("R");
                    map.put("R", numbers[i]);
                }
            }
        }
        return answer.toString();
    }

    public static int getDistance(Integer current, int next) {
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
        //     {0,0}, {0,1}, {0,2},
        //     {1,0}, {1,1}, {1,2},
        //     {2,0}, {2,1}, {2,2},
        //     {3,0}, {3,1}, {3,2},
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
