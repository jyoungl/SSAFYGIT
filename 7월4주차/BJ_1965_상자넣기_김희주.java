import java.io.*;
import java.util.*;

public class BOJ_1965_상자넣기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		int idx,num;
		for(int i=0;i<N;i++){
			num = Integer.parseInt(st.nextToken());
			idx = -Collections.binarySearch(list,num)-1;
			if(idx==list.size()) list.add(num);
			else if(idx>=0) list.set(idx,num);
		}

		System.out.println(list.size());
	}
}
