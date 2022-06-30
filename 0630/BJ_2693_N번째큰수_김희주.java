import java.io.*;
import java.util.*;

public class BOJ_2693_N번째큰수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[] A = new int[10];
		for(int tc=0;tc<T;tc++){
			st = new StringTokenizer(in.readLine());
			for(int i=0;i<10;i++)A[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(A);
			sb.append(A[7]).append('\n');
		}
		System.out.print(sb);
	}
}
