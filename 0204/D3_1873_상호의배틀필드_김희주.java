import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1873_상호의배틀필드 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		char[] wayCh = { '^', 'v', '<', '>' };
		int[][] wayDelta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			//입력
			StringTokenizer st = new StringTokenizer(in.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			char[][] map = new char[H][W];
			int[] tank = new int[3]; // 0: 방향, 1: 높이idx, 2: 너비idx
										// 0:위 1:아래 2:오른쪽 3:왼쪽

			for (int i = 0; i < H; i++) {
				String line = in.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j);

					// 전차 위치, 방향 저장
					for (int k = 0; k < 4; k++) {
						if (map[i][j] == wayCh[k]) {
							tank[0] = k;
							tank[1] = i;
							tank[2] = j;
						}
					}
				}
			}

			//명령수행
			int N = Integer.parseInt(in.readLine());
			String command = in.readLine();
			for(int n=0;n<N;n++) {
				int ti = tank[1];
				int tj = tank[2];

				char order = command.charAt(n);

				if (order == 'S') {
					while (true) {
						int ni = ti + wayDelta[tank[0]][0];
						int nj = tj + wayDelta[tank[0]][1];

						if (ni < 0 || ni >= H || nj < 0 || nj >= W || map[ni][nj] == '#') break;
						else if (map[ni][nj] == '*') {
							map[ni][nj] = '.';
							break;
						}
						
						ti = ni;
						tj = nj;
					}
					
					continue;
				}

				if (order == 'U')		tank[0] = 0;
				else if (order == 'D')	tank[0] = 1;
				else if (order == 'L')	tank[0] = 2;
				else if (order == 'R')	tank[0] = 3;

				int ni = ti + wayDelta[tank[0]][0];
				int nj = tj + wayDelta[tank[0]][1];

				if (ni >= 0 && ni < H && nj >= 0 && nj < W && map[ni][nj] == '.') {
					map[ti][tj] = '.';
					map[ni][nj] = wayCh[tank[0]];
					tank[1] = ni;
					tank[2] = nj;
				}else {
					map[ti][tj] = wayCh[tank[0]];
				}
				
			}
			
			//출력
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}

}
