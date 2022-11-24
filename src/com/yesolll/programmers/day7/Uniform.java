package com.yesolll.programmers.day7;

import java.util.Arrays;

/*
 * 1. n + 2 크기의 체육복 수 배열 만들기 
 *  (기본값: 1, 도난당한 사람: -1처리, 여벌: +1처리)
 *  맨 앞, 맨 뒤는 index 에러 처리 없이 쉽게 비교하려고... 값은 0으로
 *  [!주의!] 여벌 있는 애도 한 벌 도난 당할 수 있음 ( 진짜 이상한 도둑; )
 * 
 * 2. 반복하면서 체육복 빌리기
 *  if (나 0개 && (앞이 2개 || 뒤가 2개)){
 *      나 ++;
 *      if (앞이 2개) 앞--;
 *      else if (뒤가 2개) 뒤--;
 * }
 * 
 * 3. 체육복이 1개 이상인 아이들 수를 return
 */
public class Uniform {
    public static int solution(int n, int[] lost, int[] reserve) {

        // 1. n + 2 크기의 체육복 수 배열 만들기 
        int[] uniforms = new int[n+2];
        for (int i = 0; i < uniforms.length; i++) {
            uniforms[i] = 1;
        }
        for (int i : lost) {
            uniforms[i] -= 1;
        }
        for (int i : reserve) {
            uniforms[i] += 1;
        }
        uniforms[0] = 0;
        uniforms[uniforms.length - 1] = 0;

        // 2. 반복하면서 체육복 빌리기
        for (int i = 1; i <= n; i ++) {
            if (uniforms[i] == 0 && (uniforms[i - 1] == 2 || uniforms[i + 1] == 2)) {
                uniforms[i]++;
                if (uniforms[i - 1] == 2) uniforms[i-1]--;
                else if (uniforms[i + 1] == 2) uniforms[i+1]--;
            }
        }

        // 3. 체육복이 1개 이상인 아이들 수를 return
        return (int) Arrays.stream(uniforms).filter(i -> i >= 1).count();

    }

    public static void main(String[] args) {
        int output = solution(5, new int[] {1,2,4} , new int[] {1,3,5});
        
    }
}
