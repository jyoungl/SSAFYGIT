package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1063_킹_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String kingPos = st.nextToken();
		String stonePos = st.nextToken();
		int N = Integer.parseInt(st.nextToken());
		
		String[] move = new String[N];
		
		for(int i=0;i<N;i++) 
			move[i] = br.readLine();
		
		//현재 킹 위치 [kingY][kingX]
		int kingX = kingPos.charAt(1) - '0'; //열
		int kingY = kingPos.charAt(0) - 'A'; //행
		//현재 돌 위치
		int stoneX = stonePos.charAt(1)- '0';
		int stoneY = stonePos.charAt(0) - 'A';
		
		//주어진 횟수만큼 움직임
		for(int i=0;i<N;i++) {
			String m = move[i];
			
			int temp = 0;
			int temp2 = 0;
			switch(m) {
			case "B":
				temp = kingY-1;
				if(temp>=1 && temp <= 8) {
					if(temp == stoneY && kingX == stoneX) {
						if(stoneY>1) {
							stoneY--;
						}
					}
					else
						kingY = temp;
				}
				break;
			case "T":
				temp = kingY+1;
				if(temp>=1 && temp <= 8) {
					if(temp == stoneY && kingX == stoneX) {
						if(stoneY<8) {
							stoneY++;
							kingY = temp;
						}
					}
					else
						kingY = temp;
				}
				
				break;
			case "R":
				temp = kingX+1;
				if(temp>=1 && temp <= 8) {
					if(temp == stoneX && kingY == stoneY) {
						if(stoneX<8) {
							stoneX++;
							kingX = temp;
						}
					}
					else
						kingX = temp;
				}
				break;
			case "L":
				temp = kingX-1;
				if(temp>=1 && temp <= 8) {
					if(temp == stoneX && kingY == stoneY) {
						if(stoneX>1) {
							stoneX--;
							kingX = temp;
						}
					}
					else
						kingX = temp;
				}
				break;
			case "RT":
				temp = kingX+1;
				temp2 = kingY+1;
				if(temp>=1 && temp <= 8 && temp2>=0 && temp2 <=7) {
					if(temp == stoneX && temp2 == stoneY) {
						if(stoneX<8 && stoneY<7) {
							stoneY++;
							stoneX++;
							kingX = temp;
							kingY = temp2;		
						}
					}
					else {
						kingX = temp;
						kingY = temp2;
					}
				}
				break;
			case "LT":
				temp = kingX-1;
				temp2 = kingY+1;
				if(temp>=1 && temp <= 8 && temp2>=0 && temp2 <=7) {
					if(temp == stoneX && temp2 == stoneY) {
						if(stoneX>1 && stoneY<7) {
							stoneY++;
							stoneX--;
							kingX = temp;
							kingY = temp2;		
						}
					}
					else {
						kingX = temp;
						kingY = temp2;
					}
				}
				break;
			case "RB":
				temp = kingX+1;
				temp2 = kingY-1;
				if(temp>=1 && temp <= 8 && temp2>=0 && temp2 <=7) {
					if(temp == stoneX && temp2 == stoneY) {
						if(stoneX<8 && stoneY>0) {
							stoneY--;
							stoneX++;
							kingX = temp;
							kingY = temp2;		
						}
					}
					else {
						kingX = temp;
						kingY = temp2;
					}
				}
				break;
			case "LB":
				temp = kingX-1;
				temp2 = kingY-1;
				if(temp>=1 && temp <= 8 && temp2>=0 && temp2 <=7) {
					if(temp == stoneX && temp2 == stoneY) {
						if(stoneX>1 && stoneY>0) {
							stoneY--;
							stoneX--;
							kingX = temp;
							kingY = temp2;		
						}
					}
					else {
						kingX = temp;
						kingY = temp2;
					}
				}
				break;
			}
		}
		String kingRes = "";
		kingRes += (char)(kingY+65);
		String stoneRes = "";
		stoneRes += (char)(stoneY+65);
		System.out.println(kingRes + kingX);
		System.out.println(stoneRes + stoneX);
	}

}
