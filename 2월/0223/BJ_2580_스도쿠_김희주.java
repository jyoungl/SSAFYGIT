import java.io.*;
import java.util.*;

public class BOJ_2580_스도쿠 {
	static int[][] sudoku = new int[9][9];
	static ArrayList<int[]> zero = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
				if (sudoku[i][j] == 0) zero.add(new int[]{i, j});
			}
		}

		solve(0);

		System.out.print(sb);
	}

	private static boolean solve(int cnt) {
		if (cnt == zero.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(sudoku[i][j]).append(" ");
				}
				sb.append("\n");
			}
			return true;
		}

		for (int i = 1; i <= 9; i++) {
			sudoku[zero.get(cnt)[0]][zero.get(cnt)[1]] = i;
			if (isAvailable(zero.get(cnt)[0], zero.get(cnt)[1]) && solve(cnt + 1)) return true;
			sudoku[zero.get(cnt)[0]][zero.get(cnt)[1]] = 0;
		}

		return false;
	}


	private static boolean isAvailable(int i, int j) {
		int now = sudoku[i][j];
		for (int k = 0; k < 9; k++) {
			if (k != j && now == sudoku[i][k]) return false;
			if (k != i && now == sudoku[k][j]) return false;
		}

		for (int fi = (i / 3) * 3, k = fi; k < fi + 3; k++) {
			for (int fj = (j / 3) * 3, l = fj; l < fj + 3; l++) {
				if(k==i && l==j) continue;
				if (now == sudoku[k][l]) return false;
			}
		}

		return true;
	}
}
