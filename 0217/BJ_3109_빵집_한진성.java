import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3109_빵집 {
	static int R,C;
	static char arr[][];
	static int cnt;
	static int startcnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 버퍼드리더로 값 읽어오기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// N = 배열 크기 읽어오기
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][C];
		
		// 설치 가능한 파이프 - ., 설치 불가능한 파이프  - x
		for(int i=0;i<R;i++) {
			arr[i] = in.readLine().toCharArray();
		}
		cnt = 0;
		for(int i=0;i<R;i++) {
			if(dfs(i,0)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
//		 값 할당 테스트

		
		
	}
	
	
	public static boolean dfs(int x, int y) {
		
		arr[x][y] = 'c';
		if(y == C-1) {
//			for(int i=0;i<R;i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
//			System.out.println("+++++++++++++++++++++");
			return true;
		}
		
		// 오른쪽 위로 갈 수 있으면 가기
		if(x-1 >= 0 && arr[x-1][y+1] == '.') {
			arr[x-1][y+1] = 'c';
			if(dfs(x-1,y+1)) {
				return true;
			}
		// 오른쪽으로 갈 수 있으면 가기
		}
		if(arr[x][y+1] == '.') {
			arr[x][y+1] = 'c';
			if(dfs(x,y+1)) {
				return true;
			}
		// 오른쪽 아래로 갈 수 있으면 가기
		}
		if(x+1 < R && arr[x+1][y+1] == '.' ) {
			arr[x+1][y+1] = 'c';
			if(dfs(x+1,y+1)) {
				return true;
			}
		}
		
		return false;
	}
	
	
}
