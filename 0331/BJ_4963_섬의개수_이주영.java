package mar31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4963_섬의개수_이주영 {
	static int[][] visited;
	static int w, h;
	static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	public static boolean bfs(int[][] map, int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x,y});
		visited[x][y] = 1;
		boolean res = false;
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			
			for(int i=0;i<8;i++) {
				int a = now[0] + dr[i];
				int b = now[1] + dc[i];
				
				if(a>=0 && b>=0 && a<h && b<w && visited[a][b] == 0 && map[a][b] == 1) {
					visited[a][b] = 1;
					que.add(new int[] {a, b});
					res = true;
				}
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) {
				System.out.println(sb);
				return;
			}
			
			int[][] map = new int[h][w];
			visited = new int[h][w];
			
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(map[i][j] == 1 && visited[i][j] == 0) {
						boolean b = bfs(map, i, j);
						
						if(b = true)
							cnt++;
					}
				}
			}
			
			sb.append(cnt+"\n");
			cnt = 0;
		}

	}

}
