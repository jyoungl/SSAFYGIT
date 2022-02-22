import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class D4_7465_창용마을무리의개수_이주영 {
	static int[] arr;
	
	public static int find_set(int x) {
		if(arr[x] == x)
			return x;
		
		return arr[x] = find_set(arr[x]);
	}
	
	public static boolean union_set(int x, int y) {
		int a = find_set(x);
		int b = find_set(y);
		
		if(a == b)
			return false;
		
		arr[b] = a;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		//ArrayList<Integer> list = new ArrayList<>();
		
		for(int tc=1;tc<=T;tc++) {
			HashSet<Integer> hash = new HashSet<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //사람 번호
			int M = Integer.parseInt(st.nextToken()); //사람관계수
			arr = new int[N+1];
			
			for(int i=1;i<=N;i++)
				arr[i] = i;
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				union_set(x, y);
			}
			
			for(int i=1;i<=N;i++)
				hash.add(find_set(i));
			
			System.out.println("#"+tc+" "+hash.size());
		}
	}

}
