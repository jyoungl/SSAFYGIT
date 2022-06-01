package im형필수문제;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 유럽의 크기 R C
 * 2. 빈칸 . 블록 | - + 1 2 3 4
 * 3. 모스크바 M 자그레브 z
 * 출력
 * 1. 지워진 블록의 행과 열 위치, 어떤 블록이었는지 출력
 * 조건
 * 1. 해커가 블록 하나를 지워서 비워져 있음
 */
public class g3_2931_가스관 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		// 북 남 서 동
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		// 파이프의 모양
		char[] pipe = new char[4];
		// 파이프 위치를 찾았는지
		boolean find = false;
		
		// M과 Z가 제대로 연결되어 있는지 찾기
		boolean pipeM = false;
		boolean pipeZ = false;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j]=='M') {
					for (int k = 0; k < 4; k++) {
						int x = i+dx[k];
						int y = j+dy[k];

						if(x<0 || x>=R || y<0 || y>=C || arr[x][y]=='.') continue;
						
						pipeM = true;
					}
				} else if(arr[i][j]=='Z') {
					for (int k = 0; k < 4; k++) {
						int x = i+dx[k];
						int y = j+dy[k];

						if(x<0 || x>=R || y<0 || y>=C || arr[x][y]=='.') continue;
						
						pipeZ = true;
					}
				}
			}
		}
		
		// 지워진 블록 찾기
		findPipe: for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j]=='.') {
					// 만약 연결되어 있지 않다면 새로 연결해야 함
					boolean connectM = pipeM;
					boolean connectZ = pipeZ ;
					
					// 사방탐색
					for (int k = 0; k < 4; k++) {
						int x = i+dx[k];
						int y = j+dy[k];

						if(x<0 || x>=R || y<0 || y>=C || arr[x][y]=='.') continue;
						
						if(arr[x][y] == '+') {
							pipe[k] = 1;
							find = true;
						}
						
						// M이나 Z가 연결되어 있지 않고, 맞닿아 있다면 연결
						// 만약 다른 파이프와 연결되지 않았다면 M이나 Z와도 연결되면 안 됨
						if((!pipeM && arr[x][y] == 'M') || (!pipeZ && arr[x][y] =='Z')) {
							pipe[k] = 1;
							if(arr[x][y] == 'M') connectM = true;
							else if(arr[x][y] == 'Z') connectZ = true;
						}
						
						switch(k) {
							case 0:
								if(arr[x][y] == '|' || arr[x][y] == '1' || arr[x][y] == '4') {
									pipe[0] = 1;
									find = true;
								}
								break;
							case 1:
								if(arr[x][y] == '|' || arr[x][y] == '2' || arr[x][y] == '3') {
									pipe[1] = 1;
									find = true;
								}
								break;
							case 2:
								if(arr[x][y] == '-' || arr[x][y] == '1' || arr[x][y] == '2') {
									pipe[2] = 1;
									find = true;
								}
								break;
								
							case 3:
								if(arr[x][y] == '-' || arr[x][y] == '3' || arr[x][y] == '4') {
									pipe[3] = 1;
									find = true;
								}
								break;
						}
					}
					
					// M과 Z가 연결되어 있고 그 외의 파이프와 연결된 상태라면 블록 위치 출력
					if(connectM && connectZ && find) {
						sb.append(i+1).append(" ").append(j+1).append(" ");
						break findPipe;
					}
					
					// 찾지 못했다면 다시 처음부터
					find = false;
					pipe = new char[4];
					
				}
			}
		}
		
		char[][] block = {{'|', 1, 1, 0, 0}, {'-', 0, 0, 1, 1}, {'+', 1, 1, 1, 1},
							{'1', 0, 1, 0, 1}, {'2', 1, 0, 0, 1}, {'3', 1, 0, 1, 0}, {'4', 0, 1, 1, 0}};

		// 파이프 모양 찾기
		for(int i = 0; i < 7; i++) {
			char[] tmp = new char[4];
			for(int j = 1; j < 5; j++) {
				tmp[j-1] = block[i][j];
			}
			if(Arrays.equals(pipe, tmp)) {
				sb.append(block[i][0]);
				break;
			}
		}
		
		System.out.println(sb);

	}

}
