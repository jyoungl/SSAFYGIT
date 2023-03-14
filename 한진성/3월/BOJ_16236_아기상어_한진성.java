import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16236_아기상어_한진성 {

	static int N, arr[][];
	static Shark shark;
	static PriorityQueue<Fish> fishList;
	static int[][] dir = new int[][] { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					shark = new Shark(i, j, 0, 2);
				}
			}
		}
		int time = 0;
		// 1. 찾는다.
		while (true) {
			int findFlag = findFish();

			if (findFlag == -1) {
				System.out.println(time);
				return;
			} else {
				time += findFlag;
			}
		}
	}

	// 먹는다.
	// 이동한다.
	// 엄마를 부른다.

	static class Shark {

		int x;
		int y;
		int size = 2;
		int eatCnt = 0;
		int depth = 0;

		public Shark(int x, int y, int depth, int size) {
			super();
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.size = size;
		}

	}

	static class Fish implements Comparable<Fish> {
		int x;
		int y;
		int depth;

		public Fish() {
		}

		public Fish(int x, int y, int depth) {
			super();
			this.x = x;
			this.y = y;
			this.depth = depth;
		}

		@Override
		public int compareTo(Fish o) {
			if (this.depth == o.depth) {
				if (this.x == o.x) {
					return this.y - o.y;
				} else {
					return this.x - o.x;
				}
			} else {
				return this.depth - o.depth;
			}
		}

	}

	static void move(int x, int y) {
		arr[shark.x][shark.y] = 0;
		shark.x = x;
		shark.y = y;
		arr[x][y] = 9;

	}

	static void eat() {
		shark.eatCnt++;
		if (shark.size == shark.eatCnt) {
			shark.size++;
			shark.eatCnt = 0;
		}
	}

	static int findFish() {
		boolean[][] visited = new boolean[N][N];
		fishList = new PriorityQueue<>();
		// bfs
		Queue<Shark> queue = new LinkedList<>();

		queue.offer(shark);
		visited[shark.x][shark.y] = true;

		while (!queue.isEmpty()) {

			Shark current = queue.poll();

			for (int d = 0; d < 4; d++) {

				int dx = current.x + dir[d][0];
				int dy = current.y + dir[d][1];

				if (dx < 0 || dx >= N || dy < 0 || dy >= N) {
					continue;
				}

				if (arr[dx][dy] > current.size) {
					continue;
				}


				if (!visited[dx][dy]) {
					visited[dx][dy] = true;
					queue.offer(new Shark(dx, dy, current.depth + 1, shark.size));
					if (arr[dx][dy] != 0 && arr[dx][dy] < current.size) {
						fishList.add(new Fish(dx, dy, current.depth));
					}
				}
			}

		}
		if(fishList.size() == 0) {
			return -1;
		}
		Fish fish = fishList.poll();
		move(fish.x, fish.y);
		eat();
		shark.depth = 0;
		return fish.depth+1;
	}

}
