import java.io.*;
import java.util.*;

public class BOJ_14499_주사위굴리기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] dice = {0,0,0,0,0,0};
		int[] diceIdx = {0,1,2,3,4,5};
		int[][] way = {{3,1,0,5,4,2},//동
						{2,1,5,0,4,3},//서
						{4,0,2,3,5,1},//북
						{1,5,2,3,0,4}};//남

		int up, down; //윗면,아랫면 인덱스
		int[][] deltas = {{0,1},{0,-1},{-1,0},{1,0}};//동-서-북-남

		int[][] map = new int[N][M];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(in.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(in.readLine());
		for(int k=0;k<K;k++){
			int d = Integer.parseInt(st.nextToken())-1;
			X += deltas[d][1];
			Y += deltas[d][0];
			if(X<0 || X>=M || Y<0 || Y>=N){
				X -= deltas[d][1];
				Y -= deltas[d][0];
				continue;
			}

			int[] next = new int[6];
			for(int i=0;i<6;i++) next[i] = diceIdx[way[d][i]];
			diceIdx = next;
			up = diceIdx[0];
			down = diceIdx[5];
			if(map[Y][X]==0) map[Y][X] = dice[down];
			else {
				dice[down] = map[Y][X];
				map[Y][X] = 0;
			}
			sb.append(dice[up]).append('\n');
		}
		System.out.print(sb);

	}
}
