import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12761_돌다리 {
	
	static int A,B,N,M;
	static int[] arr;
	static int[] visited;
	static int answer;
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		
		A = Integer.parseInt(st.nextToken());
		
		B = Integer.parseInt(st.nextToken());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new int[100001];
		dir =  new int[]{1, -1, A, -A, B, -B};
		Arrays.fill(visited, 9999999);
		bfs();

		System.out.println(answer);
		
	}
	
	static int[] dir;
	
	static void bfs() {
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.add(new int[] {N,0});
		visited[N] = 0;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			if(temp[0] == M) {
				answer = temp[1];
				return;
			}
			for(int d=0;d<6;d++) {
				int dx = temp[0] + dir[d];
				if(dx < 0 || dx >= 100001 || visited[dx] <= temp[1]) {
					continue;
				}
				visited[dx] = temp[1];
				queue.add(new int[] {dx,temp[1]+1});
			}
			
			int dx = temp[0]*A;
			
			if(dx >= 0 && dx < 100001 && visited[dx] > temp[1]) {
				visited[dx] = temp[1];
				queue.add(new int[] {dx,temp[1]+1});
			}
			
			dx = temp[0]*B;
		
			if(dx >= 0 && dx < 100001 && visited[dx] > temp[1]) {
				visited[dx] = temp[1];
				queue.add(new int[] {dx,temp[1]+1});
			}

		}
		
		
	}

}
