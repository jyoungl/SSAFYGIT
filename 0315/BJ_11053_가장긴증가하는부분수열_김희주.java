import java.io.*;
import java.util.*;

public class BOJ_11053_가장긴증가하는부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(in.readLine());
		int[] A = new int[N];

		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) A[i] = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();
		list.add(A[0]);

		for(int i=1;i<N;i++){
			if(list.get(list.size()-1)<A[i]) {
				list.add(A[i]);
				continue;
			}
			int idx = Collections.binarySearch(list, A[i]); //(-(insertion point) - 1).

			idx = -idx-1;
			if(idx>=0)list.set(idx,A[i]);
		}

		System.out.println(list.size());
	}
}
