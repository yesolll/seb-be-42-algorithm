import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i = 0 ; i < score.length ; i ++) {
            if(queue.size() < k ) {
                queue.add(score[i]);
            } else if(queue.size() == k  && score[i] >= queue.peek()) {
                queue.add(score[i]);
                queue.poll();
            }
            answer[i] = queue.peek();
        }
        return answer;
    }
}