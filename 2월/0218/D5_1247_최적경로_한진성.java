import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D5_1247_최적경로 {

	static int N;
	static Vector me, house;

	static List<Vector> cons;
	static int[] numbers;
	static int answer;
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input_1247.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());

			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			me = new Vector(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			house = new Vector(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			cons = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				cons.add(new Vector(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			numbers = new int[N];
			answer = Integer.MAX_VALUE;
			perm(0,0);
			
			System.out.printf("#%d %d\n",tc,answer);
			
		}

	}

	public static void perm(int cnt, int flag) {

		if (cnt == N) {
			
			// 초기 거리 (회사 - 첫번째 고객)
			int disX = Math.abs(me.X - cons.get(numbers[0]).X);
			int disY = Math.abs(me.Y - cons.get(numbers[0]).Y); 
			
			// 초기 거리 설정
			int sumdis = disX + disY;
			// 고객간의 거리
			for(int i=0;i<N-1;i++) {
				disX = Math.abs((cons.get(numbers[i]).X-cons.get(numbers[i+1]).X));
				disY = Math.abs((cons.get(numbers[i]).Y-cons.get(numbers[i+1]).Y));
				sumdis += disX + disY;
			}
			// 최종 거리(마지막 고객 - 집)
			disX = Math.abs(house.X - cons.get(numbers[N-1]).X);
			disY = Math.abs(house.Y - cons.get(numbers[N-1]).Y);
			sumdis += disX + disY;
			answer = Math.min(answer, sumdis);
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0) {
				continue;
			}
			numbers[cnt] = i;
			perm(cnt + 1, flag | 1 << i);
		}

	}

}

class Vector {

	int X;
	int Y;

	public Vector(int x, int y) {
		super();
		X = x;
		Y = y;
	}

}
