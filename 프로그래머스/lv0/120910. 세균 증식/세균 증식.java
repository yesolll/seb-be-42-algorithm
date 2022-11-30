class Solution {
    public int solution(int n, int t) {
        while(t != 0) {
            n *= 2;
            t--;
        }
        return n;
    }
}