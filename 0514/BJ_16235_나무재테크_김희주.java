import java.io.*;
import java.util.*;

public class BOJ_16235_나무재테크 {
	static int N, M, K;
	static int[][] A;
	static int[][] map;
	static Queue<Tree> dead = new ArrayDeque<>();
	static Queue<Tree> multiple5 = new ArrayDeque<>();
	static Deque<Tree> trees = new ArrayDeque<>();
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N + 1][N + 1];
		map = new int[N + 1][N + 1];

		for(int i=1;i<=N;i++){
			Arrays.fill(map[i],5);
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			trees.offerFirst(new Tree(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		for(int i=0;i<K;i++){
			season();
		}

		System.out.println(trees.size());
	}

	private static void season(){
		//봄
		Tree now;
		int size = trees.size();
		for(int i=0;i<size;i++){
			now = trees.poll();
			if(map[now.r][now.c]<now.age){
				//죽은거
				dead.offer(now);
			}else{
				//산거
				map[now.r][now.c] -= now.age;
				now.age++;
				trees.offerLast(now);
				if(now.age%5==0) multiple5.offer(now);
			}
		}

		//여름
		Tree tree;
		while(!dead.isEmpty()){
			tree = dead.poll();
			map[tree.r][tree.c] += tree.age/2;
		}

		//가을
		int nr,nc;
		while(!multiple5.isEmpty()){
			tree = multiple5.poll();
			for(int d=0;d<8;d++){
				nr = tree.r+deltas[d][0];
				nc = tree.c+deltas[d][1];
				if(nr<1||nr>N||nc<1||nc>N) continue;
				trees.offerFirst(new Tree(nr,nc,1));
			}
		}

		//겨울
		for(int i=1;i<=N;i++){
			for(int j=1;j<=N;j++){
				map[i][j] += A[i][j];
			}
		}

	}

	private static class Tree {
		int r, c, age;

		Tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}
	}
}
