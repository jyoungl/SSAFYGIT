import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_3289_서로소집합_이주영 {
	static int arr[];
	static int n;
	static int m;
	
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
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); //1~n
			m = Integer.parseInt(st.nextToken()); //연산 개수
			arr = new int[n+1];
			
			for(int i=1;i<=n;i++) {
				arr[i] = i;
			}
			
			sb.append("#"+tc+" ");
			
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken()); 
				
				if(op == 1) {
					int a = find_set(x);
					int b = find_set(y);
					if(a == b)
						sb.append("1");
					else
						sb.append("0");
				}
				else
					union_set(x,y);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}


//for(int j=0;j<m;j++) {
//	st = new StringTokenizer(br.readLine());
//	int op = Integer.parseInt(st.nextToken());
//	int x = Integer.parseInt(st.nextToken());
//	int y = Integer.parseInt(st.nextToken());
//	
//	String x1 = Integer.toString(x);
//	String y1 = Integer.toString(y);
//	
//	if(op == 0) {
//		for(int i=0;i<list.size();i++) {
//			String s = list.get(i);
//
//			if(s.contains(x1)) {
//				s += y1;
//				list.set(i, s);
//				break;
//			}
//		}
//	}
//		
//	if(op == 1) {
//		boolean b = false;
//		
//		for(int i=0;i<list.size();i++) {
//			String s = list.get(i);
//
//			if(s.contains(x1) && s.contains(y1)) {
//				b = true;
//				break;
//			}
//		}
//		
//		if(b)	sb.append("1");
//		else	sb.append("0");
//	}
//}
//sb.append("\n");
//}
//
//System.out.println(sb);