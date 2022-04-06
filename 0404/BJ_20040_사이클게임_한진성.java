import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20040_사이클게임 {

	static int[] parents;
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        makeSet(N);
        


        for(int i=1;i<=M;i++) {
            st = new StringTokenizer(in.readLine()," ");
            int find1 = Integer.parseInt(st.nextToken());
        	int find2 = Integer.parseInt(st.nextToken());
        	
        	if(findSet(find1) == findSet(find2)) {
        		System.out.println(i);
        		return;
        	}
        	union(find1,find2);
        }
        
        System.out.println(0);
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
