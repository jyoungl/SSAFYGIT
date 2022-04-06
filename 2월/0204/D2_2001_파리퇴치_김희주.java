import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_2001_파리퇴치 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");
			
			//입력
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//탐색
			int maxSum = Integer.MIN_VALUE;
			for(int i=0;i<=N-M;i++) {
				for(int j=0;j<=N-M;j++) {
					int sum = 0;
					for(int k=i;k<i+M;k++) {
						for(int l=j;l<j+M;l++) {
							sum+=arr[k][l];
						}
					}
					
					maxSum = Math.max(maxSum, sum);
					
				}
			}
			
			
			sb.append(maxSum).append("\n");
		}
		
		System.out.println(sb);
	}
}
