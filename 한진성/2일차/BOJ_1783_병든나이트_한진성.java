import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1783_병든나이트_한진성 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if(N==1) {
			System.out.println(1);
			return;
		}
		
		if(N==2) {
			// 가로가 4칸 이하일 때
			int cnt = (M+1)/2;
			
			if(cnt > 4) {
				System.out.println(4);
			}else {
				System.out.println(cnt);
			}
			return;
		}
		
		if(N >= 3) {
			int cnt = 0;
			if(M >= 7) {
				cnt = M-2;
			}else {
				cnt = Math.min(4, M);
			}
			System.out.println(cnt);
			return;
		}
	}

}
