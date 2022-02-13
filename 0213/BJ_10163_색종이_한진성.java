import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10163_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		int[][] arr = new int[1001][1001];
		
		int N = Integer.parseInt(in.readLine());
		int xMax = 0;
		int yMax = 0;
		for(int c=1;c<=N;c++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");	
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			for(int i=x;i<x+d;i++) {
				for(int j=y;j<y+r;j++){
					arr[i][j] = c;
				}
			}
			if(x+d > xMax) {
				xMax = x+d;
			}
			if(y+r > yMax) {
				yMax = y+r;
			}
		}
		for(int c=1;c<=N;c++) {
			int cnt = 0;
			for(int i=0;i<xMax;i++) {
				for(int j=0;j<yMax;j++) {
					if(arr[i][j] == c) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}

		
	}

}
