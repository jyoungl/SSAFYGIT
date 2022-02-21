import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1987_알파벳_이주영 {
	static boolean[] check = new boolean[26];
	static int[] dr = {0, 1, -1, 0}; //우 하 상 좌
	static int[] dc = {1, 0, 0, -1};
	static int R;
	static int C;
	static int[][] al;
	static int cnt = 0;
	static int max = Integer.MIN_VALUE;
	
	public static void func(int x, int y, int cnt) {
		if(check[al[x][y]]) {
			max = Math.max(max, cnt);
			return;
		}
		else {
			check[al[x][y]] = true;
			for(int i=0;i<4;i++) {
				int a = x+dr[i];
				int b = y+dc[i];
				if(a>=0 && b>=0 && a<R && b<C)
					func(a,b,cnt+1);
			}
			check[al[x][y]] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		al = new int[R][C];
		
		for(int i=0;i<R;i++) {
			char[] str = br.readLine().toCharArray();
			for(int j=0;j<C;j++)
				al[i][j] = str[j] - 'A';
		}
		
		func(0,0,0);
		System.out.println(max);
	}

}
