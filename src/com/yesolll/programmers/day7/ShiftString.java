package com.yesolll.programmers.day7;

/*
 * 한 번 밀고 시작한다.
 * 
 * while (자신으로 돌아올 때까지) {
 * if B와 일치하면
 *  return shiftCnt
 * 아니면 또 밀고 shiftCnt++
 * }
 * 
 * while 탈출 했으면 (자신까지 돌아왔으면)
 * return -1
 * 
 * [주의] A == B -> return 0
 */
public class ShiftString {
    public static int solution(String A, String B) {

        String shiftedA = shift(A);
        int shiftCnt = 1; // 한 번 밀어주고 시작 (while 조건 때문에)
        
        if(A.equals(B)) return 0; // 같은 문자열이 들어오면 0번!

        while (!shiftedA.equals(A)) { // 자기 자신으로 돌아올 때까지 밀어주기
            if (shiftedA.equals(B)) return shiftCnt;
            shiftedA = shift(shiftedA);
            shiftCnt++;
        }
        return -1;

    }

    // >> 오른쪽으로 한 칸씩 밀어주는 작업
    private static String shift(String A) {
        // ex) A = Algorith"m" -----> "m"Algorith
        return A.charAt(A.length()-1) + A.substring(0, A.length()-1);
    }

    public static void main(String[] args) {
        System.out.println(solution("Algorithm", "hmAlgorit"));
    }
}
