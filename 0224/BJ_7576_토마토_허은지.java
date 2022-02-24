package lv24_DFS와BFS;

import java.util.*;
import java.io.*;

public class g5_7576_토마토2 {
	
	static class Tomato {
		public int x1, y1, count;
		public Tomato(int x1, int y1, int count) {
			this.x1 = x1;
			this.y1 = y1;
			this.count = count;
		}
	}
	
	static int M, N, zero;
	static int[][] box;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<Tomato> queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N][M];
		
		zero = 0;
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				//안 익은 토마토 개수 세기
				if(box[i][j]==0) zero++;
				//익은 토마토의 위치를 큐에 넣기
				else if(box[i][j]==1) queue.add(new Tomato(i,j,0));
			}
		}
		
		//안 익은 토마토가 없으면 0 출력 후 종료
		if(zero == 0) {
			System.out.println(0);
			System.exit(0);
		}

		bfs();

	}

	private static void bfs() {
		int count = 0;
		
		while(!queue.isEmpty()) {
			Tomato t = queue.poll();
			count = t.count;
			
			//4방 탐색
			for(int k = 0; k < 4; k++) {
				int x = t.x1 + dx[k];
				int y = t.y1 + dy[k];
				
				//범위 벗어나면 continue
				if(x<0 || x>=N || y<0 || y>=M) continue;
				
				//토마토가 익지 않았을 때
				if(box[x][y]==0) {
					//토마토를 익힌다
					box[x][y] = 1;
					//익은 토마토를 큐에 넣음(날짜 하루 추가)
					queue.add(new Tomato(x,y,count+1));
					//안 익은 토마토의 개수 줄이기
					zero--;
				}
			}
		}
		
		//안 익은 토마토가 0개가 아닐 때 -1 출력
		if(zero!=0) System.out.println(-1);
		//안 익은 토마토가 0개일 때 날짜 출력
		else System.out.println(count);
	}
}
