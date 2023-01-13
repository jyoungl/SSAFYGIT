package jan13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_8911_거북이_이주영 {
	public static int[] dr = {-1,0,1,0};//왼위오아
	public static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			char[] c = st.nextToken().toCharArray();
			sb.append(check(c)).append("\n");
		}
		System.out.println(sb);
	}

	public static int check(char[] c) {
		int dis = 1; //0왼 1위 2오 3아
		int x = 0, y = 0;
		int maxx=0, maxy=0;
		int minx=0, miny=0;
		
		for(int j=0;j<c.length;j++) {
			switch(c[j]) {
			case 'F':
				x += dr[dis];
				y += dc[dis];
				break;
			case 'B':
				int a = (dis+2)%4;
				x += dr[a];
				y += dc[a];
				break;
			case 'L':
				dis--;
				if(dis == -1)
					dis = 3;
				break;
			case 'R':
				dis++;
				if(dis == 4)
					dis = 0;
				break;
			}
			minx = Math.min(minx, x);
			miny = Math.min(miny, y);
			maxx = Math.max(maxx, x);
			maxy = Math.max(maxy, y);
		}
		
		int ans = (maxx-minx) * (maxy-miny);
		return ans;
		
		
	}
}
