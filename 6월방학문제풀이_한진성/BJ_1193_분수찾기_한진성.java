import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1193_분수찾기 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				
		int N = Integer.parseInt(in.readLine());
		
		
		//1  5 9 13 17 21 ...
		//1123211234543211234567654321
		//3    7        11 
		//121123432112345654321
		int i=0;
		for(;i<N;i++) {
			N -=i;
		}
		
		if(i%2 == 1) {
			System.out.println((i+1-N) + "/" + N);
		}else {
			System.out.println(N + "/" + (i+1-N));
		}

	}

}
