import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {

	public static class Cleaner {
		int x;
		int y;
		int direction;

		public Cleaner(int x, int y, int direction) {
			super();
			this.x = x;
			this.y = y;
			this.direction = direction;
		}

	}

	static int N, M, ans, arr[][];

	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		// 0 = 위, 1 = 오른, 2 = 아래, 3 = 왼
		st = new StringTokenizer(in.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int direction = Integer.parseInt(st.nextToken());

		Cleaner cleaner = new Cleaner(x, y, direction);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		move(cleaner);

		System.out.println(ans);

	}

	/*
	 * 현재 위치에서 왼쪽에 아직 청소하지 않은 빈 공간이 있다면 회전 후 전진 청소하지 않은 빈 공간이 없다면 회전만 함 회전을 4번하고 나면
	 * 뒤로 1칸 후진, 뒤가 벽이라면 종료
	 */
	public static void move(Cleaner cleaner) {
		boolean[][] visited = new boolean[N][M];
		// 초기위치 설정 및 청소
		visited[cleaner.x][cleaner.y] = true;
		ans++;
		// 회전 횟수를 체크할 변수
		int cnt = 0;
		while (true) {
			// 0일경우 3으로, 0이 아닐경우 -1시켜준다. : 로봇청소기 회전
			cleaner.direction = cleaner.direction == 0 ? cleaner.direction = 3 : cleaner.direction - 1;
			int vec = cleaner.direction;
			int dx = cleaner.x + dir[vec][0];
			int dy = cleaner.y + dir[vec][1];

			// 카운트가 4일 경우 뒤로 한 칸 이동
			if (cnt == 4) {
				// 처음 회전시킨 부분 원래 회전으로 한 번 돌리기
				cleaner.direction = cleaner.direction == 3 ? cleaner.direction = 0 : cleaner.direction + 1;
				vec = cleaner.direction;
				// 후진 위치
				dx = cleaner.x - dir[vec][0];
				dy = cleaner.y - dir[vec][1];

				// 만약 뒤가 벽이라면 종료
				if (arr[dx][dy] == 1) {
					return;
				}

				// 뒤가 벽이 아니라면 1칸 후진
				cleaner.x = dx;
				cleaner.y = dy;
				cnt = 0;
				continue;
			}

			// 이동 못하는 경우 컨티뉴, 카운트 1 증가
			if (arr[dx][dy] == 1 || visited[dx][dy] == true) {
				cnt++;
				continue;
			}

			// 이동할 수 있는 경우
			cleaner.x = dx;
			cleaner.y = dy;
			visited[dx][dy] = true;
			cnt = 0;
			ans++;
		}

	}

}
