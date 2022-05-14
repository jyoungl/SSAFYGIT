import java.io.*;
import java.util.*;

public class BJ_5427_불 {
	static int time; // 탈출 시 걸리는 시간
	static boolean flag;
	static int C, R;
//	static String[][];
	static char[][] map;

	static Queue<Pos> fq;
	static Queue<Pos> hq;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		//Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			//in.nextLine();

//			map = new String[R][C];
//			for (int i = 0; i < R; i++) {
//				map[i] = in.nextLine().split("");
//			}
			// 아래 초기화 안하면 오류난다
			map = new char[R][C]; 	
			fq = new LinkedList<>();
			hq = new LinkedList<>();
			flag = false;
			time = 0;
			
			for (int i = 0; i < R; i++) {
				String s = br.readLine();
//				System.out.println(s);
				for (int j = 0; j < C; j++) {
					map[i][j] = s.charAt(j);
					if (map[i][j] == '*') { // 불
						fq.add(new Pos(i, j));
					}
					if (map[i][j] == '@') { // 상근
						hq.add(new Pos(i, j));
					}
				}
			}
			bfs();

//			System.out.println("IMPOSSIBLE");
			// 배열범위 탈출하면 time에 +1 못하므로 출력문에서 처리
			System.out.println(flag == true ? (time+1) : "IMPOSSIBLE");
		}

	}

	private static void bfs() {
		while (!fq.isEmpty() || !hq.isEmpty()) {
			
			// 불 관련
			for (int k = 0; k < fq.size(); k++) {
				Pos firePoint = fq.poll();
				
				for (int i = 0; i < 4; i++) { 
					int nr = firePoint.r + dr[i];
					int nc = firePoint.c + dc[i];
					
					// 배열 범위 벗어나면 continue
					if (nr < 0 || nr >= R || nc < 0 || nc >= C)
						continue;
					
					// 1초 뒤 만나는게 빈공간이거나 곧 떠날 상근이 위치라면
					if (map[nr][nc] == '.' | map[nr][nc] == '@') {
						map[nr][nc] = '*';
						fq.add(new Pos(nr, nc));
					}
				}
			} // end 불 관련
			
			// 상근이 관련
			for (int k = 0; k < hq.size(); k++) {
				Pos humanPoint = hq.poll();

				for (int i = 0; i < 4; i++) {
					int nr = humanPoint.r + dr[i];
					int nc = humanPoint.c + dc[i];
					
					// 배열 범위 벗어나면 탈출 완료
					if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
						//System.out.println(time);
						flag=true;
						return;
					}

					// 1초 뒤 만나는게 빈공간이라면
					if (map[nr][nc] == '.') {
						map[nr][nc] = '@';
						hq.add(new Pos(nr, nc));
					}
				}
			} // end 상근이 관련
			time++;
			
		} // end while
	} // end bfs

	static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}
}
