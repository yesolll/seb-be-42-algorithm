import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[][] rotatedBoard = new int[board.length][board.length];

        for (int i = 0; i < rotatedBoard.length; i++) {
            for (int j = 0; j < rotatedBoard[i].length; j++) {
                rotatedBoard[i][j] = board[board.length-1-j][i];
            }
        }

        Stack<Integer> bucket = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            Integer doll = pickDoll(rotatedBoard[moves[i]-1]);
            if (!bucket.empty() && bucket.peek() == doll) {
                bucket.pop();
                answer+=2;
            }
            else {
                if (doll != null) bucket.push(doll);
            }
        }
        return answer;
    }
    
    public Integer pickDoll(int[] board) {
        int depth = board.length - 1;
        int doll = 0;
        while(board[depth] == 0){
            depth--;
            if (depth == 0) break;
        }
        doll = board[depth];
        board[depth] = 0;
        return doll == 0 ? null : doll;
    }
}