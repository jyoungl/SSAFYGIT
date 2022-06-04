import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BOJ_1057_토너먼트 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		
		int A = Integer.parseInt(st.nextToken());
		
		int B = Integer.parseInt(st.nextToken());
		int cnt =1;
		if(Math.abs(A-B) == 1 && A/2 != B/2) {
			System.out.println(cnt);
			return;
		}
		
		while(N > 2) {
			if(Math.abs(A-B) == 1 && A/2 != B/2) {
				System.out.println(cnt);
				return;
			}
			if(A %2 == 0) {
				A = A/2;
			}else {
				A = A/2+1;
			}
			if(B%2 == 0) {
				B = B/2;
			}else {
				B = B/2+1;
			}
			cnt++;
		}
		
		
	}

}
