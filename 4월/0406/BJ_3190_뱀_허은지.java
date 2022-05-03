package 구현;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 보드의 크기 N
 * 2. 사과의 개수 K
 * 3. 사과의 위치 x, y
 * 4. 뱀의 방향 변환 횟수 L
 * 5. 방향 변환 정보 X초가 끝난 뒤에 L왼쪽 D오른쪽으로 회전
 * 출력
 * 1. 게임이 몇 초에 끝나는지 출력
 * 조건
 * 1. 사과가 있으면 뱀의 길이가 늘어난다
 * 2. 사과가 없으면 뱀은 다시 줄어든다
 */
public class g5_3190_뱀 {
	static int N, arr[][];
	static char[] ro;
	static Queue<int[]> snake = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N+1][N+1];
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x][y] = 1;
		}

		int L = Integer.parseInt(br.readLine());
		
		ro = new char[10001];
		
		for(int i = 0; i<L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);
			
			ro[X+1] = C;
		}
		
		go(1, 1, 0, 1);
		
	}

	private static void go(int i, int j, int dir, int cnt) {
		// 동남서북
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		snake.add(new int[] {i, j});
		arr[i][j] = 2;
		
		if(ro[cnt] == 'L') dir = (dir+3)%4;
		else if(ro[cnt] == 'D') dir = (dir+1)%4;
		
		int x = i+dx[dir];
		int y = j+dy[dir];
		
		if(x<=0 || x>N || y<=0 || y>N || arr[x][y]==2) {
			System.out.println(cnt);
			System.exit(0);
		}
		
		if(arr[x][y] == 1) {
			arr[x][y] = 2;
			go(x, y, dir, cnt+1);
		}
		else {
			int[] s = snake.poll();
			arr[s[0]][s[1]] = 0;
			go(x, y, dir, cnt+1);
		}

	}

}
