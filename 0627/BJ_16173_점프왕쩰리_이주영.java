package jun27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16173_점프왕쩰리_이주영 {
    
    static int N;
    static int[][] arr;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static boolean[][] visited;
 
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
        N = Integer.parseInt(br.readLine()); 
        arr = new int[N][N];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        visited = new boolean[N][N];
        bfs();
    }
 
    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.offer(new int[] {0, 0});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int count = arr[now[0]][now[1]];
 
            if(count == -1) {
                System.out.println("HaruHaru");
                return;
            }
 
            for(int i = 0; i < 2; i++) {
                int nx = now[0] + dx[i] * count;
                int ny = now[1] + dy[i] * count;
                if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
    
            }
        }
        System.out.println("Hing");
    }
}