package jun_vac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1049_기타줄_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[M][2];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		
		if(N<=6) {
			for(int i=0;i<M;i++) {
				min = Math.min(arr[i][0], Math.min(min, arr[i][1]*N));
			}
			System.out.println(min);
			return;
		}
		else {
			int x = N/6;
			int y = N%6;
			int sum1 = Integer.MAX_VALUE, sum2=Integer.MAX_VALUE;
			for(int i=0;i<M;i++) {
				sum1 = Math.min(arr[i][0]*x, sum1);
				sum2 = Math.min(sum2, arr[i][1]);
			}
			
			int res = sum1 + sum2*y;
			res = Math.min(res, (sum1/x)*(x+1));
			res = Math.min(res, sum2*N);
			
			System.out.println(res);
			return;
		}
		
	}

}
