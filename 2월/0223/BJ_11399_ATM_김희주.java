import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] time = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) time[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(time);

		int sum = 0;
		//첫번째방법
//		int[] wait = new int[N+1];
//		for (int i = 1; i <= N; i++) {
//			wait[i] = wait[i-1]+time[i-1];
//			sum += wait[i];
//		}

		//두번째방법
		for(int i=0;i<N;i++){
			sum += time[i]*(N-i);
		}

		System.out.println(sum);
	}
}
