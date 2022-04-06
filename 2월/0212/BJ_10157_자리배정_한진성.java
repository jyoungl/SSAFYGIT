import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10157_자리배정 {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
				//		좌	     하		  우		 상
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int C  = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(in.readLine());
		int[][] arr = new int[C+1][R+1]; 
		int cnt = 1;
		int dirr = 0;
		int x = 1;
		int y = 1;
		arr[x][y] = cnt;
		
		if(C*R < K) {
			System.out.println(0);
			return;
		}
		if(K == 1) {
			System.out.println(1+" "+1);
			return;
		}
		
		while(cnt < C*R) {
			
			int dx = x + dir[dirr][0];
			int dy = y + dir[dirr][1];
			if(dx > 0 && dx <= C && dy > 0 && dy <= R && arr[dx][dy] == 0) {
				arr[dx][dy] = ++cnt;
				x = dx;
				y = dy;
			}else {
				dirr = (dirr+1)%4;
			}
			
			if(cnt == K) {
				System.out.println(dx + " " + dy);
				break;
			}
		}
		
		
	}

}
