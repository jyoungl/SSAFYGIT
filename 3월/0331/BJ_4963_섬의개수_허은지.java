package A형대비;

import java.io.*;
import java.util.*;

/*
 * 가로, 세로, 대각선으로 이어져 있으면 같은 섬
 * >> dfs/bfs
 * >> 팔방탐색
 */
public class s2_4963_섬의개수 {
	static int w, h;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0) break;
			
			map = new int[h][w];
			
			for(int i = 0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			
			for(int i = 0; i<h; i++) {
				for(int j = 0; j<w; j++) {
					if(map[i][j]==1) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append("\n");
			
		}
		
		System.out.println(sb);

	}

	private static void dfs(int i, int j) {
		int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
		int[] dy = {-1, 1, 0, -1, 1, 0, 1, -1};
		
		map[i][j] = 0;
		
		for(int k = 0; k<8; k++) {
			int x = i+dx[k];
			int y = j+dy[k];
			
			if(x<0 || x>=h || y<0 || y>= w || map[x][y]==0) continue;
			
			dfs(x, y);
		}
		
	}
}
