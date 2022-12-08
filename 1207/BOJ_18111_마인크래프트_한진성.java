import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111_마인크래프트_한진성 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		// 먼저 각 땅들의 높이의 최소, 최대를 구한다.
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, arr[i][j]);
				max = Math.max(max, arr[i][j]);
			}
		}
		int answer = Integer.MAX_VALUE;
		int height = 0;
		// 해당 높이들 중에서 가장 적은 시간이 걸리는 경우를 구한다.
		go:for(int i=min;i<=max;i++) {	
			int count = B;
			int time = 0;
			// 블럭 꺼내기
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(arr[j][k] > i) {
						count += arr[j][k] - i;
						time += (arr[j][k] - i)*2;
					}
					
				}
			}
			
			// 블럭 놓기
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(arr[j][k] < i) {
						count -= i - arr[j][k];
						time += (i - arr[j][k]);
					}					
					// 그 경우가 가능한 지 체크한다.
					if(count < 0) {
						continue go;
					}
				}
			}
			// 최소 시간 구하기
			if(answer >= time) {
				answer = time;
				height = i;
			}
			
			
		}
		
		System.out.println(answer + " " + height);
		
		
		
		
	}

}
