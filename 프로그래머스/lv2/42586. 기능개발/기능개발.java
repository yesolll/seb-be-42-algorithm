import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        if (progresses.length == 1) {
            return new int[]{1};
        }
        List<Integer> deployments = new ArrayList<>();
        Queue<Double> tasks = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            double days = 0;
            days = (100 - progresses[i]) / (double) speeds[i];
            tasks.add(Math.ceil(days));
        }
        
        int repeatCnt = tasks.size();
        for (int i = 0; i < tasks.size();) {
            double task = tasks.poll();
            int deployCnt = 1;
            while (tasks.size() >= 1 && task >= tasks.peek()) {
                System.out.println(tasks.poll());
                deployCnt++;
            }
            deployments.add(deployCnt);
        }
        return deployments.stream().mapToInt(i->i).toArray();
    }
}