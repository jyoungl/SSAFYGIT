import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17136_색종이붙이기 {
	static int[][] paper = new int[10][10];
	static ArrayList<int[]> one = new ArrayList<>();
	static int MIN = Integer.MAX_VALUE;
	static int[] limit = new int[5];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 10; j++) {
				if ((paper[i][j] = Integer.parseInt(st.nextToken())) == 1) one.add(new int[]{i, j});
			}
		}

		pick(0, 0,one.size());

		if(MIN ==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(MIN);
	}

	private static int[][] copy(int[][] origin) {
		int[][] next = new int[10][10];
		for (int i = 0; i < 10; i++) {
			next[i] = origin[i].clone();
		}
		return next;
	}

	private static void pick(int idx, int cnt, int remain) {
		if(cnt>MIN) return;
		if(idx==one.size()){
			if(remain==0 && cnt<MIN) MIN = cnt;
			return;
		}

		int[][] next = null;
		int[] pos = one.get(idx);
		if(paper[pos[0]][pos[1]]==2) {//이 자리가 이미 뽑힌자리라면
			pick(idx+1,cnt,remain);
			return;
		}

		outer:
		for (int d = 4; d >= 1; d--) {
			next = copy(paper);
			if(limit[d]==5) continue;
			limit[d]++;
			for (int i = 0; i <= d; i++) {
				for (int j = 0; j <= d; j++) {
					if(i==0 && j==0) continue;
					int nr = pos[0] + i;
					int nc = pos[1] + j;
					if (nr < 0 || nr >= 10 || nc < 0 || nc >= 10 || paper[nr][nc] != 1) {
						limit[d]--;
						paper = copy(next);
						continue outer;
					}
					paper[nr][nc] = 2;
				}
			}

			pick(idx + 1, cnt + 1,remain-(d+1)*(d+1));//4~1
			paper = copy(next);
			limit[d]--;
		}

		if(limit[0]==5) return;

		limit[0]++;
		paper[pos[0]][pos[1]] = 2;
		pick(idx + 1, cnt + 1,remain-1);
		paper[pos[0]][pos[1]] = 1;
		limit[0]--;
	}


}
