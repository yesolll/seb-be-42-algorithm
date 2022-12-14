class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String str : babbling) {
            String word = str.replace("aya","A").replace("ye","B").replace("woo","C").replace("ma","D");
            word = word.replaceAll("A{2,}+", "x").replaceAll("B{2,}+", "x").replaceAll("C{2,}+", "x").replaceAll("D{2,}+", "x");
            System.out.println(word);
            if(isStringUpperCase(word)) answer++;
        }
        return answer;
    }

    private boolean isStringUpperCase(String str){
        if (str.length() == 0) return false;
        char[] charArray = str.toCharArray();
      
        for (int i = 0; i < charArray.length; i++) {
          if (!Character.isUpperCase(charArray[i]))
            return false;
        }
        return true;
    }
}