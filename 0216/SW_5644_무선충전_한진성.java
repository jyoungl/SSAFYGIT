import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 모의_5644_무선충전 {
	// 총 충전량 저장 변수
	static int answer;
	// 매회 최대 충전량 저장 변수
	static int max;
	
	
	public static void max(Human A, Human B, List<BC> bcQ) {
		// 충전 가능 여부 비교하여 현재 저장 가능한 최댓값 저장
		int energyA = 0;
		int U = A.isEnergy.length;
		for (int i = 0; i < U; i++) {
			// AC별 충전량 저장 변수
			int energyB = 0;
			// A가 i번째 BC에서 충전가능하면
			if (A.isEnergy[i] == true) {
				// B도 같은 BC에 대해 충전 가능한지 확인
				// A, B가 같은 BC에 접속 가능한 경우
				if (B.isEnergy[i] == true) {
					energyA = bcQ.get(i).P / 2;
					energyB = energyA;
					max = Math.max(max, energyA+energyB);
				}
				energyA = 0;
				energyB = 0;
				// A와 B가 다른 BC에 접속 가능한 경우
				for (int j = 0; j < U; j++) {
					// 가능한 에너지 값중에 최댓값
					if (j != i && B.isEnergy[j] == true) {
						energyB = Math.max(bcQ.get(j).P,energyB);
					}
				
					energyA = bcQ.get(i).P;
					max = Math.max(max, energyA+energyB);
				}
			}else { // A가 i번째 BC에서 충전 불가능하면
				energyA = 0;
				for (int j = 0; j < U; j++) {
					// 가능한 에너지 값중에 최댓값
					if (B.isEnergy[j] == true) {
						energyB = Math.max(bcQ.get(j).P,energyB);
					}
				}
				max = Math.max(max, energyA+energyB);
			}

		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		System.setIn(new FileInputStream("input_5644.txt"));

		// 버퍼드리더로 값 읽어오기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 테케
		int T = Integer.parseInt(in.readLine());

		// X,Y좌표 바꿨기 때문에, 방향정보도 바뀔 필요가 있다.
		// 0:제자리, 1: 좌, 2: 하 3: 우 4: 상
		int[][] dir = { { 0, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

		// 테케만큼 반복
		for (int tc = 1; tc <= T; tc++) {
			// StringTokenizer로 값 읽어오기, 2번째 줄 저장
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			// 이동시간
			int M = Integer.parseInt(st.nextToken());

			// BC 개수 U로 네이밍 변경
			int U = Integer.parseInt(st.nextToken());

			// A, B 초기 위치 저장
			Human A = new Human(1, 1);
			Human B = new Human(10, 10);

			int[] moveA = new int[M];
			int[] moveB = new int[M];
			// A 이동 정보 저장
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			// B 이동 정보 저장
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}

			// BC 목록 저장
			List<BC> bcQ = new ArrayList<>();

			// BC 할당
			for (int i = 0; i < U; i++) {
				// BC정보 읽어오기
				st = new StringTokenizer(in.readLine(), " ");
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				// 한줄에다 다 적을 수 있지만 보기싫어서 나눔
				bcQ.add(new BC(y, x, c, p));
			}

			// A, B의 충전가능여부 저장할 배열
			A.isEnergy = new boolean[U];
			B.isEnergy = new boolean[U];

			// 현재 위치에서 충전가능한지 먼저 확인
			isEnegy(A, bcQ);
			isEnegy(B, bcQ);
////			 테스트, 여기까지는 잘됨
//			System.out.println(Arrays.toString(A.isEnergy));
//			System.out.println(Arrays.toString(B.isEnergy));	

			// 매회 최대 충전량 저장 변수 초기화
			max = 0;

			// 현재 자리에서 가능한 최대 충전량 구하기
			max(A, B, bcQ);

			// 총 충전량 저장 변수 초기화
			answer = max;
			// 여기까지 잘 됨
//			System.out.println(answer);
			
			// 이동 시간만큼 반복
			for (int i = 0; i < M; i++) {
				max = 0;
				// A 이동
				A.X = A.X + dir[moveA[i]][0];
				A.Y = A.Y + dir[moveA[i]][1];
//				System.out.println("T:"+i+" A:"+A.X+","+A.Y);
				// B 이동
				B.X = B.X + dir[moveB[i]][0];
				B.Y = B.Y + dir[moveB[i]][1];
//				System.out.println("T:"+i+" B:"+B.X+","+B.Y);
				
				// 현재 위치에서 충전 가능한지 여부 확인
				isEnegy(A, bcQ);
				isEnegy(B, bcQ);
//				System.out.println(Arrays.toString(A.isEnergy));
//				System.out.println(Arrays.toString(B.isEnergy));	
				// 현재 위치에서 가능한 충전량의 최댓값 구하기
				max(A,B,bcQ);
//				System.out.println("Max: "+ max);
				// 해당 최댓값 총 충전량에 더하기
				answer += max;
			}
			// ---- 출력
			System.out.printf("#%d %d\n",tc,answer);
		}

	}

	public static void isEnegy(Human human, List<BC> bcQ) {
		for (int i = 0, n = bcQ.size(); i < n; i++) {
			// A와 BC간의 거리 비교하여 충전 가능한 BC에대해 boolean값 저장
			if ((Math.abs(human.X - bcQ.get(i).X) + Math.abs(human.Y - bcQ.get(i).Y)) <= bcQ.get(i).C) {
				human.isEnergy[i] = true;
			}else {
				human.isEnergy[i] = false;
			}
		}

	}

}

class Human {
	int X;
	int Y;
	boolean[] isEnergy;

	public Human(int x, int y) {
		super();
		X = x;
		Y = y;
	}
}

class BC {
	// x좌표
	int X;
	// y좌표
	int Y;
	// 충전범위 - 구할 수 있으니까 스킵?
	int C;
	// 성능
	int P;

	public BC(int x, int y, int c, int p) {
		super();
		X = x;
		Y = y;
		C = c;
		P = p;
	}

}
