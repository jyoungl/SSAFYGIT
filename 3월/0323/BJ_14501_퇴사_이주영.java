package mar24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14501_퇴사_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][2];
		
		StringTokenizer st;
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] res = new int[17];
		//res[1] = arr[1][1];
		int max = 0;
		for(int i=1;i<=N;i++) {
			int x = i + arr[i][0];
			res[i] = Math.max(res[i], res[i-1]);
			if(x<=N+1) {
				res[x] = Math.max(res[x], res[i]+arr[i][1]);
				max = Math.max(res[x], max);
			}
			
		}
		
		System.out.println(max);
	}

}
