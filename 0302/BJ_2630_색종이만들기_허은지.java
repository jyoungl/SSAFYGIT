

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 전체 종이의 길이 N
 * 2. 종이(하얀색 0, 파란색 1)
 * 출력
 * 1. 잘라진 하얀색 색종이의 개수
 * 2. 파란색 색종이의 개수
 * 
 * >> 네 등분해서 1234가 전부 같은 색이면 색 추가
 * >> 아니면 재귀로 네 등분
 */
public class BJ_2630_색종이만들기_허은지 {
	static int white, blue;
	static int[][] paper;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		paper = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(0, 0, N);
		
		System.out.println(white + "\n" + blue);

	}
	
	private static void cut(int x, int y, int len) {
		int color = paper[x][y];
		boolean same = true;
		
		for(int i = x; i<x+len; i++) {
			for(int j = y; j<y+len; j++) {
				if(paper[i][j] != color) same = false;
				
			}
		}
		
		if(same) {
			if(paper[x][y]==0) white++;
			else blue++;
			return;
		}
		
		len /= 2;
		
		cut(x, y, len);
		cut(x, y+len, len);
		cut(x+len, y, len);
		cut(x+len, y+len, len);
		
		
	}

}
