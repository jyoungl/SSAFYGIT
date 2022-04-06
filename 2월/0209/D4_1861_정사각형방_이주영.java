package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class D4_1861_정사각형방 {
	static int[][] arr;
	static int N;
	static boolean[][] visited;
	static int max;
	static int pos;
	public static void dfs(int x, int y, int cnt, int start) {
		//상, 하, 좌, 우
		int[] rx = {-1, 1, 0, 0};
		int[] ry = {0, 0, -1, 1};
		
		visited[x][y] = true;
		int move = 1;
		
		for(int i=0;i<4;i++) {
			int dx = x + rx[i];
			int dy = y + ry[i];
			
			if(0<=dx && 0<=dy && dx<N && dy<N) {
				if(!visited[dx][dy] && arr[dx][dy] - arr[x][y] == 1) {
					dfs(dx, dy, cnt+1, start);
				}
			}
		}
		
		if(cnt>max) {
			max = cnt;
			pos = start;
		}
		if(cnt==max) {
			pos = Math.min(pos,  start);
		}
		visited[x][y] = false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=input;tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			max = 0;
			pos = 101;
			visited = new boolean[N][N];
			
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0;j<N;j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					dfs(i, j, 1, arr[i][j]);
				}
			}
			
			sb.append("#" + tc + " " + pos + " " + max + "\n");
		}
		System.out.println(sb);
	}

}
