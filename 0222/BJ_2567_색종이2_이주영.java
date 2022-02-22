package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2567_색종이2_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //색종이 수
		int[][] arr = new int[102][102];
		int[] dr = {0, 0, 1, -1}; //우 좌 하 상
		int[] dc = {1, -1, 0, 0};
		int cnt = 0;
		boolean[][] b = new boolean[102][102];
		
		//색종이 배열에 입력
		for(int t=0;t<N;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i=x;i<x+10;i++) 
				for(int j=y;j<y+10;j++) 
					arr[i][j] = 1;
	
		}
		
		for(int i=0;i<102;i++) {
			for(int j=0;j<102;j++) {
				if(arr[i][j] == 1) {
					for(int d=0;d<4;d++) {
						int dx = i + dr[d];
						int dy = j + dc[d];
						if(!b[dx][dy] && arr[dx][dy] == 0 && dx>=0 && dy>=0 && dx<102&&dy<102)
							cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}

}
