class Solution {
    public int[] solution(String my_string) {
        int[] answer = {};
        my_string = my_string.replaceAll("[^0-9]","");
        answer = my_string.chars().map(i->i-'0').sorted().toArray();
        return answer;
    }
}