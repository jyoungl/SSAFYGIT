import java.io.*;
import java.util.*;

public class BOJ_17070_파이프옮기기1 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int H = 0, V = 1, D = 2;

		int N = Integer.parseInt(in.readLine());
		int[][] house = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
				if (house[i][j] == 1) house[i][j] = -1;
			}
		}

		if(house[N-1][N-1]==-1) {
			System.out.println(0);
			return;
		}

		Pipe pipe = new Pipe(0, 1, H);
		house[0][1] = 1;

		Queue<Pipe> queue = new LinkedList<>();
		queue.offer(pipe);

		while (!queue.isEmpty()) {
			pipe = queue.poll();
			int way = pipe.way;
			if(pipe.r==N-1 && pipe.c==N-1) house[N-1][N-1]++;

			for (int i = 0; i < 3; i++) {
				if (way == H && i == V) continue;
				else if (way == V && i == H) continue;
				int nr,nc;
				if (i == H && (nc = pipe.c + 1) < N && house[pipe.r][nc] != -1) {
					queue.offer(new Pipe(pipe.r, nc, H));
				}
				if (i == V && (nr = pipe.r + 1) < N && house[nr][pipe.c] != -1) {
					queue.offer(new Pipe(nr, pipe.c, V));
				}
				if (i == D && (nr = pipe.r + 1) < N && (nc = pipe.c + 1) < N
						&& house[nr][pipe.c] != -1 && house[pipe.r][nc] != -1 && house[nr][nc] != -1) {
					queue.offer(new Pipe(nr,nc,D));
				}

			}

		}

		System.out.println(house[N-1][N-1]==-1?0:house[N-1][N-1]);
	}

	private static class Pipe {
		int r, c;
		int way;

		Pipe(int r, int c, int way) {
			this.r = r;
			this.c = c;
			this.way = way;
		}
	}
}
