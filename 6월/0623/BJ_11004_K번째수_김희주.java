import java.io.*;
import java.util.*;

public class BOJ_11004_K번째수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> A = new ArrayList<>(N);
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) A.add(Integer.parseInt(st.nextToken()));
		Collections.sort(A);
		System.out.println(A.get(K-1));
	}
}
