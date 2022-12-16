import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2615_오목 {
	static int[][] dir = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int arr[][] = new int[19][19];
		StringTokenizer st = null;
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 싸피 알고리즘 시험?

		// 육목 금지
		// 한 방향 별로 6번씩 총 8방향 탐색하기
		int answer = 0;
		int x=0;
		int y=0;

		go:for (int j = 0; j < 19;j++) {
			for (int i = 0; i < 19; i++) {
				
				if(arr[i][j] == 1 || arr[i][j] == 2) {
					int winner = find(arr, i,j);
					
					if(winner == 1) {
						answer = 1;
						x = i;
						y = j;
						break go;
					}else if(winner == 2) {
						answer = 2;
						x = i;
						y = j;
						break go;
					}
				}
				
			}
		}
		System.out.println(answer);
		if(answer != 0) {
			System.out.println((x+1) + " "+ (y+1));
		}
	}
	
	static int find(int[][] arr, int x, int y) {
		
		for(int i=0;i<8;i++) {
			
			for(int j=1;j<=5;j++) {

				int dx = x + dir[i][0]*j;
				int dy = y + dir[i][1]*j;
				if(j == 5) {
					if(dx >= 0 && dy >= 0 && dx < 19 && dy < 19 && arr[dx][dy] != arr[x][y]) {
						int ddx = x - dir[i][0];
						int ddy = y - dir[i][1];
						
						if(ddx < 0 || ddx >= 19 || ddy < 0 || ddy >= 19) {
							return arr[x][y];
						}
						
						if(arr[x][y] != arr[ddx][ddy]) {
							return arr[x][y];							
						}
					}else if(dx < 0 || dx >= 19 || dy < 0 || dy >= 19) {
						int ddx = x - dir[i][0];
						int ddy = y - dir[i][1];
						
						if(ddx < 0 || ddx >= 19 || ddy < 0 || ddy >= 19) {
							return arr[x][y];
						}
						
						if(arr[x][y] != arr[ddx][ddy]) {
							return arr[x][y];							
						}
					}
				}
				
				if(dx < 0 || dx >= 19 || dy < 0 || dy >= 19 || arr[dx][dy] != arr[x][y]) {
					break;
				}
				
			}
			
		}
		
		return 0;
	}
	
}
