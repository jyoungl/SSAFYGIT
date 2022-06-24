import java.io.*;
import java.util.*;

public class BOJ_3036_링 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int first = Integer.parseInt(st.nextToken());
		for(int i=1;i<N;i++){
			int b = Integer.parseInt(st.nextToken());
			int g = gcd(first,b);
			sb.append(first/g).append('/').append(b/g).append('\n');
		}
		System.out.println(sb);
	}
	private static int gcd(int a, int b){
		if(a%b==0) return b;
		return gcd(b,a%b);
	}
}
