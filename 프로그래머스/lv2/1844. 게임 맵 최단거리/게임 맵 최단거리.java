import java.util.*;

class Solution {
    static int[] moveX = {0, 0, 1, -1}; // 상, 하, 우, 좌
    static int[] moveY = {1, -1, 0, 0};
    static boolean[][] visit;
    static int n, m;
    
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        visit = new boolean[n][m];
        bfs(maps);
        return maps[n-1][m-1] > 1 ? maps[n-1][m-1] : -1;
    }
    
    public static class Location {
        int x;
        int y;
        
        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void bfs(int[][] maps) {
        Queue<Location> queue = new LinkedList();
        queue.add(new Location(0, 0));
        visit[0][0] = true;
        
        int curX, curY, nextX, nextY;
        
        while(!queue.isEmpty()) {
            Location curLocation = queue.poll();
            curX = curLocation.x;
            curY = curLocation.y;
            
            for(int i = 0; i < 4; i++) {
                nextX = curX + moveX[i];
                nextY = curY + moveY[i];
                
                if(nextX < 0 || nextY < 0 || nextX >= m || nextY >= n) continue;
                if(!visit[nextY][nextX] && maps[nextY][nextX] == 1) {
                    visit[nextY][nextX] = true;
                    maps[nextY][nextX] += maps[curY][curX];
                    queue.add(new Location(nextX, nextY));
                }
            }
        }
        
    }
}