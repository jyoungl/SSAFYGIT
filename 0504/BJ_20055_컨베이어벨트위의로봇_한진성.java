import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트위의로봇 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(st.nextToken());

		int arr[][] = new int[2][N];
		boolean robot[] = new boolean[N];

		st = new StringTokenizer(in.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[0][i] = Integer.parseInt(st.nextToken());
		}
		for (int i = N - 1; i >= 0; i--) {
			arr[1][i] = Integer.parseInt(st.nextToken());
		}
		int answer =0;
		while (true) {
			answer++;
			// 1. 컨베이어벨트 회전
			rotate(arr,robot);

			// 2. 로봇 이동
			for (int i = N-2; i >=0; i--) {
				if (robot[i]) {
					// 로봇이 끝점이면 false
					if (i == N - 1) {
						robot[i] = false;
						continue;
					}
					// 로봇 앞이 막혀있지 않고 해당 칸의 내구도가 1이상이라면
					if (!robot[i + 1] && arr[0][i + 1] >= 1) {
						// 내구도 1 감소
						arr[0][i + 1]--;
						robot[i] = false;
						robot[i + 1] = true;
						// 이동한 위치가 끝점이면 내린다.
						if (i + 1 == N - 1) {
							robot[i + 1] = false;
						}
					}
					
				}
			}

			// 3. 로봇 올리기
			if (arr[0][0] >= 1) {
				arr[0][0]--;
				robot[0] = true;
			}
			int cnt = 0;
			// 4. K 체크
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 0) {
						cnt++;
					}
				}
			}

//			System.out.println(answer+"회");
//			for(int i=0;i<2;i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}

			
			if (cnt >= K) {
				break;
			}
		}
		System.out.println(answer);
	}

	public static void rotate(int[][] arr, boolean[] robot) {

		int temp = arr[1][0];

		for (int i = 1; i < N; i++) {
			arr[1][i - 1] = arr[1][i];
		}

		arr[1][N - 1] = arr[0][N - 1];

		for (int i = N - 1; i > 0; i--) {
			arr[0][i] = arr[0][i - 1];
		}
		
		// 로봇 옮기기
		for(int i=N-2;i>=0;i--) {
			 robot[i+1] = robot[i];
			 robot[i] = false;
			 if(i+1 == N-1) {
				 robot[i+1] = false;
			 }
		}
		
		arr[0][0] = temp;

	}

}
