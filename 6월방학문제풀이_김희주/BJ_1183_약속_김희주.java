import java.io.*;
import java.util.*;

public class BOJ_1183_약속 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] input = new int[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			input[i] = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);

		if(N%2==1) System.out.println(1);
		else System.out.println(Math.abs(input[N/2]-input[N/2-1])+1);
	}
}
