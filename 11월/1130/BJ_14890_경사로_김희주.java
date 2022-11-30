import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14890_경사로 {
	static boolean[][] visited;
	static int[][] map;
	static int N,L;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		//입력
		map = new int[N][N];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 2*N;

		visited = new boolean[N][N];
		for(int i=0;i<N;i++){
			int prev = map[i][0];
			for(int j=1;j<N;j++){
				if(prev == map[i][j]) continue;
				if((Math.abs(prev - map[i][j]) > 1) ||
					(prev > map[i][j] && !check(i,j,true, true)) || //내리막인데 경사로 놓을 수 없을때
					(prev < map[i][j] && !check(i,j-1,false, true))) //오르막인데 경사로 놓을 수 없을때
				{
					count--;
					break;
				}
				if(prev > map[i][j]) j += L-1;
				prev = map[i][j];
			}
		}

		visited = new boolean[N][N];
		for(int i=0;i<N;i++){
			int prev = map[0][i];
			for(int j=1;j<N;j++){
				if(prev == map[j][i]) continue;
				if((Math.abs(prev - map[j][i]) > 1)
					|| (prev > map[j][i] && !check(j,i,true, false)) //내리막인데 경사로 놓을 수 없을때
					|| (prev < map[j][i] && !check(j-1,i,false, false))) //오르막인데 경사로 놓을 수 없을때
				{
					count--;
					break;
				}
				if(prev > map[j][i])j += L-1;
				prev = map[j][i];
			}
		}

		System.out.println(count);
	}
	public static boolean check(int i, int j, boolean plus, boolean col){
		int num = map[i][j];
		int mul = plus?1:-1;
		if(col){
			if(j + L*mul + 1 < 0 || j + L*mul > N) return false;
			for(int k=j;k!=j+L*mul; k+=mul){
				if(num != map[i][k] || visited[i][k]) return false;
				visited[i][k] = true;
			}
		}else{
			if(i + L*mul + 1 < 0 || i + L*mul > N) return false;
			for(int k=i;k!=i+L*mul; k+=mul){
				if(num != map[k][j] || visited[k][j]) return false;
				visited[k][j] = true;
			}
		}

		return true;
	}
}
