package jan04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3184_양_이주영 {
	public static int[] dr = {1,-1,0,0};
	public static int[] dc = {0,0,1,-1};
	public static char[] mark = {'.', '#', 'o', 'v'};
	public static char[][] arr;
	public static boolean[][] visited;
	public static int R,C;
	public static int sans, wans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			char[] ch = st.nextToken().toCharArray();
			for(int j=0;j<C;j++)
				arr[i][j] = ch[j];
		}
		
		for(int i=1;i<R;i++) {
			for(int j=1;j<C;j++) {
				if(!visited[i][j]) {
					if(arr[i][j] == mark[0])
						bfs(i,j,0,0);
					else if(arr[i][j] == mark[2]) {
						bfs(i,j,1,0);
					}
					else if(arr[i][j] == mark[3]) {
						bfs(i,j,0,1);
					}
				}
			}
		}
		System.out.println(sans + " " + wans);
	}

	public static void bfs(int x, int y, int sheep, int wolf) {
		Queue<int[]> que = new LinkedList<>();
		visited[x][y] = true;
		que.add(new int[] {x,y});
	
		while(!que.isEmpty()) {
			int[] now = que.poll();

			for(int i=0;i<4;i++) {
				int dx = now[0] + dr[i];
				int dy = now[1] + dc[i];

				if(dx<0 || dy<0 || dx>=R-1 || dy>=C-1 || visited[dx][dy] || arr[dx][dy] == mark[1])
					continue;
				else {
					if(arr[dx][dy] == mark[2]) {
						sheep++;
						que.add(new int[] {dx,dy});
					}
					else if(arr[dx][dy] == mark[3]) {
						wolf++;
						que.add(new int[] {dx,dy});
					}
					else if(arr[dx][dy] == mark[0])
						que.add(new int[] {dx,dy});
					
					visited[dx][dy] = true;
				}
			}
		}
		
		if(sheep > wolf)
			sans += sheep;
		else
			wans += wolf;
	}
}
