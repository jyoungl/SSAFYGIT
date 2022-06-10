import java.io.*;
import java.util.*;

public class BOJ_1225_이상한곱셈 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		char[] A = st.nextToken().toCharArray();
		char[] B = st.nextToken().toCharArray();
		long result = 0;
		for(int i=0;i<A.length;i++){
			for(int j=0;j<B.length;j++){
				result += (long) (A[i] - '0') *(B[j]-'0');
			}
		}
		System.out.println(result);
	}
}
