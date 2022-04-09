import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17281_야구 {

	
	static int N;
	// 3아웃 체크
	static int out;
	// 이닝별 각 등번호 타자의 점수
	static int[][] arr;
	// 순열이 저장될 값 : 타자의 타순이 저장
	static int[] numbers;
	
	// 매 순열 별 완전탐색 시의 점수
	static int score;
	// 점수의 최댓값 저장할 변수
	static int ans;
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		arr = new int[N][9];
		
		StringTokenizer st;
		
		numbers = new int[9];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 순열
		perm(0, 0);
		// 결과값
		System.out.println(ans);
	}

	public static void perm(int cnt, int flag) {

		if (cnt == 9) {
			score = 0;
			
			// numbers[0] : 등번호가 1번인 선수는 무조건 4번타자여야 하기 때문에 1번인 선수가 4번타자일 경우에만 baseball메서즈 호출
			if(numbers[0] == 3) {
				baseball();
			}
			// 위 메서드 수행 후 점수를 현재 최댓값과 비교하여 최댓값 저장
			ans = Math.max(score,ans);
			return;
		}
		
		// 가지치기 : 만약 순열의 시작이 0이 아니면서 3도 아니면 : 0에는 무조건 4번타자만 걸러내게끔 한다.
		// 배열의 기본값이 0이기 때문에 완전한 가지치기는 불가능
		if(numbers[0] != 0 && numbers[0] != 3) {
			return;
		}
		
		// 순열부분
		for (int i = 0; i < 9; i++) {
			if ((flag & 1 << i) != 0) {
				continue;
			}
			numbers[cnt] = i;
			perm(cnt + 1, (flag | 1 << i));
			numbers[cnt] = 0;
		}

	}

	public static void baseball() {
		
		// 주자 저장할 배열
		int[] runner = new int[3];

		// 다음 타자 번호 저장할 변수(1번타자 ~ 9번타자)
		int nextHitter = 0;
		// 타자의 등번호를 저장할 변수
		int hitter = 0;
		// 타자번호에 맞는 선수 등번호 구하기
		for(int i=0;i<9;i++) {
			if(numbers[i] == nextHitter) {
				hitter = i;
				break;
			}
		}
		// 이닝 수만큼 반복
		for (int innings = 0; innings < N; innings++) {
			// 아웃 카운트 초기화
			out = 0;
			// 주자 초기화
			Arrays.fill(runner, 0);
			// 아웃 카운트가 3이 될 때까지 반복
			while (out < 3) {
				// swtich문 : 이닝별 각 등번호의 타자의 타구 결과
				switch (arr[innings][hitter]) {
				// 아웃
				case 0:
					out++;
					break;
				// 1루타
				case 1:
					for(int i=2;i>=0;i--) {
						// 이미 주자가 있는 경우
						if(runner[i] == 1) {
							// 3루에 있다면
							if(i+1 >= 3) {
								// 홈에 들어온 것이므로 점수를 1 올리고 베이스를 비운다.
								score++;
								runner[i] = 0;
							// 1, 2루에 있다면
							}else {
								// 각각 1루씩 진루시킨다.
								runner[i+1] = 1;
								runner[i] = 0;
							}
						}
					}
					// 위 반복을 끝내고 나면 1루는 무조건 비어있기 때문에 타구를 친 타자를 1루로 출루시킨다.
					runner[0] = 1;
					break;
				// 2루타 : 1루타 로직을 2루타로 바꿔서 반복
				case 2:
					for(int i=2;i>=0;i--) {
						if(runner[i] == 1) {
							if(i+2 >= 3) {
								score++;
								runner[i] = 0;
							}else {
								runner[i+2] = 1;
								runner[i] = 0;
							}
						}
					}
					runner[1] = 1;
					break;
				// 3루타
				case 3:
					for(int i=2;i>=0;i--) {
						if(runner[i] == 1) {
							if(i+3 >= 3) {
								score++;
								runner[i] = 0;
							}else {
								runner[i+3] = 1;
								runner[i] = 0;
							}
						}
					}
					runner[2] = 1;
					break;
				// 홈런
				case 4:
					score++;
					for(int i=0;i<3;i++) {
						if(runner[i] == 1) {
							score++;
							runner[i] = 0;
						}
					}
					break;
				}
				nextHitter++;
				if(nextHitter == 9) {
					nextHitter = 0;
				}
				// 타자번호에 맞는 선수 등번호 구하기
				for(int i=0;i<9;i++) {
					if(numbers[i] == nextHitter) {
						hitter = i;
						break;
					}
				}
			}
		}

	}

}
