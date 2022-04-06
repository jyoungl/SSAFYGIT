package im형필수문제;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 킹의 위치, 돌의 위치, 움직이는 횟수 N
 * 2. 킹의 움직임(TBLR 상하좌우 RT 오른쪽 위 ... )
 * 출력
 * 킹의 마지막 위치
 * 돌의 마지막 위치
 * 
 * >> 돌이 있는 방향으로 움직이면 돌이 킹을 따라서 같이 움직인다
 */
public class s4_1063_킹 {
	
	static int kingX;
	static int kingY;
	static int stoneX;
	static int stoneY;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[][] chess = new int[8][8];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String king = st.nextToken();
		String stone = st.nextToken();
		kingX = king.charAt(0) - 'A';
		kingY = king.charAt(1) - 49;
		stoneX = stone.charAt(0) - 'A';
		stoneY = stone.charAt(1) - 49;
		int N = Integer.parseInt(st.nextToken());
		
		chess[kingX][kingY] = 1;
		chess[stoneX][stoneY] = 2;
		
//		System.out.println("초기 왕X값: " + kingX);
//		System.out.println("초기 왕Y값: " + kingY);
//		System.out.println("초기 돌X값: " + stoneX);
//		System.out.println("초기 돌Y값: " + stoneY);
		
		for(int i = 0; i<N; i++) {
			String go = br.readLine();
			switch(go) {
			case("LT"):
				move(5);
				break;
			case("T"):
				move(4);
				break;
			case("RT"):
				move(3);
				break;
			case("LB"):
				move(2);
				break;
			case("B"):
				move(1);
				break;
			case("RB"):
				move(0);
				break;
			case("L"):
				move(7);
				break;
			case("R"):
				move(6);
				break;
			}
//			System.out.print("왕X값: " + kingX + " ");
//			System.out.println("왕Y값: " + kingY);
//			System.out.print("돌X값: " + stoneX + " ");
//			System.out.println("돌Y값: " + stoneY);	
		}
		
		char king2 = (char) (kingX+'A');
		char stone2 = (char) (stoneX+'A');
		
		sb.append(king2).append(kingY+1).append("\n").append(stone2).append(stoneY+1);
		System.out.println(sb);

	}
	private static void move(int i) {
		int[] dx = {1, 0, -1, 1, 0, -1, 1, -1}; //RB, B, LB, RT, T, LT, R, L
		int[] dy = {-1, -1, -1, 1, 1, 1, 0, 0};
		
		kingX += dx[i];
		kingY += dy[i];
		
		if(kingX<0 || kingX>=8 || kingY<0 || kingY>=8) {
			kingX -= dx[i];
			kingY -= dy[i];
			return;
		}
		
		if(kingX==stoneX && kingY==stoneY) {
			stoneX += dx[i];
			stoneY += dy[i];
			if(stoneX<0 || stoneX>=8 || stoneY<0 || stoneY>=8) {
				kingX -= dx[i];
				kingY -= dy[i];
				stoneX -= dx[i];
				stoneY -= dy[i];
				return;
			}
		}
		
		
	}

}
