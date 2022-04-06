package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2580_스도쿠_이주영 {
	static int[][] arr = new int[9][9];
	static boolean[][] b = new boolean[9][9];
	static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int row, int col) {
		if(row == 9) {
			dfs(0, col+1);
			return;
		}
		
		if(col == 9) {
			for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++)
				sb.append(arr[i][j]+" ");
			sb.append("\n");
		}
		
		System.out.println(sb);
		System.exit(0);
		}
		
		if(arr[row][col] == 0) {
			for(int j = 1 ; j <= 9 ; j++) {
				if(search(row, col, j)) {
					arr[row][col] = j;
					dfs(row+1, col);
				}
			}
			arr[row][col] = 0;
			return;
			
		}
		
		dfs(row+1, col);
	}
	
	public static boolean search(int row, int col, int value) {
		//같은열에 무슨 숫자가 비었는지
		for(int i = 0 ; i < 9 ; i ++) {
			if(arr[row][i] == value) {
				return false;
			}
		}
		
		//같은행에 무슨 숫자가 비었는지
		for(int i = 0 ; i < 9 ; i ++) {
			if(arr[i][col] == value) {
				return false;
			}
		}
		
		//같은 네모에 뭐가 있는지
		int ind_row = (row/3)*3;
		int ind_col = (col/3)*3;
		
		for(int i = ind_row ; i < ind_row+3 ; i ++) {
			for(int j = ind_col ; j < ind_col +3 ; j++) {
				if(arr[i][j] == value)
					return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		ArrayList<int[]> list = new ArrayList<>();
		
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
//				if(arr[i][j] == 0)
//					list.add(new int[] {i,j});
			}
		}
		
		dfs(0,0);
		
//		for(int i=0;i<list.size();i++) {
//			int x = list.get(i)[0];
//			int y = list.get(i)[1];
//			
//			for(int j = 1 ; j <= 9 ; j++) {
//				if(search(x, y, j)) {
//					arr[x][y] = j;
//				}
//			}
//			
//		}
//		StringBuilder sb = new StringBuilder();
//		
//		for(int i=0;i<9;i++) {
//			for(int j=0;j<9;j++)
//				sb.append(arr[i][j]+" ");
//			sb.append("\n");
//		}
//		
//		System.out.println(sb);
	}

}
