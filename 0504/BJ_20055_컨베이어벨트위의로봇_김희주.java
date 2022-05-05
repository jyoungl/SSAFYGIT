import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트위의로봇 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int N2 = N << 1;
		int K = Integer.parseInt(st.nextToken());
		Belt[] A = new Belt[N2];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N2; i++) {
			A[i] = new Belt(false, Integer.parseInt(st.nextToken()));
		}

		int start = 0;
		int end = N - 1;
		int zero = 0;

		for (int step = 1; ; step++) {
			//돌리고->start, end값 변경. end에 있던 로봇 없애기
			start = (start + N2 - 1) % N2;
			A[end].robot = false;
			end = (end + N2 - 1) % N2;

			//end-1부터 start까지 거꾸로 탐색하면서 로봇이 있으면 그 다음 칸으로 이동시키기.
			//새로 0이 만들어졌다면 +하기
			//새 end값에 로봇 무조건 사라짐
			A[end].robot = false;
			for (int k = 1, i = (end + N2 - 1) % N2, ni = end; k < N; k++,  ni = i, i = (i + N2 - 1) % N2) {
				if (A[i].robot && !A[ni].robot && A[ni].durability > 0) {
					A[i].robot = false;
					A[ni].robot = true;
					if (--A[ni].durability == 0) zero++;
				}
			}

			//올리고 -> start 내구성-1하고 로봇올리기
			if (A[start].durability > 0) {
				A[start].robot = true;
				if (--A[start].durability == 0) zero++;
			}

			//0개수 체크하기(K이상이면 끝)
			if (zero >= K) {
				System.out.println(step);
				break;
			}
		}

	}

	private static class Belt {
		boolean robot;
		int durability;

		Belt(boolean robot, int durability) {
			this.robot = robot;
			this.durability = durability;
		}
	}
}
