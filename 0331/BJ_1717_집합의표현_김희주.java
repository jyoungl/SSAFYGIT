import java.io.*;
import java.util.*;

public class BOJ_1717_집합의표현 {
	static int[] sets;
	static int[] size;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		sets = new int[N+1];
		size = new int[N+1];
		for(int i=1;i<=N;i++) sets[i] = i;

		for(int i=0;i<M;i++){
			st = new StringTokenizer(in.readLine());
			switch(st.nextToken()){
				case "0":
					union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
					break;
				case "1":
					if(find(Integer.parseInt(st.nextToken()))==find(Integer.parseInt(st.nextToken()))) sb.append("YES\n");
					else sb.append("NO\n");
					break;
			}
		}

		System.out.print(sb);
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa==pb) return;

		if(size[pa]>=size[pb]) {
			sets[pb] = pa;
			size[pa]++;
		}else{
			sets[pa] = pb;
			size[pb]++;
		}
	}

	private static int find(int x){
		if(sets[x]==x) return x;
		return sets[x] = find(sets[x]);
	}
}
