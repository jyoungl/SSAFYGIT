import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1063_킹 {

	// 우 좌 상 하 우상 좌상 우하 좌하 (문제기준)
	static int dir[][] = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

//	static int arr[][];

	static int xK, yK, xS, yS;

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 버퍼드리더로 값 읽어오기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

//		// 뒤의 8은 a부터 h까지 매칭
//		arr = new int[9][9];

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		char[] pos = st.nextToken().toCharArray();

		// 왕의 위치를 1로
		xK = pos[1] - '0';
		yK = pos[0] - 'A' + 1;

		pos = st.nextToken().toCharArray();

		xS = pos[1] - '0';
		yS = pos[0] - 'A' + 1;
//		System.out.println(xK+","+yK);
//		System.out.println(xS+","+yS);
		int N = Integer.parseInt(st.nextToken());
		// 왕 이동할 값 읽어와서 이동시키기
		for (int i = 0; i < N; i++) {
			String command = in.readLine();

			switch (command) {
			case "R":
				// 킹 이동 함수
				move(0);
				break;
			case "L":
				move(1);
				break;
			case "B":
				move(2);
				break;
			case "T":
				move(3);
				break;
			case "RT":
				move(4);
				break;
			case "LT":
				move(5);
				break;
			case "RB":
				move(6);
				break;
			case "LB":
				move(7);
				break;
			}

		}
		
		System.out.printf("%c%d\n",(char)(yK+'A'-1),xK);
		System.out.printf("%c%d\n",(char)(yS+'A'-1),xS);		
	}

	public static void move(int dirr) {
		int dx = dir[dirr][0];
		int dy = dir[dirr][1];

		// 킹이 이동할 위치가 범위 밖인지 확인
		if (xK + dx > 0 && xK + dx <= 8 && yK + dy > 0 && yK + dy <= 8) {
			// 킹의 위치를 변경할 곳에 돌이 있는지 확인
			if (xK + dx == xS && yK + dy == yS) {
				// 돌이 이동할 위치가 범위 밖인지 확인
				if (xS + dx > 0 && xS + dx <= 8 && yS + dy > 0 && yS + dy <= 8) {
					xK = xK + dx;
					yK = yK + dy;
					
					xS = xS + dx;
					yS = yS + dy;
				}
			}else{
				xK = xK + dx;
				yK = yK + dy;
			}
		}
		
	}

}
