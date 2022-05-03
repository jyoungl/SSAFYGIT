import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자 {

	static int[] parents;
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int M = Integer.parseInt(in.readLine());
        
        makeSet(N);
		
        StringTokenizer st;
        for(int i=1;i<=N;i++) {
        	st = new StringTokenizer(in.readLine()," ");
        	for(int j=1;j<=N;j++) {
        		int num = Integer.parseInt(st.nextToken());
        		if(num == 1) {
        			union(i,j);
        		}
        	}
        }
        
        st = new StringTokenizer(in.readLine()," ");
        int start = findSet(Integer.parseInt(st.nextToken()));
        for(int i=1;i<M;i++) {
        	int inNum = Integer.parseInt(st.nextToken());
        	
        	if(start != findSet(inNum)) {
        		System.out.println("NO");
        		return;
        	}
        }
        
        System.out.println("YES");
	}

	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	static int findSet(int a) {
		
		if(a == parents[a]) {
			return a;
		} else {
			return parents[a] = findSet(parents[a]);
		}
	}

	public static void makeSet(int N) {
		parents = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			parents[i] = i;
		}
	
	}
}
