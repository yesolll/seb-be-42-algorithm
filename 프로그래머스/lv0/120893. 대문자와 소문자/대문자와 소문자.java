class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder(my_string);
        for (int i = 0; i < my_string.length(); i++) {
            char myChar = my_string.charAt(i);
            if (myChar >= 97) sb.setCharAt(i, Character.toUpperCase(myChar));
            else if (myChar < 97) sb.setCharAt(i, Character.toLowerCase(myChar));
        }
        return sb.toString();
    }
}