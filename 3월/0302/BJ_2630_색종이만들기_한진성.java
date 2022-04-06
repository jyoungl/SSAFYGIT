import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_색종이만들기 {
	static int[][] arr;
	static int zero, one;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cut(0, 0, N);
		System.out.println(zero);
		System.out.println(one);

	}

	public static void cut(int x, int y, int N) {
		int cnt = 0;
		
		// 해당 범위가 모두 같은 값을 가지는 지 체크
		for (int i = x; i < x + N; i++) {
			for (int j = y; j < y + N; j++) {
			// 배열을 탐색하며 모두 더한다.(각각의 시작 좌표 x,y에서 x+N, y+N까지)
				cnt += arr[i][j];
			}
		}
		
		// 모두 더한 수가 N*N이라면 해당 범위가 모두 1이다.
		if (cnt == N * N) {
			one++;
		// 모두 더한 수가 0이라면 해당 범위에는 모두 0이 들어가있다.
		} else if (cnt == 0) {
			zero++;
		// 둘다 아닌경우 0과 1이 섞여있으므로 4분할하여 재귀해준다.
		} else {
			int half = N / 2;
			cut(x, y, half);
			cut(x + half, y, half);
			cut(x, y + half, half);
			cut(x + half, y + half, half);
		}

	}

}
