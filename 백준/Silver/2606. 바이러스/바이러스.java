import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph; // 인접행렬
    static boolean[] visit; // 방문 여부
    static int n, m; // 정점 개수, 간선 개수
    static int count = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
  
        graph = new int[n + 1][n + 1];
        visit = new boolean[n + 1];
        
        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = graph[y][x] = 1;
        }
        
		sc.close();        
        System.out.println(dfs(1));
    }
    
    public static int dfs(int i) {
		visit[i] = true;
		
		for(int j = 1; j <= n; j++) {
			if(graph[i][j] == 1 && visit[j] == false) {
				count ++;
				dfs(j);
			}
		}
		return count;
	}
}