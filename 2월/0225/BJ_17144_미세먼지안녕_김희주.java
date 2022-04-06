import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_17144_미세먼지안녕 {
	static int R, C, T;                //크기,시간
	static int[][] house;        //집
	static int cleanU, cleanD;    //공기청정기 행 저장
	static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};    //시계방향

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		house = new int[R][C];

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(in.readLine());
			for (int c = 0; c < C; c++) {
				house[r][c] = Integer.parseInt(st.nextToken());
				if (house[r][c] == -1) cleanD = r;
			}
		}
		cleanU = cleanD - 1;

		int count = 0;
		while (--T >= 0) count = spreadDust() - blowWind(true) - blowWind(false);
		System.out.println(count);

	}

	private static int spreadDust() {
		//현재 존재하는 먼지 양 반환
		int count = 0;
		int[][] next = new int[R][C];

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (house[r][c] < 1) continue;

				int dust = house[r][c];
				int divide = dust / 5;

				for (int d = 0; d < 4; d++) {
					int nr = r + deltas[d][0];
					int nc = c + deltas[d][1];
					if (valid(nr, nc)) {
						next[nr][nc] += divide;
						dust -= divide;
						count += divide;
					}
				}

				next[r][c] += dust;
				count += dust;	//이 부분 실수
			}
		}

		house = next;    //새 집에 공기청정기 위치 저장안하는거 알고있을것
		return count;
	}

	private static int blowWind(boolean up) {
		//없어진 먼지 양 반환
		int[] wind = up ? new int[]{cleanU, 1} : new int[]{cleanD, 1};
		int[][] delta = up ? new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}} : deltas;
		int save = house[wind[0]][wind[1]];	//이 부분 실수
		house[wind[0]][wind[1]] = 0;		//이 부분 실수

		int d = 0;
		while (d < 4) {
			int nr = wind[0] + delta[d][0];
			int nc = wind[1] + delta[d][1];

			if (!valid(nr, nc)) {
				++d;
				continue;
			}

			int tmp = house[nr][nc];
			house[nr][nc] = save;
			save = tmp;

 			wind = new int[]{nr,nc};	//이 부분 실수
		}

		return save;
	}

	private static boolean valid(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C && !(r == cleanU && c == 0) && !(r == cleanD && c == 0);	//이 부분 실수(공기청정기체크 필요)
	}

}
