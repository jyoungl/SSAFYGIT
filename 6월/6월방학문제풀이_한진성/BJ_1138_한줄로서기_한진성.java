import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1138_한줄로서기 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		StringTokenizer st = new StringTokenizer(in.readLine());

		int[] arr = new int[N];

		int[] ans = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int j = 0;
		for (int i = N; i > 0; i--) {
			int cnt = arr[i - 1];

			if (cnt == j) {
				ans[j] = i;
			} else {
				for (int k = j; k > cnt; k--) {
					ans[k] = ans[k - 1];
				}
				ans[cnt] = i;
			}
			j++;
		}

		for (int i = 0; i < N; i++) {
			System.out.print(ans[i] + " ");
		}
	}

}
