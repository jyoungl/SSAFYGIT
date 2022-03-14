package A형기출문제;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 집의 크기 N
 * 2. 집의 상태(빈칸 0, 벽 1)
 * 		(1,1)과 (1,2)는 항상 빈칸
 * 출력
 * 1. 파이프의 한쪽 끝을 N,N으로 이동시키는 방법의 수
 * 2. 이동시킬 수 없을 때는 0 출력
 * 조건
 * 1. 방법의 수는 항상 1,000,000보다 작거나 같다
 * 2. 파이프가 대각선일 때는 네 칸 차지
 * 3. 처음 파이프는 1,1과 1,2 차지
 * 
 * >> -1 만나면 패스
 * >> 배열에서 하나씩 값 더하기
 */
public class g5_17070_허은지 {
	static int N, count;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][N+1];
		
		for(int i = 1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(arr[1][3] == 1 || arr[N][N] == 1) {
			System.out.println(0);
			System.exit(0);
		}
		
		pipe(1, 2, 1);
		
		System.out.println(count);

	}

	private static void pipe(int i, int j, int dir) {
		if(i==N && j==N) {
			count++;
			return;
		}
		
		if(dir==1) { //파이프가 가로로 놓여 있을 때
			if(i<=N && j+1<=N && arr[i][j+1] == 0) { //가로로 갈 때
				pipe(i, j+1, 1);
			}
			if(i+1<=N && j+1<=N && arr[i+1][j+1] == 0 && arr[i+1][j] == 0 && arr[i][j+1] == 0) { // 대각선으로 갈 때
				pipe(i+1, j+1, 3);
			}
		} else if(dir==2) {//파이프가 세로로 놓여 있을 때
			if(i+1<=N && j<=N && arr[i+1][j] == 0) { //세로로 갈 때
				pipe(i+1, j, 2);
			}
			if(i+1<=N && j+1<=N && arr[i+1][j+1] == 0 && arr[i+1][j] == 0 && arr[i][j+1] == 0) { // 대각선으로 갈 때
				pipe(i+1, j+1, 3);
			}
		} else if(dir==3) { //파이프가 대각선으로 놓여 있을 때
			if(i<=N && j+1<=N && arr[i][j+1] == 0) { // 가로로 갈 때
				pipe(i, j+1, 1);
			}
			if(i+1<=N && j<=N && arr[i+1][j] == 0) { // 세로로 갈 때
				pipe(i+1, j, 2);
			}
			if(i+1<=N && j+1<=N && arr[i+1][j+1] == 0 && arr[i+1][j] == 0 && arr[i][j+1] == 0) { // 대각선으로 갈 때
				pipe(i+1, j+1, 3);
			}
		}
		
	}

}
