import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수 {
	static int N, arr[][], cnt[] = new int[3];
	public static void main(String[] args) throws NumberFormatException, IOException {

		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		arr = new int[N][N];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		d(0,0,N);		
		
		for(int i=0;i<3;i++) {
			System.out.println(cnt[i]);
		}
	}
	
	public static void d(int x, int y,int N) {
		int num = arr[x][y];
		boolean check = false;
		for(int i=x;i<x+N;i++) {
			for(int j=y;j<y+N;j++) {
				if(arr[i][j] != num) {
					check = true;
				}
			}
		}
		if(!check) {
			cnt[num+1]++;
			return;
		}
		
		int div = N/3;
		// 1분면
		d(x,y,div);
		// 2분면
		d(x,y+div,div);
		// 3분면
		d(x,y+div*2,div);
		
		// 4분면
		d(x+div,y,div);
		// 5분면
		d(x+div,y+div,div);
		// 6분면
		d(x+div,y+div*2,div);
		
		// 7분면
		d(x+div*2,y,div);
		// 8분면
		d(x+div*2,y+div,div);
		// 9분면
		d(x+div*2,y+div*2,div);
		
	}

}
