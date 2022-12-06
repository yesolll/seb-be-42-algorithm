class Solution {
    public int solution(int[] array, int n) {
        int maxDiff = 100;
        int answer = 0;
        for (int i = 0; i < array.length; i++){
            int diff = Math.abs(array[i] - n);
            if(maxDiff > diff){
                answer = array[i];
                maxDiff = diff;
            } else if (maxDiff == diff) {
                if(answer > array[i]){
                    answer = array[i];
                    maxDiff = diff;
                }
            }
        }
        return answer;
    }
}