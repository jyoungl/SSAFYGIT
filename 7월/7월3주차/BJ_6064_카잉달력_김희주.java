import java.io.*;
import java.util.*;

public class BOJ_6064_카잉달력 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();

		int M,N,x,y;
		StringTokenizer st;
		while(T-->0){
			st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			int max = M/gcd(M,N)*N;
			Set<Integer> set = new HashSet<>();
			for(int i=x;i<=max;i+=M){
				set.add(i);
			}
			int res = -1;
			for(int i=y;i<=max;i+=N){
				if(set.contains(i)){
					res = i;
					break;
				}
			}
			sb.append(res).append('\n');
		}

		System.out.print(sb);
	}
	private static int gcd(int a,int b){
		if(a<b){
			int tmp = a;
			a = b;
			b = tmp;
		}
		if(a%b==0) return b;
		return gcd(b,a%b);
	}

}
