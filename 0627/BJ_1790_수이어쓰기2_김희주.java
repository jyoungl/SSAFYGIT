import java.io.*;
import java.util.*;

public class BOJ_1790_수이어쓰기2 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int i=0;
		long k=K;
		while(K>0){
			k = K;
			K-=Math.pow(10,i)*(i+1)*9;
			i++;
		}

		long res = (long)Math.pow(10,i-1)+(k-1)/i;
		if(res>N) System.out.println(-1);
		else System.out.println(String.valueOf(res).charAt((int)(k-1)%i));
	}
}
