import java.io.*;
import java.util.*;

public class BOJ_1417_국회의원선거 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int dasom = Integer.parseInt(in.readLine());

		PriorityQueue<Integer> pQueue = new PriorityQueue<>((o1,o2)->o2.compareTo(o1));

		for(int i=0;i<N-1;i++) pQueue.offer(Integer.parseInt(in.readLine()));

		int cnt = 0;
		while(!pQueue.isEmpty() && dasom++<=pQueue.peek()){
			pQueue.offer(pQueue.poll()-1);
			++cnt;
		}

		System.out.println(cnt);

	}
}
