import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 기존 파일은 성공하지 못했는데, 시간이 다되어서 미완성본을 제출했습니다. 12시 이후 해결한 코드를 새로제출합니다.
public class BOJ_1987_알파벳 {
	static int R,C;
	static int[][] arr;
	
	//상하좌우
	static int[][] dir = { {-1,0},{1,0},{0,-1},{0,1} };
	
	// 방문정보를 확인할 알파벳 개수만큼의 배열
	static boolean check[] = new boolean[26];
	
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 버퍼드리더로 값 읽어오기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// N = 배열 크기 읽어오기
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[R][C];
		
		for(int i=0;i<R;i++) {
			String str = in.readLine();
			for(int j=0;j<C;j++) {
				// 'A'를 빼주어 알파벳을 숫자로 만든다. 이래야 배열로 넘버링이 가능
				arr[i][j] = str.charAt(j)-'A';
			}
		}
		
		//처음위치 방문 처리 : 방문처리를 다음에 이동할 곳부터 하기 때문에 초기 알파벳 방문 처리
		check[arr[0][0]] = true;
		
		
		dfs(0,0,0);
		
		System.out.println(max);
	}
	
	public static void dfs(int x, int y, int cnt) {
		
		//매번 재귀 호출시마다 max값 갱신해준다. 코드 짜고보니 cnt가 하나 부족한데 이유를 모르겠음. 공통적으로 cnt가 1 부족한 이유?
		// 이유는 모르겠지만 +1해주니 테케는 통과됨. ????
		max = Math.max(max, cnt+1);
		
		// 유도파트
		for(int i=0;i<4;i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];
			
			// 값이 범위를 벗어나지 않으면서
			if(dx >= 0 && dx < R && dy >= 0 && dy < C) {
				// 이동할 값이 아직 방문하지 않은 알파벳이라면
				if(!check[arr[dx][dy]]) {
					// 방문할 곳 방문처리.
					check[arr[dx][dy]] = true;
					// 재귀호출(좌표이동) + 카운트 ++
					dfs(dx,dy,cnt+1);
				}
			}
		}
		
		// 더이상 이동할 곳이 없는 경우
		check[arr[x][y]] = false;
	}

}
