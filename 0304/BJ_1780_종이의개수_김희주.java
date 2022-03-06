import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수 {
	static int[][] paper;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(in.readLine());
		paper = new int[N][N];
		result = new int[3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cutPaper(0,0,N);

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<3;i++){
			sb.append(result[i]).append("\n");
		}

		System.out.print(sb);
	}

	private static void cutPaper(int y, int x, int n) {
		if(n==1 || checkPaper(y,x,n)) {
			result[paper[y][x]+1] ++;
			return;
		}

		int divide = n/3;
		for(int i=y;i<y+n;i+=divide){
			for(int j=x;j<x+n;j+=divide){
				cutPaper(i,j,divide);
			}
		}

	}

	private static boolean checkPaper(int y, int x, int n) {
		int first = paper[y][x];
		for(int i=y;i<y+n;i++){
			for(int j=x;j<x+n;j++){
				if(first != paper[i][j]) return false;
			}
		}
		return true;
	}
}
