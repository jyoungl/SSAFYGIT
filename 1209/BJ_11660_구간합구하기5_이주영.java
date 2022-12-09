package dec09;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11660_구간합구하기5_이주영 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		int[][] dp = new int[N][N];
		//배열에 값 입력
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum += arr[i][j];
				dp[i][j] = sum;
			}
		}
		
		int x1,y1,x2,y2;
		//구해야하는 범위
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken())-1;
			y1 = Integer.parseInt(st.nextToken())-1;
			x2 = Integer.parseInt(st.nextToken())-1;
			y2 = Integer.parseInt(st.nextToken())-1;
			
			int res = 0;
			for(int j=x1;j<=x2;j++) {
				res += dp[j][y2];
				if(y1 > 0)
					res -= dp[j][y1-1];
			}
			sb.append(res+"\n");
		}
		System.out.println(sb);
	}

}
