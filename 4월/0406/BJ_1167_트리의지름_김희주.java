import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/1167
//아무 점(1)에서 시작해서, 그 점에서 가장 먼 점(2)을 구한다.
//(2)번 점과 가장 먼 점(3)을 다시 구해서, (2)와 (3)의 거리가 트리의 지름이다.
public class BOJ_1167_트리의지름 {
	static ArrayList<int[]>[] list;
	static int N,MAX;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		list = new ArrayList[N+1];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			list[n] = new ArrayList<>();

			int to;
			while((to=Integer.parseInt(st.nextToken()))!=-1){
				list[n].add(new int[]{to,Integer.parseInt(st.nextToken())});
			}
		}

		bfs(bfs(1));
		System.out.println(MAX);

	}

	private static int bfs(int idx) {
		int[] visited = new int[N+1];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(idx);

		int n;
		while(!queue.isEmpty()){
			n = queue.poll();
			for(int[] li:list[n]){
				if(visited[li[0]]!=0 || li[0]==idx) continue;
				visited[li[0]] = li[1]+visited[n];
				queue.offer(li[0]);
			}
		}

		int res = 1;
		for(int i=2;i<=N;i++) if(visited[res]<visited[i]) res = i;

		MAX = visited[res];
		return res;
	}

}
