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
        int shiftCnt = 1;
        
        if(A.equals(B)) return 0;
        while (!shiftedA.equals(A)) {
            if (shiftedA.equals(B)) return shiftCnt;
            shiftedA = shift(shiftedA);
            shiftCnt++;
        }
        return -1;

    }

    private static String shift(String A) {
        return A.charAt(A.length()-1) + A.substring(0, A.length()-1);
    }

    public static void main(String[] args) {
        System.out.println(solution("aaa", "aaa"));
    }
}
