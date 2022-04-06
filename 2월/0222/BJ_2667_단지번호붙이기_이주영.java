package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2667_단지번호붙이기_이주영 {
	static int N;
	static int[][] arr;
	static int[] dr = {1, -1, 0, 0}; //아래, 위, 오른쪽, 왼쪽
	static int[] dc = {0, 0, 1, -1};
	static boolean[][] b;
	static int[] house;
	static int cnt;
	
	public static void dfs(int x, int y) {
		b[x][y] = true;
		
		house[cnt]++;
		
		for(int i=0;i<4;i++) {
			int nowx = x+dr[i];
			int nowy = y+dc[i];
			
			if(nowx>=0 && nowx<N && nowy>=0 && nowy<N && !b[nowx][nowy] && arr[nowx][nowy] == 1) {
				b[nowx][nowy] = true;
				dfs(nowx, nowy);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		b = new boolean[N][N];
		cnt = 0;
		house = new int[625];
		
		for(int i=0;i<N;i++) {
			char[] str = br.readLine().toCharArray();
			for(int j=0;j<N;j++)
				arr[i][j] = str[j] - '0';
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!b[i][j] && arr[i][j] == 1) {
					dfs(i,j);
					cnt++;
				}
			}
		}

		System.out.println(cnt);
		
		int[] res = new int[cnt];
		for(int i=0;i<cnt;i++) {
			res[i] = house[i];
		}
		
		Arrays.sort(res);
		
		for(int i=0;i<cnt;i++)
			System.out.println(res[i]);
	}

}
