import java.io.*;
import java.util.*;

public class BOJ_1026_보물 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		int[] A = new int[N];
		int[] B = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		Arrays.sort(B);

		int S = 0;
		for (int i = 0; i < N; i++) {
			S += B[i] * A[N - 1 - i];
		}

		System.out.println(S);
	}
}
