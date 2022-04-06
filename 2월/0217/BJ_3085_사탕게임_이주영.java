package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_3085_사탕게임_이주영 {
	static int N;
	static char[][] candy;
	static int res = 0;
	static int max = Integer.MIN_VALUE;
	
	public static void func() {
		//행 계산
		for(int i=0;i<N;i++) {
			int cnt = 1;
			
			for(int j=0;j<N-1;j++) {
				if(candy[i][j] == candy[i][j+1])
					cnt++;
				else
					cnt=1;
				max = Math.max(max, cnt);
			}
		}
		
		//열 계산
		for(int j=0;j<N;j++) {
			int cnt = 1;
			
			for(int i=0;i<N-1;i++) {
				if(candy[i][j] == candy[i+1][j])
					cnt++;
				else
					cnt=1;
				max = Math.max(max, cnt);
			}
		}

	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		candy = new char[N][N];
		
		for(int i=0;i<N;i++) {
			char[] str = br.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				candy[i][j] = str[j];
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N-1;j++) {
				if(candy[i][j] != candy[i][j+1]) {
					char temp = candy[i][j];
					candy[i][j] = candy[i][j+1];
					candy[i][j+1] = temp;
				}
				func();
				char temp = candy[i][j];
				candy[i][j] = candy[i][j+1];
				candy[i][j+1] = temp;
			}
		}
		
		for(int j=0;j<N;j++) {
			for(int i=0;i<N-1;i++) {
				if(candy[i][j] != candy[i+1][j]) {
					char temp = candy[i][j];
					candy[i][j] = candy[i+1][j];
					candy[i+1][j] = temp;
				}
				
				func();
				char temp = candy[i][j];
				candy[i][j] = candy[i+1][j];
				candy[i+1][j] = temp;
			}
		}
		
		System.out.println(max);
	}

}
