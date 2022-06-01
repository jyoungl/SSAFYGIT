package 구현;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. N M
 * 2. 치즈 1 없으면 0
 * 출력
 * 1. 녹는 데 걸리는 시간 
 * 조건
 * 1. 2변 이상이 접촉하면 녹음
 * 2. 외부 공기와 접촉하지 않으면 안 녹음
 */
public class G4_2638_치즈 {
	static int N, M, ans, arr[][];
	static boolean visited[][];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		int cheeze = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) cheeze++;
			}
		}

		cheeze(0, cheeze);
		
		System.out.println(ans);
	}

	private static void cheeze(int cnt, int cheeze) {
		if(cheeze <= 0) {
			ans = cnt;
			return;
		}
		
		visited = new boolean[N][M];
		isAir(0, 0);
		
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < M-1; j++) {
				if(arr[i][j] == 1) {
					int melt = 0;
					
					for (int k = 0; k < 4; k++) {
						if(melt==2) break;
						
						int x = i+dx[k];
						int y = j+dy[k];
						
						if(visited[x][y]) melt++;
					}
					
					if(melt>=2) {
						arr[i][j] = 2;
						cheeze--;
					}
				}
			}
		}
		
		cheeze(cnt+1, cheeze);
		
	}

	private static void isAir(int i, int j) {
		visited[i][j] = true;
		arr[i][j] = 2;
		
		for (int k = 0; k < 4; k++) {
			int x = i+dx[k];
			int y = j+dy[k];
			
			if(x < 0 || x>=N || y<0 || y>=M || visited[x][y] || arr[x][y] == 1) continue;
			
			isAir(x, y);
		}
		
	}

}
