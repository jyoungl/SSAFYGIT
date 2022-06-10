import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1205_등수구하기 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());

		int score = Integer.parseInt(st.nextToken());

		int P = Integer.parseInt(st.nextToken());

		if (N == 0) {
			System.out.println(1);
			return;
		}

		int cnt = 1;
		st = new StringTokenizer(in.readLine());
		int rankscore[] = new int[P];
		
		Arrays.fill(rankscore, -1);

		for (int i = 0; i < N; i++) {
			rankscore[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {

			if (score > rankscore[i]) {
				System.out.println(cnt);
				return;

			}else if(score == rankscore[i]) {
				boolean check = false;

				for (int j = i; j < P; j++) {
					if (rankscore[j] != rankscore[i]) {
						check = true;
					}
				}

				if (check) {
					System.out.println(cnt);
					return;
				}
			}

			cnt++;

		}
		
		if(N < P) {
			System.out.println(cnt);
			return;
		}
		
		System.out.println(-1);

	}

}
