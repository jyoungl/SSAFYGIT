import java.io.*;
import java.util.*;

public class BOJ_2869_달팽이는올라가고싶다 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int diff = A-B;
		int result = (int)Math.ceil((Integer.parseInt(st.nextToken())-A)/(double)diff)+1;
		System.out.println(result);
	}
}
