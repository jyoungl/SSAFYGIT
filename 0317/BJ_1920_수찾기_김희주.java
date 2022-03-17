import java.io.*;
import java.util.*;

public class BOJ_1920_수찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		int[] A = new int[N];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A);

		in.readLine();//M 필요없음
		st = new StringTokenizer(in.readLine());

		int num;
		while(st.hasMoreTokens()) {
			num = Integer.parseInt(st.nextToken());
			int left = 0, right = N - 1;//, result = 0;
			boolean result = false;
			while (left <= right) {
				int half = (left+right)>>1;
				int halfVal = A[half];
				if (num > halfVal) left = half + 1;
				else if (num < halfVal) right = half - 1;
				else if (num == halfVal) {
					result = true;
					break;
				}
			}
			if(result) sb.append("1\n");
			else sb.append("0\n");
		}

		System.out.print(sb);
	}
}
