import java.io.*;
import java.util.*;

public class BJ_1463_1로만들기 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int[] count = new int[N+1];
		Arrays.fill(count,N+1);
		count[1] = 0;
		for(int i=1;i<=N;i++){
			if(i*3<=N && count[i*3]>count[i]+1) count[i*3] = count[i]+1;
			if(i*2<=N && count[i*2]>count[i]+1) count[i*2] = count[i]+1;
			if(i+1<=N && count[i+1]>count[i]+1) count[i+1] = count[i]+1;
		}

		System.out.println(count[N]);
	}
}
