import java.io.*;
import java.util.*;

public class BOJ_9613_GCD합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N;
		int[] input;
		long sum;
		for(int tc=0;tc<T;tc++){
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			input = new int[N];
			for(int i=0;i<N;i++){
				input[i] = Integer.parseInt(st.nextToken());
			}
			sum = 0;
			for(int i=0;i<N-1;i++){
				for(int j=i+1;j<N;j++){
					sum += gcd(input[i], input[j]);
				}
			}
			sb.append(sum).append('\n');
		}
		System.out.print(sb);
	}
	private static int gcd(int a, int b){
		if(a%b==0) return b;
		return gcd(b,a%b);
	}
}
