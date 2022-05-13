import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_11559_puyopuyo_이주영 {
	static int w=12,h=6;
	static char[][] puyo;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static boolean[][] visited;
	static int cnt = 0;
	//4개 붙어있는지 확인
	public static boolean check(int x, int y, char c) {	
		visited[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int dx = x + dr[i];
			int dy = y + dc[i];
			
			if(dx>=0 && dy>=0 && dx<w && dy<h 
					&& !visited[dx][dy] && puyo[dx][dy] == c) {
				cnt++;
				check(dx,dy,c);
			}
		}
		
		if(cnt >= 4) {
			return true;
		}
		return false;
	}
	
	public static void bfs(int x, int y, char c) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x,y});
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			
			for(int d=0;d<4;d++) {
				int dx = now[0] + dr[d];
				int dy = now[1] + dc[d];
				
				if(dx>=0 && dy>=0 && dx<w && dy<h 
						&& visited[dx][dy] && puyo[dx][dy] == c) {
					puyo[dx][dy] = '.';
					que.add(new int[] {dx,dy});
				}
			}
		}
	}
	
	//남은 블록 밑으로
	public static boolean move(boolean b) {
		for(int i=w-1;i>=1;i--) {
			for(int j=h-1;j>=0;j--) {
				if(puyo[i][j] == '.' && puyo[i-1][j] != '.') {
					b = true;
					puyo[i][j] = puyo[i-1][j];
					puyo[i-1][j] = '.';
				}
			}
		}
		
		return b;
	}
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 puyo = new char[w][h];
		 int res = 0;
		 for(int i=0;i<w;i++) {
			 char[] ch = br.readLine().toCharArray();
			 for(int j=0;j<h;j++) {
				 puyo[i][j] = ch[j];
			 }
		 }
		 
		 while(true) {
			 visited = new boolean[w][h];
			 boolean b = false;
			 
			 for(int i=0;i<w;i++) {
				 for(int j=0;j<h;j++) {
					 if(!visited[i][j] && puyo[i][j] != '.') {
						 cnt = 1;
						 if(check(i,j,puyo[i][j])) {
							 b = true;
							 bfs(i,j,puyo[i][j]);
						 }
					 }
				 }
			 }
			 
			 if(b)
				 res++;
			 else
				 break;
			 
			 //아래로 내림
			 while(true) {
				 boolean boo = false;
				 boo = move(boo);
				 
				 if(!boo) {
					 break;
				 }
			 }
		 }
		 
		 System.out.println(res);
	}

}
