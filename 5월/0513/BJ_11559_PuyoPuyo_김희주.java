import java.io.*;
import java.util.*;

public class BOJ_11559_PuyoPuyo {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[][] field = new char[12][6];
		for (int i = 0; i < 12; i++) {
			field[i] = in.readLine().toCharArray();
		}

		int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		Queue<Puyo> queue = new ArrayDeque<>();
		ArrayList<Puyo> list = new ArrayList<>();
		Puyo pos;
		int ni, nj;

		int count = 0;
		boolean isBump = true;
		boolean[][] visited;

		while (isBump) {
			isBump = false;
			visited = new boolean[12][6];
			for (int i = 11; i >= 0; i--) {
				for (int j = 0; j < 6; j++) {
					if (field[i][j] == '.' || visited[i][j]) continue;
					visited[i][j] = true;
					pos = new Puyo(i, j, field[i][j]);
					queue.offer(pos);
					list.add(pos);
					field[i][j] = '.';

					while (!queue.isEmpty()) {
						pos = queue.poll();

						for (int d = 0; d < 4; d++) {
							ni = pos.r + deltas[d][0];
							nj = pos.c + deltas[d][1];
							if (ni < 0 || ni >= 12 || nj < 0 || nj >= 6 || visited[ni][nj] || field[ni][nj] != pos.value) continue;
							queue.offer(new Puyo(ni, nj, field[ni][nj]));
							list.add(new Puyo(ni, nj, field[ni][nj]));
							field[ni][nj] = '.';
							visited[ni][nj] = true;
						}
					}
					if (list.size() >= 4) isBump = true;
					else {
						for (Puyo puyo : list) {
							field[puyo.r][puyo.c] = puyo.value;
						}
					}
					list.clear();
				}
			}

			for (int j = 0; j < 6; j++) {
				for(int i=11;i>=0;i--){
					if(field[i][j]=='.'){
						ni = i;
						while(--ni>=0 && field[ni][j]=='.');
						if(ni>=0){
							field[i][j] = field[ni][j];
							field[ni][j] = '.';
						}
					}
				}
			}


			if (isBump) count++;
		}

		System.out.println(count);
	}

	private static class Puyo {
		int r, c;
		char value;

		Puyo(int r, int c, char value) {
			this.r = r;
			this.c = c;
			this.value = value;
		}
	}
}
