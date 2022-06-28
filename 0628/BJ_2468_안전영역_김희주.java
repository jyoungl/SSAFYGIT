import java.io.*;
import java.util.*;

public class BOJ_2468_안전영역DFS {
	static int N, count = 1;
	static int[][] map;
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		StringTokenizer st;
		int min=Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if(min>map[i][j]) min = map[i][j];
				if(max<map[i][j]) max = map[i][j];
			}
		}

		int tmp;
		for(int i=min;i<max;i++){
			visited = new boolean[N][N];
			tmp = 0;
			for(int r=0;r<N;r++){
				for(int c=0;c<N;c++){
					if(!visited[r][c] && map[r][c]>i){
						dfs(r,c,i);
						tmp++;
					}
				}
			}
			if(tmp>count) count = tmp;
		}
		System.out.println(count);
	}

	private static void dfs(int r, int c, int i) {
		visited[r][c] = true;
		for(int d=0;d<4;d++){
			int nr = r+deltas[d][0];
			int nc = c+deltas[d][1];
			if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && map[nr][nc]>i){
				dfs(nr,nc,i);
			}
		}
	}
}
