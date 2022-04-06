import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1992_쿼드트리_이주영 {
	static int N;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void tree1(int size, int x, int y) {
		if(size == 1) {
			sb.append(arr[x][y]);
			return;
		}
		
		for(int i=x;i<size+x;i++) {
			for(int j=y;j<size+y;j++) {
				if(arr[i][j] != arr[x][y]) {
					sb.append("(");
					tree1(size/2, x, y);
					tree1(size/2, x, y+size/2);
					tree1(size/2, x+size/2, y);
					tree1(size/2, x+size/2, y+size/2);
					sb.append(")");
					return;
				}
			}
		}
		sb.append(arr[x][y]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		//배열 정보 입력
		for(int i=0;i<N;i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				arr[i][j] = ch[j] - '0';
			}
		}

		tree1(N, 0, 0);
		System.out.println(sb);
	}

}
