import java.io.*;
import java.util.*;

public class BOJ_14503_로봇청소기 {
	static int R,C;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());
		int[] robot = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
		int[][] place = new int[R][C];

		for(int r=0;r<R;r++){
			st = new StringTokenizer(in.readLine());
			for(int c=0;c<C;c++){
				place[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;

		outer:while(true){
			int r = robot[0];
			int c=  robot[1];
			int d = robot[2];

			if(place[r][c]==0){
				place[r][c] = -1;//청소
				++result;
			}

			int nr,nc;
			for(int i=1,nd=(d+4-i)%4;i<=4;i++,nd=(d+4-i)%4){
				nr = r+deltas[nd][0];
				nc = c+deltas[nd][1];
				if(isIn(nr,nc) && place[nr][nc]==0){
					robot = new int[]{nr,nc,nd};
					continue outer;
				}
			}

			nr = r+deltas[(d+2)%4][0];
			nc = c+deltas[(d+2)%4][1];
			if(!isIn(nr,nc) || place[nr][nc]==1) break;

			robot = new int[]{nr,nc,d};

		}
		System.out.println(result);

	}


	static private boolean isIn(int r, int c){
		return r>=0 && r<R && c>=0 && c<C;
	}
}
