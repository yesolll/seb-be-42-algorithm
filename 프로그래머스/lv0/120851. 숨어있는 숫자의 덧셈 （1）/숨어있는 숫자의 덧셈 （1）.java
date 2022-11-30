class Solution {
    public int solution(String my_string) {
        String intStr = my_string.replaceAll("[^0-9]", "");
        return intStr.chars().map(i->i-'0').sum();
    }
}