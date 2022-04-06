import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 	거리
	|x-x1| + |y-y2|

	거리가 같다면 가장 왼쪽

	한 번 이동시마다 1초씩 증가
	배열을 탐색하며 상어의 크기보다 작은 물고기들을 리스트에 넣는다 집어넣는 값은 좌표

	리스트에서 하나씩 꺼내며 거리가 가장 짧은 좌표를 구한다. ( 이 때 먹을 수 있는지 없는지도 판단해야겠다)

	해당 위치로 이동하고 거리만큼 시간을 더해준다.

	위 내용을 반복하려고 했지만 안되네 자기보다 큰 물고기는 못지나가기 때문에 거리를 계산하지 말고 움직여야할듯.... 이거 어케하지? -> 찾아보니까 BFS 탐색을 통하면 최단거리를 구할 수 있다. 벽부수고이동하기 참고.
*/

class Distance2 implements Comparable<Distance2> {
	int x;
	int y;
	int body;
	int dist;
	public Distance2(int x, int y, int body) {
		super();
		this.x = x;
		this.y = y;
		this.body = body;
	}
	public Distance2(int x, int y, int body, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.body = body;
		this.dist = dist;
	}
	@Override
	public int compareTo(Distance2 o) {
		if(this.dist == o.dist) {
			if(this.x == o.x) {
				return Integer.compare(this.y, o.y);
			}
			return Integer.compare(this.x, o.x);
		}
		return Integer.compare(this.dist, dist);
	}

}

// 우선순위 큐를 사용해보자
public class BOJ_16236_아기상어2 {

	static int N;
	static int[][] arr;
	static List<Distance2> list;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int min;
	static int answer;
	static int cnt;
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		arr = new int[N + 1][N + 1];

		list = new ArrayList<>();
		StringTokenizer st;

		Distance2 shark = null;
		// 배열에 값 할당, 초기에 상어가 먹을 수 있는 값의 위치 저장하기.
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					shark = new Distance2(i, j, 2);
				}
			}
		}
		
		bfs(shark, new boolean[N+1][N+1]);

		System.out.println(answer);
	}

	static void bfs(Distance2 shark, boolean[][] visited) {
		
		Queue<Distance2> queue = new LinkedList<Distance2>();
		
		int x;
		int y;
		
		queue.add(new Distance2(shark.x,shark.y, shark.body));
		
		visited[shark.x][shark.y] = true;
		
		int sharkBody = shark.body;
		
		PriorityQueue<Distance2> pq = new PriorityQueue<>();
		
		while(!queue.isEmpty()) {
			
			Distance2 point = queue.poll();
			x = point.x;
			y = point.y;
			
			for(int d=0;d<4;d++) {
				int dx = x + dir[d][0];
				int dy = y + dir[d][1];
				if(dx > 0 && dx<= N && dy > 0 && dy <= N) {
					if(sharkBody >= arr[dx][dy] && !visited[dx][dy]) {
						visited[dx][dy] = true;
						queue.offer(new Distance2(dx, dy, sharkBody,point.dist+1));
						if(arr[dx][dy] != 0 && arr[dx][dy] < sharkBody) {
							pq.add(new Distance2(dx,dy,0,point.dist+1));
						}
					}
				}
			}
		}
		
		if(pq.isEmpty()) {
			return;
		}
		
		Distance2 temp = pq.poll();
		
//		System.out.println(temp.dist);
		answer += temp.dist;
		arr[shark.x][shark.y] = 0;
		arr[temp.x][temp.y] = 9;
		shark.x = temp.x;
		shark.y = temp.y;
//		for(int i=1;i<=N;i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
//		System.out.println("=============");
		if(++cnt == shark.body) {
			cnt = 0;
			shark.body++;
		}
		
		bfs(shark,new boolean[N+1][N+1]);
	}
}
