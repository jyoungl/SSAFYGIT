package mar25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1010_다리놓기_이주영 {
	public static void combi(int[][] res) {
		//nCn, nC0 <- 무조건 1인 경우들
		for(int i=0;i<30;i++) {
			res[i][0] = 1;
			res[i][i] = 1;
		}
		
		//nCr = n-1Cr-1 + n-1Cr <- nCr 구하는 식
		for(int i=2;i<30;i++) {
			for(int j=1;j<30;j++) {
				res[i][j] = res[i-1][j-1] + res[i-1][j];
			}
		} //옛날에 배웠던 조합 함수로 어떻게 풀지 싶어서 그냥 2C1부터 30C30까지 싹 다 한번씩 계산해서 배열에 넣어줬습니당..
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[][] res = new int[30][30];
		
		//조합 계산 함수
		combi(res);
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(res[M][N]+"\n"); //ㄱ래서 그냥 바로 출력해주고 끝냈어요 ㅎㅎ..!
		}
		
		System.out.println(sb);
	}
}
