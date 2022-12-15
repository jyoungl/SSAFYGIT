import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111_마인크래프트 {
	static int N, M, B;
	static int[][] map;

	static int TIME = Integer.MAX_VALUE, LEVEL;

	public static void main(String[] args) throws IOException {
		//세로 N 가로 M 맨 위 좌표(0,0) 인벤토리 B개블록
		//1. 2초 : 좌표 (i,j) 가장 윗 블록 제거 후 인벤토리에 넣기 <-1>
		//2. 1초 : 인벤토리에서 블록 하나 꺼내서 (i,j)의 가장 위에 있는 블록 위에 넣기 <+1>
		//땅고르기 작업 최소시간 & 땅의 높이 출력
		//0<= 땅 높이 <=256
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		//변수
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int max = 0;
		int min = Integer.MAX_VALUE;

		//입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max,map[i][j]);
				min = Math.min(min,map[i][j]);
			}
		}

		//반복 : max -> min까지
		int level = max;
		while (level >= min) {
			checkMap(level--);
		}

		System.out.println(TIME + " "+LEVEL);
	}

	private static void checkMap(int level) {
		int calc = B;
		int time = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int diff = Math.abs(map[i][j]-level);
				if (map[i][j] > level) {
					time += 2*diff;
					calc += diff;
				} else {
					time += diff;
					calc -= diff;
				}
			}
		}

		if (calc >= 0) {
			if(time < TIME) {
				TIME = time;
				LEVEL = level;
			}
			else if (time == TIME) {
				LEVEL = Math.max(level, LEVEL);
			}
		}

	}
}
