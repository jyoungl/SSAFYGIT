import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자 {
	static int[] set;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());

		set = new int[N+1];
		for(int i=1;i<N;i++) set[i] = i;

		for(int i=1;i<=N;i++){
			st = new StringTokenizer(in.readLine());
			for(int j=1;j<=N;j++){
				if(st.nextToken().equals("1")) union(i,j);
			}
		}

		st = new StringTokenizer(in.readLine());
		int root = find(Integer.parseInt(st.nextToken()));
		for(int i=1;i<M;i++){
			if(root!=find(Integer.parseInt(st.nextToken()))){
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	private static int find(int x){
		if(set[x]==x) return x;
		return set[x]=find(set[x]);
	}

	private static void union(int a, int b){
		int pa = find(a);
		int pb = find(b);

		if(pa==pb) return;

		if(pa>pb) set[pb] = pa;
		else set[pa] = pb;
	}
}
