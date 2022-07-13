import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1449_수리공항승 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());

		int L = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {

			arr[i] = Integer.parseInt(st.nextToken());

		}

		Arrays.sort(arr);
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int temp = 1;
			if (i + temp < N) {
				while (arr[i + temp] - arr[i] < L) {
					arr[i + temp] = 0;
					temp++;
					if (i + temp >= N) {
						break;
					}
				}
			}
			arr[i] = 0;
			i = i + temp-1;
//			System.out.println(Arrays.toString(arr));
			cnt++;
		}
		System.out.println(cnt);

	}

}
