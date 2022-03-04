

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. N
 * 2. N개의 정수
 * 출력
 * 1. -1로만 채워진 종이의 개수
 * 2. 0으로만 채워진 종이의 개수
 * 3. 1로만 채워진 종이의 개수
 * 조건
 * 1. 9개로 자르기(변을 3개로 자르기)
 */
public class s2_1780_종이의개수 {
	static int m1, zero, p1;
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
		
		System.out.println(m1 + "\n" + zero + "\n" + p1);

	}

	private static void cut(int x, int y, int len) {
		int color = paper[x][y];
		boolean same = true;
		
		//자른 구역 탐색하며 색이 같은지 확인
		outer: for(int i = x; i<x+len; i++) {
			for(int j = y; j<y+len; j++) {
				if(paper[i][j]==color) continue;
				same = false;
				break outer;
			}
		}
		
		//색이 같다면 종이 개수 더해 줌
		if(same) {
			if(color==-1) m1++;
			else if(color==0) zero++;
			else if(color==1) p1++;
			
			return;
		}
		
		//같지 않다면 길이를 3으로 나눈 뒤 다시 재귀
		len /= 3;
		
		cut(x, y, len);
		cut(x+len, y, len);
		cut(x, y+len, len);
		cut(x+len, y+len, len);
		cut(x+len*2, y, len);
		cut(x, y+len*2, len);
		cut(x+len*2, y+len*2, len);
		cut(x+len, y+len*2, len);
		cut(x+len*2, y+len, len);
		
	}

}
