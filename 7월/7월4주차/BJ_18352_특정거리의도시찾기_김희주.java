import java.io.*;
import java.util.*;

public class BOJ_18352_특정거리의도시찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		Node[] head = new Node[N+1];

		int from,to;
		for(int i=0;i<M;i++){
			st = new StringTokenizer(in.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			head[from] = new Node(to,head[from]);
		}

		boolean[] visited = new boolean[N+1];
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[]{X,0});

		int[] now;
		visited[X] = true;
		ArrayList<Integer> list = new ArrayList<>();
		while(!queue.isEmpty()){
			now = queue.poll();
			if(now[1]==K){
				list.add(now[0]);
			}else if(now[1]>K){
				break;
			}

			if(head[now[0]]==null) continue;

			for(Node link = head[now[0]];link != null;link = link.link){
				if(visited[link.num]) continue;
				queue.offer(new int[]{link.num,now[1]+1});
				visited[link.num] = true;
			}
		}

		if(list.size()==0){
			System.out.println(-1);
			return;
		}

		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<list.size();i++){
			sb.append(list.get(i)).append('\n');
		}
		System.out.print(sb);
	}

	private static class Node {
		int num;
		Node link;
		Node(int num, Node link){
			this.num = num;
			this.link = link;
		}
	}
}
