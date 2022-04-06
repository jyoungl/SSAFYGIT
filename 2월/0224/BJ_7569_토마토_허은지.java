package lv24_DFS와BFS;

import java.util.*;

import lv24_DFS와BFS.g5_7576_토마토2.Tomato;

import java.io.*;

/*
 * 입력
 * 1. 상자의 크기 가로 M 세로 N 높이 H
 * 2. M개의 줄이 H번 반복(1 익은 토마토 0 익지 않은 토마토 -1 토마토 없는 칸)
 * 출력
 * 1. 모두 익을 때까지 며칠이 걸리는지(모두 익어 있는 상태라면 0, 모두 익지 못하는 상황이면 -1)
 * 조건
 * 1. 위, 아래, 사방으로 익게 할 수 있음 대각선에는 영향을 주지 못함
 * 
 * >> dfs
 */
public class g5_7569_토마토 {	
		static class Tomato {
			public int x1, y1, z1, count;
			public Tomato(int x1, int y1, int z1, int count) {
				this.x1 = x1;
				this.y1 = y1;
				this.z1 = z1;
				this.count = count;
			}
		}
		
		static int M, N, H, zero;
		static int[][][] box;
		static Queue<Tomato> queue = new LinkedList<>();
		
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			box = new int[N][M][H];
			
			zero = 0;
			
			for(int k = 0; k<H; k++) {
				for(int i = 0; i<N; i++) {
					st = new StringTokenizer(br.readLine());
					for(int j = 0; j<M; j++) {
						box[i][j][k] = Integer.parseInt(st.nextToken());
						//안 익은 토마토 개수 세기
						if(box[i][j][k]==0) zero++;
						//익은 토마토의 위치를 큐에 넣기
						else if(box[i][j][k]==1) queue.add(new Tomato(i,j,k,0));
					}
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
		int[] dx = {-1, 1, 0, 0, 0, 0};
		int[] dy = {0, 0, -1, 1, 0, 0};
		int[] dz = {0, 0, 0, 0, 1, -1};
		int count = 0;
		
		while(!queue.isEmpty()) {
			Tomato t = queue.poll();
			count = t.count;
			
			//6방 탐색
			for(int k = 0; k < 6; k++) {
				int x = t.x1 + dx[k];
				int y = t.y1 + dy[k];
				int z = t.z1 + dz[k];
				
				//범위 벗어나면 continue
				if(x<0 || x>=N || y<0 || y>=M || z<0 || z>=H) continue;
				
				//토마토가 익지 않았을 때
				if(box[x][y][z]==0) {
					
					//토마토를 익힌다
					box[x][y][z] = 1;
					//익은 토마토를 큐에 넣음(날짜 하루 추가)
					queue.add(new Tomato(x,y,z,count+1));
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
