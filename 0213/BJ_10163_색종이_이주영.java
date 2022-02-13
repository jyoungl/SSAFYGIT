package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10163_색종이_이주영 {
	static int[][] map = new int[1001][1001];
	static int N;
	public static void check(int num, int x, int y, int w, int h) {
		for(int i=x;i<x+w;i++) {
			for(int j=y;j<y+h;j++) {
				if(i>=0 && j>=0 && i<1002 && j<1002) {
					map[i][j] = num;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		//입력
		for(int i=0;i<N;i++) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			int w = Integer.parseInt(str[2]);
			int h = Integer.parseInt(str[3]);
			check(i+1, x, y, w, h);
		}
		
		//출력
		for(int i=0;i<N;i++) {
			int cnt = 0;
			
			for(int j=0;j<1001;j++) {
				for(int z=0;z<1001;z++) {
					if(map[j][z] == i+1)
						cnt++;
				}
			}
			
			sb.append(cnt+"\n");
		}
		
		System.out.println(sb);
	}

}
