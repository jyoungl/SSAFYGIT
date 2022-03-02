

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 테스트 케이스 개수 T
 * 2. 체스판의 한 변의 길이 I
 * 3. 나이트가 현재 있는 칸
 * 4. 나이트가 이동하려고 하는 칸
 * 출력
 * 1. 나이트가 최소 몇 번 움직여야 이동할 수 있는지
 * 
 * >> bfs
 */
public class BJ_7562_나이트의이동_허은지 {
	static int I, ans;
	static int endX, endY;
	static int[][] chess;
	static boolean[][] visited;
	
	static class Knight {
		int x;
		int y;
		int count;
		Knight(int x, int y, int count){
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<T; tc++) {
			I = Integer.parseInt(br.readLine());
			chess = new int[I][I];
			visited = new boolean[I][I];

			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			
//			if(startX == endX && startY == endY) {
//				sb.append(0).append("\n");
//				continue;
//			}
			
			bfs(startX, startY, 0);
			
			sb.append(ans).append("\n");
			
		}
		
		System.out.println(sb);

	}

	private static void bfs(int x, int y, int count) {
		int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
		int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

		Queue<Knight> queue = new LinkedList<>();
		queue.add(new Knight(x,y,count));
		visited[x][y] = true;

		while(!queue.isEmpty()) {
			Knight kn = queue.poll();
			if(kn.x== endX && kn.y == endY) {
				ans = kn.count;
				return;
			}
			
			for(int k = 0; k<8; k++) {
				int i = kn.x+dx[k];
				int j = kn.y+dy[k];
				int cnt = kn.count+1;
				if(i<0 || i>=I || j<0 || j>=I || visited[i][j]) continue;
				queue.add(new Knight(i, j, cnt));
				visited[i][j] = true;
			}
						
		}
		
	}

}
