package com.yesolll.programmers.day9;

import java.util.Stack;

public class DollDrawing {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        // 1. board 90도 회전
        int[][] rotatedBoard = new int[board.length][board.length];
        for (int i = 0; i < rotatedBoard.length; i++) {
            for (int j = 0; j < rotatedBoard[i].length; j++) {
                rotatedBoard[i][j] = board[board.length-1-j][i];
            }
        }
        for (int [] arr : rotatedBoard) {
            for (int i : arr) System.out.print(i);
            System.out.println();
        }

        // 2. 인형 뽑아서 stack에 push
        // * 바로 전 인형과 같으면 pop하고 answer+=2 (두 개가 같이 사라짐)
        Stack<Integer> bucket = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            Integer doll = pickDoll(rotatedBoard[moves[i]-1]);
            if (!bucket.empty() && bucket.peek() == doll) {
                bucket.pop();
                answer+=2;
            } else { // 바로 전 인형과 같지 않으면 push
                if (doll != null) bucket.push(doll);
            }
        }
        return answer;
    }

    // 인형 뽑기 ex) 34000
    public static Integer pickDoll(int[] board) {
        int depth = board.length - 1;
        int doll = 0;

        // 맨 뒤에서 시작해서 0 아닌 숫자 나올 때까지 반복
        // 맨 앞까지 왔는데 0이면 멈추기
        while(board[depth] == 0){
            depth--;
            if (depth == 0) break;
        }
        // depth번째 인형 뽑고 그 인형은 빈공간 처리 (0 대입)
        doll = board[depth];
        board[depth] = 0;
        // 뽑은 인형이 0이면 null 아니면 doll 숫자 return
        return doll == 0 ? null : doll;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int output = solution(board, moves);
        System.out.println(output);
    }
}
