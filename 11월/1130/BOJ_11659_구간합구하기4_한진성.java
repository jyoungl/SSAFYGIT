import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기4 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(st.nextToken());

		int arr[] = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				arr[i] = Integer.parseInt(st.nextToken());
			} else {
				arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int o = Integer.parseInt(st.nextToken())-1;
			int p = Integer.parseInt(st.nextToken())-1;
			int sum = 0;
			if(o == 0) {
				sum = arr[p];
			}else {
				sum = arr[p] - arr[o-1];
			}
			System.out.println(sum);
		}

	}

}
