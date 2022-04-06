import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	static int R, C;
	static int[][] arr;

	// 상하좌우
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	// 방문정보를 확인할 알파벳 개수만큼의 배열
	static boolean check[] = new boolean[26];

	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 버퍼드리더로 값 읽어오기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// N = 배열 크기 읽어오기
		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());

		C = Integer.parseInt(st.nextToken());

		arr = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str = in.readLine();
			for (int j = 0; j < C; j++) {
				// 'A'를 빼주어 알파벳을 숫자로 만든다. 이래야 배열로 넘버링이 가능
				arr[i][j] = str.charAt(j) - 'A';
			}
		}
		
		dfs(0, 0, 0);

		System.out.println(max);

	}

	public static void dfs(int x, int y, int cnt) {

		if (check[arr[x][y]]) {
			max = Math.max(max, cnt);
			return;
		}

		check[arr[x][y]] = true;
		// 유도파트
		for (int i = 0; i < 4; i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];

			// 값이 범위를 벗어나지 않는다면
			if (dx >= 0 && dx < R && dy >= 0 && dy < C) {
				dfs(dx, dy, cnt + 1);
			}
		}

		check[arr[x][y]] = false;
		
	}

}
