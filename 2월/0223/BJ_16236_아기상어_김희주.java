import java.io.*;
import java.util.*;

public class BOJ_16236_아기상어 {
	static int N, time;
	static int[][] sea;
	static int[][] deltas = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};//위-왼쪽-오른쪽-아래
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		sea = new int[N][N];
		Fish shark = null;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
				if (sea[i][j] == 9) {
					//상어값만 따로 저장해줌. 나중에 지나갈 수 있도록 0 저장
					shark = new Fish(0, i, j, 2,0);
					sea[i][j] = 0;
				}
			}
		}

		bfs(shark);

		System.out.println(time);
	}

	static void bfs(Fish shark){
		Queue<Fish> queue = new LinkedList<>();
		queue.offer(shark);

		boolean[][] visited = new boolean[N][N];
		visited[shark.y][shark.x] = true;

		PriorityQueue<Fish> pQueue = new PriorityQueue<>();

		while(!queue.isEmpty()){
			shark = queue.poll();

			for(int d=0;d<4;d++){
				int ny = shark.y+deltas[d][0];
				int nx = shark.x + deltas[d][1];
				if(checkRange(ny,nx) && !visited[ny][nx]){
					//ny,nx가 범위 안에 있고 방문한 적 없을 때만 체크
					visited[ny][nx] = true;
					if(!pQueue.isEmpty() && pQueue.peek().d<shark.d+1) {
						//거리가 가까운 순으로 먹어야 하니까
						//현재 상어+1(지금 먹이의 거리로 저장될 값)이 이미 저장된 먹이의 거리보다 크다면 필요없음
						d = 4; queue.clear(); //아예 상어 자리 찾기 그만둠
						break;
					}
					else if(sea[ny][nx]!=0 && shark.size>sea[ny][nx]){
						//0이 아니고(물고기가 있고) 상어 크기가 현재 물고기보다 클 때만 먹을 수 있음
						pQueue.offer(new Fish(shark.d+1,ny,nx,sea[ny][nx]));
					}else if(sea[ny][nx]==0 || shark.size==sea[ny][nx]){
						//0이거나 상어 크기=현재 물고기 크기일때만 이동 가능
						queue.offer(new Fish(shark.d+1,ny,nx,shark.size,shark.eatCnt));
					}
				}
			}

		}

		//먹을 게 있다면 맨 앞을 먹고 bfs를 다시 호출(eat에서 상어값 다시 저장함)
		if(!pQueue.isEmpty()) {
			shark.eat(pQueue.poll());
			bfs(shark);
		}
	}

	static boolean checkRange(int y, int x){
		return y>=0 && y<N && x>=0 && x<N;
	}

	static class Fish implements Comparable<Fish> {
		int x,y; 	//위치
		int d;		//거리
		int size;	//크기
		int eatCnt;	//잡아먹은 횟수

		private Fish(int d, int y, int x, int size) {
			this.d = d;
			this.y = y;
			this.x = x;
			this.size = size;
		}

		private Fish(int d, int y, int x, int size, int eatCnt) {
			this(d,y,x,size);
			this.eatCnt = eatCnt;
		}

		private void eat(Fish f){
			this.d = 0;
			this.y = f.y;
			this.x = f.x;
			if(++this.eatCnt==this.size) {
				++this.size;
				this.eatCnt=0;
			}

			time += f.d;
			sea[f.y][f.x] = 0;
		}

		@Override
		public int compareTo(Fish f) {
			if (d != f.d) return d - f.d;
			else if (y != f.y) return y - f.y;
			return x - f.x;
		}
	}
}
