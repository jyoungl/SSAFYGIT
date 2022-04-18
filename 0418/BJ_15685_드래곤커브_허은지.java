package 구현;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 드래곤 커브의 개수 N
 * 2. 드래곤 커브의 시작점 x, y 시작 방향 d(0 동 1 북 2 서 3 남) 세대 g
 * 3. 드래곤 커브는 서로 겹칠 수 있다
 * 출력
 * 1. 정사각형의 네 꼭짓점이 모두 드래곤 커브의 일부인 것의 개수
 * 조건
 * 1. 1세대 드래곤 커브는 길이가 1인 선분
 * 2. K는 K-1세대 드래곤 커브를 90도 회전시켜서 붙인 것
 */
public class g4_15685_드래곤커브 {
	static int N;
	static boolean visited[][];
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		visited = new boolean[101][101];
		
		for (int i = 0; i < N; i++) {		
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			dragoncurve(x, y, d, g);

		}
		
		System.out.println(find());

	}

	private static void dragoncurve(int x, int y, int d, int g) {
		List<Integer> dc = new ArrayList<>();
		
        dc.add(d);

        for (int i = 1; i <= g; i++) {
            for (int j = dc.size() - 1; j >= 0; j--) {
                dc.add((dc.get(j) + 1) % 4);
            }
        }

        visited[x][y] = true;
        
        for (Integer dir : dc) {
            x += dx[dir];
            y += dy[dir];
            visited[x][y] = true;
        }
		
	}

	private static int find() {
		int cnt = 0;
		
		for(int i = 0; i<100; i++) {
			for(int j = 0; j<100; j++) {
				if(visited[i][j] && visited[i+1][j] && visited[i][j+1] && visited[i+1][j+1]) cnt++;
			}
		}
		
		return cnt;
	}

}
