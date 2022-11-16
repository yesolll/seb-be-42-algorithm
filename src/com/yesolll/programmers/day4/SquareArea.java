package com.yesolll.programmers.day4;

public class SquareArea {
    public static void main(String[] args) {

        int[][] dots = new int[][] {{1, 1}, {2, 1}, {2, 2}, {1, 2}};
        int x1 = dots[0][0];
        int x2 = 0;
        
        int y1 = dots[0][1];
        int y2 = 0;

        for (int[] dot : dots) {
            if ( x1 != dot[0] ) {
                x2 = dot[0];
                break;
            }
        }

        for (int[] dot : dots) {
            if ( y1 != dot[1] ) {
                y2 = dot[1];
                break;
            }
        }

        System.out.printf("x1, x2: %d, %d \n", x1, x2);
        System.out.printf("y1, y2: %d, %d", y1, y2);

        int width = Math.abs(x1 - x2);
        int height = Math.abs(y1 - y2);

        int answer = width * height;
        System.out.println(answer);

    }
}
