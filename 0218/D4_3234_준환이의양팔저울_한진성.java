import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_3234_준환이의양팔저울 {
	static int N;
	static int arr[];
	static int[] numbers;
	static int ans;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input_3234.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {

			// 추의 개수
			N = Integer.parseInt(in.readLine());

			// 추의 배열 생성
			arr = new int[N];
			numbers = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			// 추 배열 할당
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			ans = 0;

			perm(0, 0);

			System.out.printf("#%d %d\n", tc, ans);

		}

	}

	public static void perm(int cnt, int flag) {

		// 기저조건
		if (cnt == N) {
			isSelected = new boolean[N];
			subSet(0, 0, 0);
			return;
		}

		// 유도파트
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0) {
				continue;
			}

			numbers[cnt] = arr[i];

			perm(cnt + 1, flag | 1 << i);

		}

	}
	// 일반적인 부분집합만 생각했는데, 순서가 있다는 것을 체크를 하지 못해 많이 헤맸다. 따라서 순열을 먼저 구한 후, 구한 순열에 대해 부분집합의 개수를 구하면 되는 문제였다.
	// 물론 부분집합의 개수를 구하는데, 주어진 조건 왼쪽 >= 오른쪽의 조건이 맞아야 하기 때문에 그것의 반대되는 부분집합의 경우 return을 시켜줘야한다.
	public static void subSet(int cnt, int left, int right) {

		// 가지치기 : 왼쪽보다 오른쪽의 값이 크면 리턴한다.
		if (left < right) {
			return;
		}
		// 기저조건 : cnt가 N에 도달하면 멈춘다
		if (cnt == N) {
			ans++;
			return;
		}

		// 왼쪽에 올리기
		isSelected[cnt] = true;
		subSet(cnt + 1, left+ numbers[cnt] , right);

		// 오른쪽에 올리기
		isSelected[cnt] = false;
		subSet(cnt + 1, left, right + numbers[cnt]);
		// 체크해봤는데, 재귀를 일단 실행 후 비교하는 방법으로 구현했기 때문에 그런지, 어느쪽을 먼저 올려도 통과가 되었다.
		// 다만 시간은 왼쪽을 먼저 올리는 쪽이 미세하게 더 빨랐다.
		
//		// 오른쪽에 올리기
//		isSelected[cnt] = true;
//		subSet(cnt + 1, left , right+ numbers[cnt]);
//
//		// 왼쪽에 올리기
//		isSelected[cnt] = false;
//		subSet(cnt + 1, left+ numbers[cnt], right );
	}

}
