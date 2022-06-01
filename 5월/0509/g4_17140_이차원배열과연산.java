package 구현;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. r c k
 * 2. 세 개의 줄에 배열 A에 들어있는 수
 * 출력
 * 1. A[r][c]에 들어있는 값이 k가 되기 위한 연산의 최소 시간
 * 2. 100초가 지나도 되지 않으면 -1 출력
 * 조건
 * 1. 
 */
public class g4_17140_이차원배열과연산 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		int k = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[101][101];
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(arr[r][c]==k) {
			System.out.println(0);
			System.exit(0);
		}
		
		int cnt = 0;
		
		while(cnt < 100) {
			cnt++;
			int max = 0; 
			
			if(r>=c) {
				for(int i = 0; i<r; i++) {
					
					int count[] = new int[101];
					
					for(int j = 0; j<c;j++) {
						count[arr[i][j]]++;
					}
					
					int l = 0; 
					
					for(int j =1; j<=c && l<100; j++) {
						for(int z = 1; z<101;z++) {
							if(count[z]==j) {
								arr[i][l++] = z;
								arr[i][l++] = j;
							}
						}
					}
					
					for(int j = l;j<=c && j<100;j++) {
						arr[i][j] = 0;
					}

					max = Math.max(l, max);
				}
				
				c = max;
				
			}else {
				for(int j = 0; j<c ;j++) {
					int count[] = new int[101];
					for(int i = 0; i<r;i++) {
						count[arr[i][j]]++;
					}
					int l = 0; 
					for(int i = 1 ; i<=r;i++) {
						for(int z= 1;z<101; z++) {
							if(count[z]==i) {
								arr[l++][j] = z;
								arr[l++][j] = i;
							}
						}
					}
					for(int i = l;i<=r && i<100; i++) {
						arr[i][j] = 0;
					}
					max = l>max?l:max;
				}
				r = max;
			}
			
			if(arr[r][c] == k) {
				System.out.println(cnt);
				System.exit(0);				
			}
		}
		
		System.out.println(-1);

	}

}
