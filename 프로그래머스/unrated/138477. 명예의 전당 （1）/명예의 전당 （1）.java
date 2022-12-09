import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int minScore = score[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i = 0 ; i < score.length ; i ++) {
            if(queue.size() < k ) {
                queue.add(score[i]);
                minScore = queue.peek();
            } else if(queue.size() == k  && score[i] >= minScore) {
                queue.add(score[i]);
                minScore = queue.poll();
            }
            answer[i] = queue.peek();
        }
        return answer;
    }
}