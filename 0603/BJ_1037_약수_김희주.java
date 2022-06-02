import java.io.*;
import java.util.*;

public class BOJ_1037_약수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] input = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) input[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(input);

		System.out.println(input[0]*input[N-1]);
	}
}
