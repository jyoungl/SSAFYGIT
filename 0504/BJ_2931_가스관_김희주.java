import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2931_가스관 {
	static int[][] map;
	static boolean[][] visited;
	static int[][] block = {
			{1,4,5,7},//위
			{2,3,5,7},//아래
			{1,2,6,7},//왼쪽
			{3,4,6,7}//오른쪽
	};
	//파이프1234 꺾이는 방향
	static int[][] turn = {{3,-1,1,-1},{-1,3,0,-1},{-1,2,-1,0},{2,-1,-1,1}};
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	static int R, C;
	/*
3 7
.14....
.M.Z...
..23...
2 3 |

10 10
..........
..........
..........
..1--4....
..|..|....
..2--.---M
.....|....
.....|....
.....|....
Z----3....
6 6 +
	 */
	public static void main(String[] args) throws Exception {
		//빈 칸을 만날 때마다 빈 칸 주변 사방탐색해서 갈 수 있는 파이프찾기
		//두개이상이면 안됨
		//파이프찾기 --> 방향 저장해서 그 방향에 맞는 파이프만 가능.
		//빈칸 1,2,3,4 ,ㅣ - + 순서
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		visited = new boolean[R][C];
		String line;
		int r=0,c=0;
		for(int i=0;i<R;i++){
			line = in.readLine();
			for(int j=0;j<C;j++){
				if(line.charAt(j)=='M') {
					map[i][j]= 9;
					r = i; c = j;
				}
				else if(line.charAt(j)=='Z') map[i][j]= -1;
				else if(line.charAt(j)=='.') map[i][j]= 0;
				else if(line.charAt(j)=='|') map[i][j]= 5;
				else if(line.charAt(j)=='-') map[i][j]= 6;
				else if(line.charAt(j)=='+') map[i][j]= 7;
				else map[i][j]=line.charAt(j) -'0';

			}
		}

		visited[r][c] = true;
		for(int d=0;d<4;d++){
			int nr = r+deltas[d][0];
			int nc = c+deltas[d][1];
			if(nr<0||nr>=R||nc<0 || nc>=C||map[nr][nc]==0) continue;
			if(move(nr,nc,d,null)) return;
		}
	}

	private static boolean move(int r, int c, int d, int[] pipe){
		visited[r][c] = true;
		//방향전환
		int p = map[r][c];
		if(p>=1 && p<=4) d = turn[p-1][d];

		//다음 nr,nc
		int nr = r+deltas[d][0];
		int nc = c+deltas[d][1];
		if(nr<0||nr>=R||nc<0 || nc>=C) return false;

		//끝났는지 체크
		if(map[nr][nc]==-1) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(!visited[i][j]&&map[i][j]>0) return false;
				}
			}
			System.out.println(getType(pipe[0],pipe[1]));
			return true;
		}

		//0이고 파이프 더 놓을수있는지 체크
		boolean iszero = map[nr][nc]==0 && pipe==null;

		//이 방향 이 자리에서 갈 수 있는 파이프인지 확인
		//0이고 놓을 수 있다면 변경하고 놓기
		for(int b:block[d]){
			if(iszero) {
				map[nr][nc] = b;
				pipe = new int[]{nr,nc};
			}
			if(map[nr][nc]==b && move(nr,nc,d,pipe)) return true;
		}

		//변경한적있다면 되돌리기
		if(iszero) map[nr][nc] = 0;

		visited[r][c] = false;
		return false;
	}

	private static String getType(int r, int c){
		StringBuilder sb = new StringBuilder();
		sb.append(r+1).append(' ');
		sb.append(c+1).append(' ');

		if(map[r][c]==9) return sb.append('M').toString();
		else if(map[r][c]==-1) return sb.append('Z').toString();
		else if(map[r][c]==0) return sb.append('.').toString();
		else if(map[r][c]==5) return sb.append('|').toString();
		else if(map[r][c]==6) return sb.append('-').toString();
		else if(map[r][c]==7) return sb.append('+').toString();
		else return sb.append((char)(map[r][c] +'0')).toString();
	}
}
