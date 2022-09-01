import java.io.*;
import java.util.*;

public class BOJ_2644_촌수계산 {
	static boolean[][] map;
	static int N,A,B,result;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		map = new boolean[N+1][N+1];

		int M = Integer.parseInt(in.readLine());
		int x,y;
		for(int i=0;i<M;i++){
			st = new StringTokenizer(in.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = true;
		}

		find(0,A);
		if(result!=0) System.out.println(result);
		else System.out.println(-1);
	}
	public static void find(int count, int now){
		if(result !=0 && result<count) return;
		if(map[now][B] || map[B][now]){
			result = count+1;
			return;
		}

		for(int i=1;i<=N;i++){
			if(map[now][i] && map[i][now]){
				map[now][i] = map[i][now] = false;
				find(count+1,i);
			}
		}

	}
}
