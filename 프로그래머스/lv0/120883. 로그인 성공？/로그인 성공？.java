class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";
        String id = id_pw[0];
        String pw = id_pw[1];
        for(String[] arr : db) {
            if (id.equals(arr[0]) && pw.equals(arr[1])) answer = "login";
            if (id.equals(arr[0]) && !pw.equals(arr[1])) answer = "wrong pw";
        }
        return answer;
    }
}