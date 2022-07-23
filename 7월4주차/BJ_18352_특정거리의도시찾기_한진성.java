import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18352_특정거리의도시찾기 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(st.nextToken());
		
		int X = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        
		for(int i=0;i<M;i++) {
			
			st = new StringTokenizer(in.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			
			int to = Integer.parseInt(st.nextToken());
			
			list.get(from).add(to);
			
		}
		int distance[] = new int[N+1];
		
		Arrays.fill(distance, 99999999);
		
		distance[X] = 0;
		
		//bfs
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(X);
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			for(int i : list.get(temp)) {
				if(distance[i] == 99999999) {
					distance[i] = distance[temp]+1;
					queue.offer(i);
				}
				
			}
		}
		
		boolean flag = false;
		for(int i=1;i<=N;i++) {
			if(distance[i] == K) {
				System.out.println(i);
				flag = true;
			}
		}
		if(!flag) {
			System.out.println(-1);
		}
	}

}
