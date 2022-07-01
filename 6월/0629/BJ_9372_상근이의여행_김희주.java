import java.io.*;
import java.util.*;

public class BOJ_9372_상근이의여행 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		int N,M;
		StringTokenizer st;
		while(T-->0){
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			for(int i=0;i<M;i++) in.readLine();
			sb.append(N-1).append('\n');
		}

		System.out.print(sb);
	}
}
