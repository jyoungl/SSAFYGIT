package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10157_자리배정_이주영 {
	//상 우 하 좌
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int C = Integer.parseInt(str[0]);
		int R = Integer.parseInt(str[1]);
		int K = Integer.parseInt(br.readLine());
		int[][] arr = new int[R][C];
		int d = 0;
		int x=R-1, y=0;
		int cnt = 1;

		if(R*C<K) {
			System.out.println("0");
			return;
		}
		arr[x][y] = cnt++;
		if(K==1) {
			System.out.println("1 1");
			return;
		}
		
		while(cnt <= K) {	
			int dx = x + dr[d];
			int dy = y + dc[d];
			if(dx<0 || dy<0 || dx>=R || dy>=C || arr[dx][dy]!=0) {
				d++;
				if(d>3)
					d %= 4;
				dx = x + dr[d];
				dy = y + dc[d];
			}
			
			x = dx;
			y = dy;
			
			arr[x][y] = cnt++;
		}
		
		System.out.printf("%d %d", y+1, R-x);
	}

}
