import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663_N_Queen {
	static int N;
	static int col[];
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		col = new int[N+1];
		ans = 0;		
		queen(1);
//		queen2(1);
		System.out.println(ans);

	}

	
	
	// 재귀함수를 만드는데, 퀸을 1번째부터 N번째까지 놓으면서 N번쨰에문제가 생길 경우 N-1번째로 돌아가서 테스팅
	
	public static void queen(int rowNo) { // rowNo : 퀸을 두어야 하는 현재행
		
		// 대각선 : 행의 차이값과 열의 차이값이 같으면 대각선이다.
		
		if(!isAble(rowNo-1)) { // 직전까지의 상황이 유망하지 않다면 리턴
			return;
		}
		
		// 기저조건
		if(rowNo > N) {
			ans++;
			return;
		}
		
		// 1열부터 - n열까지 퀸을 놓는 시도
		// 유도조건
		for(int i=1;i<=N;i++) {
			col[rowNo] = i;
			queen(rowNo+1);
		}
		
	}
	
	public static void queen2(int rowNo) { // rowNo : 퀸을 두어야 하는 현재행
		
		// 대각선 : 행의 차이값과 열의 차이값이 같으면 대각선이다.
		
		// 기저조건
		if(rowNo > N) {
			ans++;
			return;
		}
		
		// 1열부터 - n열까지 퀸을 놓는 시도
		// 유도조건
		for(int i=1;i<=N;i++) {
			col[rowNo] = i;
			if(isAble(rowNo)) { // 직전까지의 상황이 유망하다면 다음으로 넘어간다.
				queen(rowNo+1);
			}

		}
		
	}
	
	public static boolean isAble(int rowNo) { // 놓여진 마지막 퀸
		for(int i=1;i<rowNo;i++) {
			// 같은 열에 두었는지
			if(col[rowNo] == col[i] || rowNo-i == Math.abs(col[rowNo]-col[i])) {
				return false;
			}

		}
		return true;
	}
}
