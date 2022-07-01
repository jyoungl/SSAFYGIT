import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1141_접두사2 {
	static char[][] chars;
	static int numbers[];
	static int N, R, ans = 1;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		chars = new char[N][];

		for (int i = 0; i < N; i++) {
			chars[i] = in.readLine().toCharArray();
		}

		Arrays.sort(chars, (char[] o1, char[] o2)->{
			return o1.length - o2.length;
		});
		
//		for(int i=0;i<N;i++) {
//			System.out.println(chars[i]);
//		}
		ans = N;
		for(int i=N-1;i>=0;i--) {
			
			for(int j=0;j<i;j++) {
				boolean check = false;
				for(int k=0;k<chars[j].length;k++) {
					if(chars[j][k] == '.' || chars[i][k] != chars[j][k]) {
						check = true;
					}
				}
				if(!check) {
					for(int k=0;k<chars[j].length;k++) {
						chars[j][k] = '.';
					}
					ans--;
				}
				
			}
		}
		
		
		System.out.println(ans);
	}



}
