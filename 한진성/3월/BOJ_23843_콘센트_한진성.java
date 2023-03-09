import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_23843_콘센트_한진성 {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int[] concent = new int[M];
		for (int i = 0; i < N; i++) {
			int minIndex = 9999;
			int minValue = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				if (minValue > concent[j]) {
					minIndex = j;
					minValue = concent[j];
				}
			}

			concent[minIndex] += arr[N - 1 - i];

		}
		int maxValue = Integer.MIN_VALUE;
		boolean check = false;
		for (int i = 0; i < M; i++) {
			maxValue = Math.max(maxValue, concent[i]);
			if (concent[i] == 0) {
				check = true;
			}
		}
		if (check) {
			System.out.println(arr[N - 1]);
			return;
		}
		System.out.println(maxValue);
	}

}
