import java.io.*;
import java.util.*;

public class BOJ_17070_파이프옮기기1 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int H = 0, V = 1, D = 2;

		int N = Integer.parseInt(in.readLine());
		int[][][] visited = new int[N][N][3];
		int[][] house = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[0][1][H] = 1;

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(i==0 && j<2) continue;
				if(house[i][j]==1) continue;
				if(i-1>=0 && j-1>=0 && house[i-1][j-1]!=1 && house[i-1][j]!=1 && house[i][j-1]!=1) {//대각선
					visited[i][j][D] = visited[i-1][j-1][H]+visited[i-1][j-1][V]+visited[i-1][j-1][D];
				}
				if(i-1>=0 && house[i-1][j]!=1) {//세로
					visited[i][j][V] = visited[i-1][j][V]+visited[i-1][j][D];
				}
				if(j-1>=0 && house[i][j-1]!=1) {//가로
					visited[i][j][H] = visited[i][j-1][H]+visited[i][j-1][D];
				}
			}
		}

		System.out.println(visited[N-1][N-1][H]+visited[N-1][N-1][V]+visited[N-1][N-1][D]);
	}

}
