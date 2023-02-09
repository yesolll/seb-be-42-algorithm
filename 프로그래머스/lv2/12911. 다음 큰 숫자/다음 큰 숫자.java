class Solution {
    public static int solution(int n) {
        int bitCnt = Integer.bitCount(n);

        while (true) {
            n++;
            int nextBitCnt = Integer.bitCount(n);

            if (nextBitCnt == bitCnt) return n;
        }
    }
}