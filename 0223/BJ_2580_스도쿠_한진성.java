import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2580_스도쿠 {

	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		arr = new int[9][9];
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
				
		dfs(0,0);
		
	}

	
	static void dfs(int x, int y) {
		
		
		if(y == 9) {
			dfs(x+1,0);
			return;
		}
		
		if(x == 9) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		
		
		if(arr[x][y] == 0) {
			for(int i=1;i<=9;i++) {
				if(check(x,y,i)) {
					arr[x][y] = i;
					dfs(x,y+1);
				}
			}
			arr[x][y] = 0;
			return;
		}
		
		dfs(x,y+1);
		
	}
	
	
	static boolean check(int x, int y, int value) {
		
		// 같은 열
		for(int i=0;i<9;i++) {
			if(arr[x][i] == value) {
				return false;
			}
		}
		
		// 같은 행
		for(int i=0;i<9;i++) {
			if(arr[i][y] == value) {
				return false;
			}
		}
		
		int xx = (x/3)*3;
		int yy = (y/3)*3;
		
		for(int i=xx;i<xx+3;i++) {
			for(int j=yy;j<yy+3;j++) {
				if(arr[i][j]==value) {
					return false;
				}
			}
		}
		return true;
		
	}
}
