package apr21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15684_사다리조작_이주영 {
	static int N, M, H;
	static int[][] arr;
	
	public static boolean dfs(int x, int y, int cnt, int s) {
		if(cnt == s) {
			if(line()) {
				System.out.println(s);
				return true;
			}
			return false;
		}
		
		for(int i=x;i<H;i++) {
			for(int j=y;j<N-1;j++) {
				if(arr[i][j]!=0 || arr[i][j+1]!=0) 
					continue;
				
				arr[i][j] = 1;
				arr[i][j+1] = -1;
				
				if(dfs(i,j+2, cnt+1, s))
					return true;
				
				arr[i][j] = 0;
				arr[i][j+1] = 0;
				
			}
			y=0;
			
		}
		return false;
	}
	
	public static boolean line() {
		for(int i=0;i<N;i++) {
			int x = 0;
			int y = i;
			
			while(x<=H) {
				if(arr[x][y] == 1)
					y++;
				else if(arr[x][y] == -1)
					y--;
				
				x++;
			}
			
			if(y != i)
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H+1][N];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x-1][y-1] = 1;
			arr[x-1][y] = -1;
		}
		
		int cnt = 0;
		for(int i=0;i<N;i++) {
			int c = 0;
			for(int j=0;j<H;j++) {
				if(arr[j][i] == 1)
					c++;
			}
			if(c%2==1)
				cnt++;
		}
		
		if(cnt>3) {
			System.out.println("-1");
			return;
		}
		else {
			for(int i=0;i<=3;i++) {
				if(dfs(0,0,0,i))
					return;
			}
		}
		
		System.out.println("-1");
		
		
	}

}
