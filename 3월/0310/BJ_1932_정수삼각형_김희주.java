import java.io.*;
import java.util.*;

public class BOJ_1932_정수삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(in.readLine());
		int[] triangle = new int[N*(N+1)/2];

		int idx = 0;int max = Integer.MIN_VALUE;
		for(int n=1;n<=N;n++){
			st = new StringTokenizer(in.readLine());
			for(int i=1;i<=n;i++,idx++){
				triangle[idx] = Integer.parseInt(st.nextToken());
				int tmp = Math.max(i!=1?triangle[idx-n]:0, i!=n?triangle[idx-n+1]:0);
				triangle[idx] += tmp;

				if(n==N) max = Math.max(max,triangle[idx]);
			}
		}

		System.out.println(max);

	}
}
