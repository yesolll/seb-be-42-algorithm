import java.io.*;
import java.util.*;

public class Main {
    static int[] moveX = {0, 0, 1, -1}; // 상, 하, 우, 좌
    static int[] moveY = {1, -1, 0, 0};
    static int[][] maze;
    static boolean[][] visit;
    static int n, m;
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        maze = new int[n][m];
        visit = new boolean[n][m];
        
        String temp;
        for(int i = 0; i < n; i++) {
            temp = sc.next();
            for(int j = 0; j < m; j++) {
                maze[i][j] = temp.charAt(j) - '0';
            }
        }
        
        bfs();
        System.out.println(maze[n-1][m-1]);
    }
    
    public static class Location {
        int x;
        int y;
        
        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void bfs() {
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
                if(!visit[nextY][nextX] && maze[nextY][nextX] == 1) {
                    visit[nextY][nextX] = true;
                    maze[nextY][nextX] += maze[curY][curX];
                    queue.add(new Location(nextX, nextY));
                }
            }
        }
        
    }
}