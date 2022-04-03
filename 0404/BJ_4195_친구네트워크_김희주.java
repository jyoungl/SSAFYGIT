import java.io.*;
import java.util.*;

public class BOJ_4195_친구네트워크 {
	static Map<String,String> network;
	static Map<String, Integer> depth;
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		while(T-->0){
			int F = Integer.parseInt(in.readLine());
			network = new HashMap<>();
			depth = new HashMap<>();
			for(int i=0;i<F;i++){
				st = new StringTokenizer(in.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				network.putIfAbsent(a, a);
				network.putIfAbsent(b, b);
				depth.putIfAbsent(a,1);
				depth.putIfAbsent(b,1);
				sb.append(union(a,b)).append("\n");
			}
		}
		System.out.print(sb);
	}

	private static int union(String a, String b) {
		String pa = find(a);
		String pb = find(b);
		if(pa.equals(pb)) return depth.get(pa);//부모가 같으면 부모 depth를 리턴해야함.

		int da = depth.get(pa);
		int db = depth.get(pb);

		if(da>=db){
			network.replace(pb,pa);
			depth.replace(pa,da+db);
		}else{
			network.replace(pa,pb);
			depth.replace(pb,da+db);
		}

		return da+db;
	}

	private static String find(String x) {
		if(network.get(x).equals(x)) return x;
		network.replace(x,find(network.get(x)));//이전값을 반환함
		return network.get(x);
	}
}
