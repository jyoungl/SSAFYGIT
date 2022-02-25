import java.io.*;
import java.util.*;

public class BOJ_1697_숨바꼭질 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		System.out.println(find(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
	}

	private static int find(int n, int k) {
		int size = Math.max(k << 1, n) + 1;	//이부분
		int[] counts = new int[size];
		counts[n] = 1;

		Queue<Integer> queue = new LinkedList<>();	//이부분
		queue.offer(n);

		while (!queue.isEmpty()) {
			n = queue.poll();
			if (n == k) break;

			int[] next = {n + 1, n - 1, n * 2};
			for (int nn : next) {
				if (nn < 0 || nn >= size || counts[nn] > 0) continue;
				counts[nn] = counts[n] + 1;
				queue.offer(nn);
			}
		}

		return counts[k] - 1;
	}
}
