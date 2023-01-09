import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int max = 0;
        
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    max = triangle[i-1][0];
                } else if (j == triangle[i].length - 1) {
                    max = triangle[i-1][j - 1];
                } else {
                    max = Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
                triangle[i][j] += max;
            }
        }
    return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }
}