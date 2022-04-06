import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/3190
public class BOJ_3190_뱀 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		int K = Integer.parseInt(in.readLine());
		int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//우-하-좌-상(오른쪽 방향)

		int[][] board = new int[N+1][N+1];
		board[1][1] = -1;//뱀 처음 위치
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(in.readLine());
			board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}

		int L = Integer.parseInt(in.readLine());
		int prev = 0, nr, nc, d = 0, time = 1;
		int[] pos = {1,1};
		Deque<int[]> deque = new ArrayDeque<>();
		deque.offerFirst(pos);
		for (int l = 0; l < L; l++) {
			st = new StringTokenizer(in.readLine());
			int X = Integer.parseInt(st.nextToken());

			for (int x = prev + 1; x <= X; x++) {
				nr = deque.peekFirst()[0] + deltas[d][0];
				nc = deque.peekFirst()[1] + deltas[d][1];
				if (nr <= 0 || nr > N || nc <= 0 || nc > N || board[nr][nc] == -1) {
					System.out.println(x);
					return;
				} else if (board[nr][nc] == 0) {//빈 공간
					board[deque.peekLast()[0]][deque.pollLast()[1]] = 0;//꼬리쪽 비우기
				}
				board[nr][nc] = -1;//새 머리 표시
				deque.offerFirst(new int[]{nr, nc});//뱀 머리 추가
			}

			//방향 바꾸기
			if (st.nextToken().charAt(0) == 'D') d = (d + 1) % 4;
			else d = (d + 3) % 4;

			time = X;
			prev = X;
		}

		//끝날때까지 더 움직이다가 시간 출력
		while ((nr = deque.peekFirst()[0] + deltas[d][0]) > 0 && nr <= N && (nc = deque.peekFirst()[1] + deltas[d][1]) > 0 && nc <= N && board[nr][nc] != -1) {
			if (board[nr][nc] == 0) {//빈 공간
				board[deque.peekLast()[0]][deque.pollLast()[1]] = 0;//꼬리쪽 비우기
			}
			board[nr][nc] = -1;//새 머리 표시
			deque.offerFirst(new int[]{nr, nc});//뱀 머리 추가
			time++;
		}

		System.out.println(time+1);
	}
}
