import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2563_색종이_이주영 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] whole = new int[100][100];
		int cnt = 0;
		
		for(int i=0;i<N;i++) {
			String[] str = br.readLine().split(" ");
			int L = Integer.parseInt(str[0]);
			int R = Integer.parseInt(str[1]);
			
			for(int a=L;a<L+10;a++) {
				for(int b=R;b<R+10;b++) {
					if(whole[a][b] != 1) {
						whole[a][b] = 1;
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
