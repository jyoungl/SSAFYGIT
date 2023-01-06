package dec15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1932_정수삼각형_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] res = new int[N][];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			res[i] = new int[i+1];
			for(int j=0;j<=i;j++) {
				res[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=N-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				res[i-1][j] += Math.max(res[i][j], res[i][j+1]);
			}
		}
		System.out.println(res[0][0]);
	}

}
