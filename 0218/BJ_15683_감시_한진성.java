import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


class CCTV{
	// X좌표
	int X;
	// Y좌표
	int Y;
	
	// CCTV 번호
	int num;
	
	public CCTV(int x, int y, int num) {
		super();
		X = x;
		Y = y;
		this.num = num;
	}
	
}


public class BOJ_15683_감시 {

	/*
	 * 1번 = 회전 4번 2번 = 회전 2번 3번 = 회전 4번 4번 = 회전 4번 5번 = 회전 0번
	 */
	
	static int N,M,arr[][],dir[][] ={ { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	static ArrayList<CCTV> list;
	static int[] numbers;
	static int answer;
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		
		list = new ArrayList<>();


		int cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] != 0 && arr[i][j] != 6) {
					list.add(new CCTV(i,j,arr[i][j]));
				}
			}
		}
		numbers = new int[list.size()]; 
		answer =Integer.MAX_VALUE;
		perm(0);
		System.out.println(answer);
		
	}
	
	
	// 중복순열의 변형 1~4까지 있을 수 있는 값을 구한다. 리스트의 개수만큼?
	public static void perm(int cnt) {
		
		
		// 기저조건
		if(cnt == list.size()) {
			// 순열이 좌라락 나온다.
			/*
			 * 0,0,0
			 * 0,0,1
			 * 0,0,2
			 * 0,0,3
			 * 0,1,0
			 * 0,1,1
			 * 0,1,2
			 * 0,1,3 ...
			 * 
			 * 0일때는 오른쪽
			 * 1일때는 왼쪽
			 * 2일때는 위쪽
			 * 3일때는 아랫쪽을 탐색한다.
			 * 
			 */
//			System.out.println(Arrays.toString(numbers));
			int[][] copy =  new int[N][M];
			for(int i=0;i<N;i++) {
				copy[i] = arr[i].clone();
			}
			

			for(int i=0,n=list.size();i<n;i++) {
				int x = list.get(i).X;
				int y = list.get(i).Y;
				int num = list.get(i).num;
				// CCTV를 만나면
				search(numbers[i], x, y, num, copy);
			}
			
			int count = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(copy[i][j] == 0) {
						count++;
					}
				}
			}
			answer = Math.min(answer, count);
			return;
		}
		
		
		// 유도파트
		for(int i=0;i<4;i++) {
			numbers[cnt] = i;
			perm(cnt+1);
		}
		
	}

	public static void search(int cctvNo, int x, int y, int cctvType, int[][] copy) {
		
		// CCTV의 탐색 범위에 따른 탐색
		switch(cctvType) {
		// 1번 CCTV
		case 1:
			// 1번일 경우 4번 회전 ( 탐색 방향은 우 좌 상 하)
			switch(cctvNo) {
			// 오른쪽 탐색
			case 0:
				detect(x, y, copy, 0);
				break;
			// 왼쪽 탐색
			case 1:
				detect(x, y, copy, 1);
				break;
			// 위쪽 탐색
			case 2:
				detect(x, y, copy, 2);
				break;
			// 아래쪽 탐색
			case 3:
				detect(x, y, copy, 3);
				break;				
			}
			break;
		case 2:
			// 2번일 경우 2가지 경우로 나누어 생각한다.
			switch(cctvNo) {
			// 좌우 탐색
			case 0:
			case 2:
				// 오른쪽 탐색
				detect(x,y,copy,0);
				// 왼쪽 탐색
				detect(x,y,copy,1);
				break;
			// 상하 탐색
			case 1:
			case 3:
				// 상
				detect(x,y,copy,2);
				// 하
				detect(x,y,copy,3);
				break;
			}
			break;
		case 3:
			// 3번일 경우 4가지 경우로 나누어 생각한다.
			switch(cctvNo) {
			// 우,상 탐색
			case 0:
				//우
				detect(x,y,copy,0);
				//상
				detect(x,y,copy,2);
				break;
			// 좌,하 탐색
			case 1:
				//좌
				detect(x,y,copy,1);
				//하
				detect(x,y,copy,3);
				break;
			// 상, 좌 탐색
			case 2: 
				//상
				detect(x,y,copy,2);
				//좌
				detect(x,y,copy,1);
				break;
			// 하, 우 탐색
			case 3:
				//하
				detect(x,y,copy,3);
				//우
				detect(x,y,copy,0);
				break;
			}
			break;
		// 4번일 경우 4가지 경우로 나누어 생각한다.
		case 4:
			switch(cctvNo) {
			// 우 상 좌
			case 0:
				//우
				detect(x,y,copy,0);
				//상
				detect(x,y,copy,2);
				//좌
				detect(x,y,copy,1);
				break;
			//좌 하 우
			case 1:
				//좌
				detect(x,y,copy,1);
				//하
				detect(x,y,copy,3);
				//우
				detect(x,y,copy,0);
				break;
			// 상 좌 하
			case 2:
				//상
				detect(x,y,copy,2);
				//좌
				detect(x,y,copy,1);
				//하
				detect(x,y,copy,3);
				break;
			// 하 우 상
			case 3:
				//하
				detect(x,y,copy,3);
				//우
				detect(x,y,copy,0);
				//상
				detect(x,y,copy,2);
				break;
			}
			break;
		// 5번일 경우, 회전 상관 없이 탐색한다.
		case 5:
			for(int i=0;i<4;i++) {
				detect(x,y,copy,i);
			}
		}
		
	}
	
	public static void detect(int x, int y, int[][] copy, int dirNo) {
		while(true) {
			int dx = x + dir[dirNo][0];
			int dy = y + dir[dirNo][1];
			if(dx < 0 || dx >= N || dy < 0 || dy >= M || copy[dx][dy] == 6) {
				break;
			}
			else if(copy[dx][dy] == 0) {
				copy[dx][dy] = -1;
			}
			x = dx;
			y = dy;
		}
	}
}


