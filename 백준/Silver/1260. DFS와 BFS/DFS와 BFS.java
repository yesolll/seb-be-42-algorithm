import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph; // 인접행렬
    static boolean[] visit; // 방문 여부
    static int n, m, v; // 정점 개수, 간선 개수, 탐색 시작

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();
  
        graph = new int[1001][1001];
        visit = new boolean[1001];
        
        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = graph[y][x] = 1;
        }
        
        dfs(v);
        Arrays.fill(visit, false);
        System.out.println();
        bfs(v);
    }
    
    public static void dfs(int i) {
        visit[i] = true;
        System.out.print(i + " ");
    
        for(int j = 1; j <= n; j++) {
            if(graph[i][j] == 1 && visit[j] == false) dfs(j);
        }
    }
    
    public static void bfs(int i){
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(i);
		visit[i] = true;
        
		while(!queue.isEmpty()){
			int temp = queue.poll();
			System.out.print(temp + " ");
			
			for(int j = 1; j <= n; j++){
				if(graph[temp][j] == 1 && visit[j] == false){
					queue.offer(j);
					visit[j] = true;
				}
			}
		}
	}
}