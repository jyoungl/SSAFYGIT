import java.io.*;
import java.util.*;

public class BOJ_2630_색종이만들기 {
	static int[][] paper;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(in.readLine());
		paper = new int[N][N];
		result = new int[2];

		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++){
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cutPaper(0,0,N);
		System.out.print(result[0]+"\n"+result[1]);
	}

	private static void cutPaper(int i, int j, int n) {
		if(n==1 || checkPaper(i,j,n)) {
			result[paper[i][j]]++;
			return;
		}

		int half = n/2;
		cutPaper(i,j,half);
		cutPaper(i+half,j,half);
		cutPaper(i,j+half,half);
		cutPaper(i+half,j+half,half);
	}

	private static boolean checkPaper(int i, int j, int n){
		int check = paper[i][j];
		for(int ii=i;ii<i+n;ii++){
			for(int jj=j;jj<j+n;jj++){
				if(check!=paper[ii][jj]) return false;
			}
		}
		return true;
	}
}
