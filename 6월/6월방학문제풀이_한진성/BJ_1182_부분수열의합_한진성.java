import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합 {
	static int[] nums;
	static int numbers[];
	static int N, R,S, ans;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			R = i;
			numbers = new int[R];
			comb(0, 0);

		}
		System.out.println(ans);
	}

	public static void comb(int start, int cnt) {

		// 기저조건
		if (cnt == R) {
			int sum = 0;
			for(int i=0;i<R;i++) {
				sum += nums[numbers[i]];
			}
			
			if(sum == S) {
				ans++;
			}
			
			return;
		}

		for (int i = start; i < N; i++) {
			numbers[cnt] = i;
			comb(i + 1, cnt + 1);
		}

	}

}
