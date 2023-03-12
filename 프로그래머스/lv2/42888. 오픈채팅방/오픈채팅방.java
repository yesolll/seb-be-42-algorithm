import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        
        Map<String, String> suffix = new HashMap<>();
        suffix.put("Enter", "님이 들어왔습니다.");
        suffix.put("Leave", "님이 나갔습니다.");
        
        Map<String, String> user = new HashMap<>();
        for (String r : record) {
            String[] info = r.split(" ");
            String type = info[0];
            String uid = info[1];
            
            if (!type.equals("Leave")) {
                String nickname = info[2];
                user.put(uid, nickname);
            }
            if (!type.equals("Change")) {
                answer.add(uid.concat(suffix.get(type)));
            }
        }
        
        for (int i = 0; i < answer.size(); i++) {
            String msg = answer.get(i);
            int idx = msg.indexOf("님");
            String uid = answer.get(i).substring(0, idx);
            msg = answer.get(i).replace(uid, user.get(uid));
            answer.set(i, msg);
        }
        
        return answer.toArray(new String[0]);
    }
}