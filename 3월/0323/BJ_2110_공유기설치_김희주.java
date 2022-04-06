import java.io.*;
import java.util.*;

//int type 가능
public class BOJ_2110_공유기설치 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] houses = new int[N];
		int min=0,max = 0;
		for(int i=0;i<N;i++) max = Math.max(max,houses[i] = Integer.parseInt(in.readLine()));

		Arrays.sort(houses);

		int mid,count;
		while(min<=max){
			mid = (min+max)/2;
			count=1;
			int prev = houses[0];
			for(int i=1;i<N;i++){
				if(houses[i]-prev<mid) continue;
				count++;
				prev = houses[i];
			}

			if(count>=C) min = mid+1;
			else max = mid-1;
		}

		System.out.println(max);

	}
}
