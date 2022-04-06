import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_10026_적록색약_이주영 {
	static int N;
	static char[][] color;
	static char[][] ncolor;
	static boolean[][] check;
	static int[] dr = {1, -1, 0, 0}; //아래, 위, 오른쪽, 왼쪽
	static int[] dc = {0, 0, 1, -1};
	
	public static void bfs(int x, int y, char c, char[][] color) {
		Queue<Integer> que = new LinkedList<>();
		Queue<Integer> que2 = new LinkedList<>();
		que.add(x);
		que2.add(y);
		check[x][y] = true;
		
		while(!que.isEmpty()) {
			int da = que.poll();
			int db = que2.poll();
			
			for(int k = 0; k < 4;k++) {
		        int nowx = da + dr[k];
		        int nowy = db + dc[k];
		        
				if(nowx>=0 && nowy>=0 && nowx<N && nowy<N && color[nowx][nowy]==c && !check[nowx][nowy]) {
					check[nowx][nowy] = true;
					que.add(nowx);
					que2.add(nowy);
				}
			}
		}

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		N = Integer.parseInt(br.readLine());
		color = new char[N][N];
		check = new boolean[N][N];
		ncolor = new char[N][N];
		
		for(int i=0;i<N;i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				color[i][j] = ch[j];
				if(ch[j] == 'G')
					ncolor[i][j] = 'R';
				else
					ncolor[i][j] = ch[j];
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!check[i][j]) {
					bfs(i,j,color[i][j], color);
					cnt++;
				}
			}
		}
		
		check = new boolean[N][N];
		int cnt2 = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!check[i][j]) {
					bfs(i,j,ncolor[i][j], ncolor);
					cnt2++;
				}
			}
		}
		System.out.printf("%d %d",cnt, cnt2);
	}

}
