import java.io.*;
import java.util.*;

public class BOJ_16173_점프왕쩰리 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		StringTokenizer st;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[]{0,0,map[0][0]});
		boolean[][] visited = new boolean[N][N];
		visited[0][0] = true;
		int[] pos;
		while(!queue.isEmpty()){
			pos = queue.poll();
			if(pos[2]==-1){
				System.out.println("HaruHaru");
				return;
			}
			if(pos[0]+pos[2]<N && !visited[pos[0]+pos[2]][pos[1]]){
				visited[pos[0]+pos[2]][pos[1]] = true;
				queue.offer(new int[]{pos[0]+pos[2],pos[1],map[pos[0]+pos[2]][pos[1]]});
			}
			if(pos[1]+pos[2]<N && !visited[pos[0]][pos[1]+pos[2]]){
				visited[pos[0]][pos[1]+pos[2]] = true;
				queue.offer(new int[]{pos[0],pos[1]+pos[2],map[pos[0]][pos[1]+pos[2]]});
			}
		}

		System.out.println("Hing");
	}
}
