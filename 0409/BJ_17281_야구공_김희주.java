import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17281_야구공 {
	static int[][] team;
	static int N;
	static int[] order;
	static int MAX = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		team = new int[N][9];
		order = new int[9];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 9; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		pick(0, 0);
		System.out.println(MAX);
	}

	private static void pick(int cnt, int flag) {
		if (cnt == 9) {
			game();
			return;
		}

		if (cnt == 3) cnt++;

		for (int i = 1; i < 9; i++) {//0번 이미 뽑힌 상태(4순서로)
			if ((flag & 1 << i) != 0) continue;
			order[cnt] = i;
			pick(cnt + 1, flag | 1 << i);
		}
	}

	private static void game() {
		int score = 0;
		int out = 0;
		boolean[] base = new boolean[4];
		int n = 0;

		for (int i = 0; n < N; i = (i+1)%9) {
			int tmpS = team[n][order[i]];
			if(tmpS==0) {
				if(++out==3) {
					n++;
					out = 0;
					base = new boolean[4];
				}
				continue;
			}

			for(int j=3;j>0;j--){
				if(j+tmpS >= 4 && base[j]) score++;
				base[j] = j-tmpS>=0 && base[j-tmpS];
			}
			if(tmpS<4) base[tmpS] = true;
			else score++;

		}

		MAX = Math.max(MAX, score);

	}
}
