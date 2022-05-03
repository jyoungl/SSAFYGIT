import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_13699_점화식 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		long[] t = new long[36];
		t[0] = 1;

		for(int i=1;i<=N;i++){
			long tmp = 0;
			for(int j=0;j<i/2;j++){
				tmp += t[i-1-j]*t[j];
			}
			tmp *= 2;
			if(i%2!=0) tmp += t[i/2]*t[i/2];
			t[i] = tmp;
		}

		System.out.println(t[N]);
	}
}
