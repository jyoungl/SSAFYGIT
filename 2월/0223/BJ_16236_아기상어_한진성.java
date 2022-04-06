import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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

class Distance implements Comparable<Distance> {
	int x;
	int y;
	int body;
	int dist;
	public Distance(int x, int y, int body) {
		super();
		this.x = x;
		this.y = y;
		this.body = body;
	}
	public Distance(int x, int y, int body, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.body = body;
		this.dist = dist;
	}
	@Override
	public int compareTo(Distance o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

public class BOJ_16236_아기상어 {

	static int N;
	static int[][] arr;
	static List<Distance> list;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int min;
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		arr = new int[N + 1][N + 1];

		list = new ArrayList<>();
		StringTokenizer st;

		Distance shark = null;
		// 배열에 값 할당, 초기에 상어가 먹을 수 있는 물고기의 위치 리스트에 저장하기, 상어 위치 저장하기
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				// 물고기 위치 저장 상어크기가 2이므로
				if (arr[i][j] == 1) {
					list.add(new Distance(i, j, arr[i][j]));
				}
				// 상어 위치 저장
				if (arr[i][j] == 9) {
					shark = new Distance(i, j, 2);
				}
			}
		}
		
		// 먹을 수 있는 먹이가 없을 때
		if (list.size() == 0) {
			System.out.println(0);
			return;
		}
		int answer =0;
		int cnt = 0;
	
		
		while (true) {
			Distance minfish = null;

			min = Integer.MAX_VALUE;
			// 리스트에 저장한 물고기 개수만큼 반복
			for (int i = 0, n = list.size(); i < n; i++) {
				// 각 물고기별 최단거리
				Distance temp = bfs(shark, list.get(i), new boolean[N+1][N+1]);
				// 최단거리가 0이면 먹을 수 없다
				if(temp.dist == 0) {
					continue;
				}
				
				// 가장 가까운 물고기 구하기, 거리가 같을경우 위쪽, 왼쪽 순으로 추가비교
				if(temp.dist < min) {
					min = temp.dist;
					minfish = temp;
				}else if(temp.dist == min) {
					if(temp.x < minfish.x) {
						min = temp.dist;
						minfish = temp;
					}else if(temp.x == minfish.x) {
						if(temp.y < minfish.y) {
							min = temp.dist;
							minfish = temp;
						}
					}
				}
			}
			
			// 먹을 수 있는 물고기가 없다면 엄마부르기
			if(minfish == null) {
				System.out.println(answer);
				return;
			}
			
			// 최단 거리 물고기 위치로 이동
			answer += minfish.dist;
			arr[shark.x][shark.y] = 0;
			arr[minfish.x][minfish.y] = 9;
			shark.x = minfish.x;
			shark.y = minfish.y;
			
			// 물고기 먹기
			cnt++;
			if(cnt == shark.body) {
				shark.body++;
				cnt = 0;
			}
			
			// 리스트 초기화 (먹을 수 있는 물고기 목록)
			list = new ArrayList<>();
			
			// 배열 탐색해서 먹을 수 있는 물고기 리스트에 저장
			for(int i =1 ;i<=N;i++) {
//				System.out.println(Arrays.toString(arr[i]));
				for(int j=1;j<=N;j++) {
					if(arr[i][j] != 0 && arr[i][j] < shark.body) {
						list.add(new Distance(i,j,arr[i][j]));
					}
				}
			}
		}

	}

	static Distance bfs(Distance shark, Distance fish, boolean[][] visited) {
		
		Queue<Distance> queue = new LinkedList<Distance>();
		
		int x;
		int y;
		
		queue.add(new Distance(shark.x,shark.y, shark.body));
		
		visited[shark.x][shark.y] = true;
		
		int sharkBody = shark.body;

		// 최단거리 구하기
		while(!queue.isEmpty()) {
			
			Distance point = queue.poll();
			x = point.x;
			y = point.y;

			if(x == fish.x && y == fish.y) {
				return point;
			}

			for(int d=0;d<4;d++) {
				int dx = x + dir[d][0];
				int dy = y + dir[d][1];
				if(dx > 0&& dx<= N && dy > 0 && dy <= N) {
					if(sharkBody >= arr[dx][dy] && !visited[dx][dy]) {
						visited[dx][dy] = true;
						queue.offer(new Distance(dx, dy, sharkBody,point.dist+1));
					}
				}
			}
		}
		
		// 경로가 없는 경우
		return new Distance(0,0,0);
	}
}
