import java.io.*;
import java.util.*;

public class BOJ_2667_단지번호붙이기 {
	static int N;
	static int[][] houses;
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		houses = new int[N][N];

		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < N; j++) {
				houses[i][j] = line.charAt(j) - '0';
			}
		}

		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (houses[i][j] == 1) result.add(bfs(new House(i,j)));
			}
		}

		Collections.sort(result);
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append("\n");

		for(int i=0;i<result.size();i++){
			sb.append(result.get(i)).append("\n");
		}

		System.out.print(sb);
	}

	private static int bfs(House house) {
		Queue<House> queue = new LinkedList<>();
		queue.offer(house);

		houses[house.y][house.x] = 0;
		int cnt = 1;

		while(!queue.isEmpty()){
			house = queue.poll();

			for(int d=0;d<4;d++){
				int ni = house.y+deltas[d][0];
				int nj = house.x+deltas[d][1];
				if(ni>=0 && ni<N && nj>=0 && nj<N && houses[ni][nj]==1){
					queue.offer(new House(ni,nj));
					houses[ni][nj] = 0;
					++cnt;
				}
			}
		}
		return cnt;
	}

	static class House {
		int x, y;

		House(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}
}
