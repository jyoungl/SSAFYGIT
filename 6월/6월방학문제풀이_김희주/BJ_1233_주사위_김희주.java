import java.io.*;
import java.util.*;

public class BOJ_1233_주사위 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int S1 = Integer.parseInt(st.nextToken());
		int S2 = Integer.parseInt(st.nextToken());
		int S3 = Integer.parseInt(st.nextToken());
		int[] sum = new int[S1+S2+S3+1];

		for(int i=1;i<=S1;i++){
			for(int j=1;j<=S2;j++){
				for(int k=1;k<=S3;k++){
					sum[i+j+k]++;
				}
			}
		}

		int idx=0;
		for(int i=1;i<sum.length;i++){
			if(sum[idx]<sum[i]) idx = i;
		}

		System.out.println(idx);
	}
}
