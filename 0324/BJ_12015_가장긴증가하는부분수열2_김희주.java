import java.io.*;
import java.util.*;

public class BOJ_12015_가장긴증가하는부분수열2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		ArrayList<Integer> A = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(in.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			int idx = -Collections.binarySearch(A, num) - 1;
			if (idx == A.size()) A.add(num);
			else if (idx >= 0) A.set(idx, num);
		}

		System.out.println(A.size());
	}
}
