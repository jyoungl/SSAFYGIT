package 구현;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 세로 N 가로 M
 * 2. 로봇청소기 좌표 r,c 방향 d(0북 1동 2남 3서)
 * 3. 장소의 상태 0빈칸 1벽
 * 출력
 * 1. 로봇청소기가 청소하는 칸의 개수
 * 조건
 * 1. 현재 위치를 청소한다
 * 2. 바로 왼쪽에 청소하지 않은 빈공간이 존재하면, 왼쪽 방향으로 회전한 다음 전진
 * 3. 바로 왼쪽에 청소하지 않은 빈공간이 없다면, 왼쪽 방향으로 회전
 * 4. 계속 빙글 돌 경우, 바로 뒤가 벽이면 작동을 멈춘다 그렇지 않다면 한칸 후진
 */
public class g5_14503_로봇청소기 {
	static int N, M, arr[][];
	//static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		//visited = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 1;
		
		clean(r, c, d, cnt);
		
	}

	private static void clean(int r, int c, int d, int cnt) {
		int[] dx = {0, -1, 0, 1};
		int[] dy = {-1, 0, 1, 0};
		int[] dir = {3, 0, 1, 2};
		int x=0, y=0;
		
		arr[r][c] = 2;
		
		for(int k = 0; k<4; k++) {
			x = r + dx[d];
			y = c + dy[d];
			d = dir[d];
			if(x<0 || x>=N || y<0 || y>=M || arr[x][y]!=0) continue;
			//System.out.println("청소하기: " + x + " " + y + " " + d + " "+ (cnt+1));
			clean(x, y, d, cnt+1);
		}

		x = r+dx[dir[d]];
		y = c+dy[dir[d]];
		//System.out.println("후진하기: " + x + " " + y + " " + d + " " + arr[x][y]);
		if(arr[x][y] != 1) clean(x, y, d, cnt);
		
		System.out.println(cnt);
		System.exit(0);
		
	}

}
