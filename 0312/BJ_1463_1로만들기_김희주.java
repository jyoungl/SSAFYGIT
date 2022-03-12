import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463_1로만들기 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

		int[] counts = new int[N + 1];

		for (int i = 2; i <= N; i++) {
			counts[i] = counts[i - 1];
			if (i % 3 == 0) counts[i] = Math.min(counts[i / 3], counts[i]);
			if (i % 2 == 0) counts[i] = Math.min(counts[i / 2], counts[i]);
			++counts[i];
		}

		System.out.println(counts[N]);
	}
}
