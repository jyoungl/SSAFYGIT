import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16235_나무재테크 {

	static int N, M, K;
	static int[][] arr;
	static int[][] map;
	static int[][] dead;
	static PriorityQueue<Integer>[][] queues;

	static int dir[][] = { { 1, 0 }, { 1, 1 }, { 1, -1 }, { 0, 1 }, { 0, -1 }, { -1, 1 }, { -1, 0 }, { -1, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		// 농장크기
		N = Integer.parseInt(st.nextToken());
		// 나무개수
		M = Integer.parseInt(st.nextToken());
		// 년차
		K = Integer.parseInt(st.nextToken());

		// 양분 배열
		arr = new int[N][N];
		// 나무 배열
		queues = new PriorityQueue[N][N];
		// 땅 배열
		map = new int[N][N];
		// 죽은나무 배열
		dead = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				queues[i][j] = new PriorityQueue<>();
				map[i][j] = 5;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			queues[x-1][y-1].add(z);
		}
		// K년 만큼 반복
		for (int t = 0; t < K; t++) {
			// 봄
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 임시 큐
					PriorityQueue<Integer> temp = new PriorityQueue<>();
					while (!queues[i][j].isEmpty()) {
						// 나이: 어린순서
						int cur = queues[i][j].poll();
						// 나이가 양분보다 크면
						if (cur > map[i][j]) {
							// 나무 사망
							dead[i][j] += cur / 2;
							continue;
						} else {
							map[i][j] = map[i][j] - cur;
							// 나무 나이 1 증가시켜서 추가
							temp.add(cur + 1);
						}
					}
					// 임시큐 할당
					queues[i][j] = temp;
				}
			}
			
			// 여름
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = map[i][j] + dead[i][j];
					dead[i][j] = 0;
				}
			}
			// 가을 + 겨울
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 임시 큐
					PriorityQueue<Integer> temp = new PriorityQueue<>();
					while (!queues[i][j].isEmpty()) {
						int cur = queues[i][j].poll();
						temp.add(cur);
						if (cur % 5 == 0) {
							for(int d=0;d<8;d++) {
								int dx= i + dir[d][0];
								int dy = j + dir[d][1];
								if(dx < 0 || dx >= N || dy < 0 || dy >= N) {
									continue;
								}
								queues[dx][dy].add(1);
							}
						}
					}
					queues[i][j] = temp;
					map[i][j] += arr[i][j];
				}
			}
		}
		
		int answer = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				answer += queues[i][j].size();
			}
		}
		System.out.println(answer);
	}

}
