import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int price6=1001,price1=1001;
		for(int i=0;i<M;i++){
			st = new StringTokenizer(in.readLine());
			price6 = Math.min(price6, Integer.parseInt(st.nextToken()));
			price1 = Math.min(price1, Integer.parseInt(st.nextToken()));
		}

		if(price1*6<price6){
			System.out.println(price1*N);
			return;
		}

		int total = price6*(N/6);
		total += Math.min(N%6 * price1, price6);
		System.out.println(total);
	}
}
