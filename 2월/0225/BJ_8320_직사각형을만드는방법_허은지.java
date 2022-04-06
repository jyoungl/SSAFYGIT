package im형필수문제;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 길이가 1인 정사각형 n개
 * 출력
 * 1. 만들 수 있는 직사각형의 개수
 * 
 * >> i와 j를 곱했을 때 n보다 크면 안 됨
 * >> boolean 양방향으로 체크
 */
public class b2_8320_직사각형을만드는방법 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		boolean[][] check = new boolean[n+1][n+1];
		
		int count = 0;
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				//check가 false고 i와 j를 곱했을 때 n보다 크지 않으면
				if(!check[i][j] && i*j<=n) {
					//check 양방향 체크
					check[i][j] = check[j][i] = true;
					//개수 추가
					count++;
				}
			}
		}
		
		System.out.println(count);
		
	}

}
