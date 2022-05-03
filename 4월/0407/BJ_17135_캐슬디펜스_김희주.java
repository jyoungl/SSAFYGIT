import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬디펜스 {
	static int N, M, D, MAX = 0;
	static int[][] map;
	static int[] pick = new int[3];
	static ArrayList<int[]> enemy = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());//행
		M = Integer.parseInt(st.nextToken());//열
		D = Integer.parseInt(st.nextToken());//공격거리제한
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		find(0, 0);
		System.out.println(MAX);
	}

	private static void find(int start, int cnt) {
		if (cnt == 3) {
			int[][] next = copy(map);
			MAX = Math.max(MAX, go(0));
			map = copy(next);
			return;
		}

		for (int i = start + 1; i <= M; i++) {
			pick[cnt] = i - 1;
			find(i, cnt + 1);
		}
	}

	private static int go(int cnt) {
		//적 찾기
		findEnemy();

		//제거할 적이 없다면 끝내기
		if (enemy.size() == 0) return cnt;

		//적중에 가까운 적 고르기
		int[][] pos = new int[3][2];
		for (int i = 0; i < 3; i++) {
			int idx = i;
			Collections.sort(enemy, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					int diff = getDistance(o1, pick[idx]) - getDistance(o2, pick[idx]);
					if (diff != 0) return diff;
					else return o1[1] - o2[1];
				}
			});
			pos[i] = enemy.get(0);
			if(getDistance(pos[i],pick[idx])>D) pos[i] = null;

		}

		//한꺼번에 제거
		int tmp = 0;
		for (int[] p : pos) {
			if(p==null) continue;
			if (map[p[0]][p[1]] == 0) continue;
			map[p[0]][p[1]] = 0;
			tmp++;
		}

		//적 이동
		move();

		//재귀
		return go(cnt + tmp);
	}

	private static void move() {
		for (int i = N-1; i > 0; i--) {
			for (int j = 0; j < M; j++) {
				map[i][j] = map[i - 1][j];
			}
		}
		map[0] = new int[M];
	}


	private static int[][] copy(int[][] origin) {
		int[][] next = new int[N][M];
		for (int i = 0; i < N; i++) {
			next[i] = origin[i].clone();
		}
		return next;
	}

	private static int getDistance(int[] a, int m) {
		return Math.abs(a[0] - N) + Math.abs(a[1] - m);
	}

	private static void findEnemy() {
		enemy.clear();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) continue;
				enemy.add(new int[]{i, j});
			}
		}
	}
}
