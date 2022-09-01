import java.io.*;
import java.util.*;

public class BOJ_3187_양치기꿍 {
	static int R,C,V,K;
	static char[][] map;
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for(int i=0;i<R;i++) {
			map[i] = in.readLine().toCharArray();
		}

		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				if(map[i][j] != 'x'){
					int[] vk = dfs(i,j);
					if(vk[0] >= vk[1]) V+=vk[0];
					else K +=vk[1];
				}
			}
		}

		System.out.println(K+" "+V);
	}

	private static int[] dfs(int i, int j) {
		int v=0,k=0;
		if(map[i][j] =='v') v++;
		else if(map[i][j]=='k') k++;
		map[i][j] = 'x';

		for(int d=0;d<4;d++){
			int ni = i+deltas[d][0];
			int nj = j+deltas[d][1];
			if(ni<0 || ni>=R || nj<0 || nj>=C || map[ni][nj]=='x' || map[ni][nj]=='#') continue;
			int[] tmp = dfs(ni,nj);
			v+=tmp[0];
			k+=tmp[1];
		}

		return new int[]{v,k};
	}
}
