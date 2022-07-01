import java.io.*;
import java.util.*;

public class BOJ_1015_수열정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] input = new int[N];
		ArrayList<Integer> sorted = new ArrayList<>(N);
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			sorted.add(input[i]);
		}

		Collections.sort(sorted);

		StringBuilder sb = new StringBuilder();
		int idx;
		for (int i = 0; i < N; i++) {
			idx = sorted.indexOf(input[i]);
			sb.append(idx).append(' ');
			sorted.set(idx, -1);
		}

		System.out.print(sb);

	}
}
