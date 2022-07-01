import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1225_이상한곱셈 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());


		String A = st.nextToken();
		
		String B = st.nextToken();
		
		int sum = 0;
		for(int i=0,n=A.length();i<n;i++) {
			
			for(int j=0,m=B.length();j<m;j++) {
				
				sum = sum + (A.charAt(i)-'0')*(B.charAt(j)-'0');
				
			}
			
		}
		
		System.out.println(sum);
		
	}

}
