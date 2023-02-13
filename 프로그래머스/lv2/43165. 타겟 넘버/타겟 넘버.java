class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    private static int dfs(int[] numbers, int target, int sum, int curIdx) {
        int answer = 0;

        if (curIdx == numbers.length) {
            if (target == sum) {
                return 1;
            }
            return 0;
        }

        answer += dfs(numbers, target, sum + numbers[curIdx], curIdx + 1);
        answer += dfs(numbers, target, sum + numbers[curIdx] * -1, curIdx + 1);

        return answer;
    }

}