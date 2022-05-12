package 구현;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 테스트 케이스의 개수
 * 2. 빌딩 지도의 너비 w 높이 h
 * 3. . 빈 공간 # 벽 @ 상근이의 시작 위치 * 불
 * 출력
 * 1. 빌딩을 탈출하는 데 걸리는 가장 빠른 시간
 * 2. 탈출할 수 없으면 IMPOSSIBLE
 * 조건
 * 1. 불은 매 초 동서남북으로 번짐
 * 2. 벽에는 불이 안 붙음
 * 3. 벽, 불이 붙은 칸, 불이 붙으려는 칸으로는 이동할 수 없음
 */
public class G4_5427_불 {
	static int w, h, ans;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<int[]> fire;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			arr = new char[h][w];
			visited = new boolean[h][w];
			fire = new ArrayDeque<>();
			
			int x = 0, y = 0;
			
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					arr[i][j] = str.charAt(j);
					if(arr[i][j] == '@') {
						x = i;
						y = j;
					} else if(arr[i][j] == '*') {
						fire.add(new int[] {i, j});
					}
				}
			}
			
			ans = 0;
			bfs(x, y);
			
			if(ans!=0) sb.append(ans).append("\n");
			else sb.append("IMPOSSIBLE\n");
			
		}
		
		System.out.println(sb);
	}
	
	

private static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		
		int[][] time = new int[h][w];
		
		while(!queue.isEmpty()) {
			fire();
			int cnt = queue.size();
			for (int c = 0; c < cnt; c++) {
				int[] tmp = queue.poll();
				for (int k = 0; k < 4; k++) {
					int i = tmp[0] + dx[k];
					int j = tmp[1] + dy[k];
					
					if(i<0 || i>=h || j<0 || j>=w) {
						ans = time[tmp[0]][tmp[1]] + 1;
						return;
					}
					
					if(visited[i][j] || arr[i][j] == '#' || arr[i][j] == '*') continue;
					
					arr[i][j] = '@';
					queue.add(new int[] {i, j});
					time[i][j] = time[tmp[0]][tmp[1]] + 1;
					visited[i][j] = true;
				}
			}
		}
		
	}



//	private static void dfs(int x, int y, int time) {
//		
//		fire();
//		
//		for (int k = 0; k < 4; k++) {
//			int i = x + dx[k];
//			int j = y + dy[k];
//			
//			if(i<0 || i>=h || j<0 || j>=w) {
//				ans = time + 1;
//				return;
//			}
//			
//			if(visited[i][j] || arr[i][j] == '#' || arr[i][j] == '*') continue;
//			
//			if(arr[x][y] != '*') arr[x][y] = '.';
//			arr[i][j] = '@';
//			visited[i][j] = true;
//			dfs(i, j, time+1);
//			visited[i][j] = false;
//		}
//	}

	private static void fire() {
		int cnt = fire.size();
		
		for (int i = 0; i < cnt; i++) {
			int[] tmp = fire.poll();
			
			for (int k = 0; k < 4; k++) {
				int x = tmp[0] + dx[k];
				int y = tmp[1] + dy[k];
				
				if(x<0 || x>=h || y<0 || y>=w || arr[x][y] == '*' || arr[x][y] == '#') continue;
				
				arr[x][y] = '*';
				fire.add(new int[] {x, y});
			}
		}
		
	}

}
