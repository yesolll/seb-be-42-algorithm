import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        Map<String, String> map = new HashMap<>();
        map.put("L", "*");
        map.put("R", "#");

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer.append("L");
                map.put("L", String.valueOf(numbers[i]));
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {      
                answer.append("R");          
                map.put("R", String.valueOf(numbers[i]));
            } else {
                int LeftDistance = getDistance(map.get("L"), numbers[i]);
                int RightDistance = getDistance(map.get("R"), numbers[i]);
                if (LeftDistance == RightDistance) {
                    String finger = hand.equals("left") ? "L" : "R";
                    map.put(finger, String.valueOf(numbers[i]));
                    answer.append(finger);
                } else if (LeftDistance < RightDistance){
                    answer.append("L");
                    map.put("L", String.valueOf(numbers[i]));
                } else if (LeftDistance > RightDistance){
                    answer.append("R");
                    map.put("R", String.valueOf(numbers[i]));
                }
            }
        }
        return answer.toString();
    }
    
        public int getDistance(String current, int next) {
        Map<String, int[]> locate = new HashMap<>();
        locate.put("1", new int[]{0,0});
        locate.put("2", new int[]{0,1});
        locate.put("3", new int[]{0,2});
        locate.put("4", new int[]{1,0});
        locate.put("5", new int[]{1,1});
        locate.put("6", new int[]{1,2});
        locate.put("7", new int[]{2,0});
        locate.put("8", new int[]{2,1});
        locate.put("9", new int[]{2,2});
        locate.put("*", new int[]{3,0});
        locate.put("0", new int[]{3,1});
        locate.put("#", new int[]{3,2});

        int[] currentXy = locate.get(current);
        int[] nextXy = locate.get(String.valueOf(next));
        int distance = Math.abs(currentXy[0] - nextXy[0]) + Math.abs(currentXy[1] - nextXy[1]);
        return distance;
    }
}