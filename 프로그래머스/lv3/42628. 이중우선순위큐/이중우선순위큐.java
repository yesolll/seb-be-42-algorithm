import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (String opr : operations) {
            if  (opr.equals("D -1")) 
                queue.poll();
            else if (opr.equals("D 1")) {  // && queue.size() != 0
                PriorityQueue<Integer> reverseQueue = 
                    new PriorityQueue<>(Collections.reverseOrder());
                reverseQueue.addAll(queue);
                reverseQueue.poll();
                queue.clear();
                queue.addAll(reverseQueue);
            } else {
                String[] oprs = opr.split(" ");
                queue.add(Integer.parseInt(oprs[1]));
            }
        }
        
        if (queue.size() != 0) {
            answer[1] = queue.poll();
            while (queue.size() > 1) queue.poll();
            answer[0] = queue.poll();
        }
        return answer;
    }
}