import java.io.*;
import java.util.*;

public class BOJ_1269_대칭차집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> set = new HashSet<>();

		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++){
			set.add(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<M;i++){
			set.add(st.nextToken());
		}
		System.out.println(2*set.size()-N-M);
	}
}
