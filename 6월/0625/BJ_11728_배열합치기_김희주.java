import java.io.*;
import java.util.*;

public class BOJ_11728_배열합치기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] array = new int[N+M];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) array[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<M;i++) array[i+N] = Integer.parseInt(st.nextToken());
		Arrays.sort(array);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<array.length;i++) sb.append(array[i]).append(' ');
		System.out.println(sb);
	}
}

