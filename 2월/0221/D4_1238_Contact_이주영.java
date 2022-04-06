import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D4_1238_Contact_이주영 {
	//bfs 사용해야함
	static int N;
	static int start;
	static int[][] arr;
	static int max;
	
	public static int bfs(int pot) {
		Queue<Integer> que = new LinkedList<>();
		int[] visited = new int[101];
		int res = 0;
		
		que.offer(pot);
		visited[pot] = 1;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			for(int i=1;i<101;i++) {
				if(visited[i] == 0 && arr[now][i] != 0) {
					visited[i] = visited[now] + 1;
					que.offer(i);
				}
				
			}
			max = visited[now];
		}
		
		for(int i=1;i<101;i++) {
			if(max == visited[i])
				res = res>i ? res : i;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=10;tc++) {
			N = in.nextInt();
			start = in.nextInt();
			max = 0;
			arr = new int[101][101];
			
			for(int i=0;i<N/2;i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				
				arr[x][y] = 1;
			}
			
			int res = bfs(start);
			sb.append("#"+tc+" "+res+"\n");
		}
		System.out.println(sb);
	}

}
