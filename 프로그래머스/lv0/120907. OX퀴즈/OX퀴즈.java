class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int i = 0; i < quiz.length; i++) {
            String[] elements = quiz[i].split(" ");
            String result = String.valueOf(calculate(elements));
            
            if (result.equals(elements[4])) answer[i] = "O";
            else answer[i] ="X";
        }
        return answer;
    }
    
    public int calculate(String[] elements) {
        if (elements[1].equals("+")) 
            return Integer.parseInt(elements[0]) + Integer.parseInt(elements[2]);
        else
            return Integer.parseInt(elements[0]) - Integer.parseInt(elements[2]);
    }
}