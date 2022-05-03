import java.io.*;
import java.util.*;

public class BOJ_20040_사이클게임 {
	static int[] set;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		set = new int[N];
		for(int i=1;i<N;i++) set[i] = i;

		for(int i=1;i<=M;i++){
			st = new StringTokenizer(in.readLine());
			int a = find(Integer.parseInt(st.nextToken()));
			int b = find(Integer.parseInt(st.nextToken()));

			if(a==b){
				System.out.println(i);
				return;
			}

			if(a>=b) set[b] = a;
			else set[a] = b;

		}
		System.out.println(0);
	}

	private static int find(int x) {
		if(set[x]==x) return x;
		return set[x] = find(set[x]);
	}
}
