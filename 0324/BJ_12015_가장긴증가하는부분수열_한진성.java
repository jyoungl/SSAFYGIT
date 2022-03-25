import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_12015_가장긴증가하는부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// linkedlist 시간초과
		ArrayList<Integer> list = new ArrayList<>();
		
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		list.add(0);
		int max = 0;
		for(int i=0;i<N;i++) {
			max = Integer.parseInt(st.nextToken());
			
			// 값이 최댓값인 경우
			if(list.get(list.size()-1)<max) {
				list.add(max);
			}else {
				int start = 1;
				int end = list.size()-1;
				
				while(start < end) {
					int half = (start+end)/2;
					if(list.get(half)<max) {
						start = half+1;
					}else {
						end = half;
					}
				}
				// 덮어쓰기 해야되서 무조건 set 써야한다?
				list.set(end,max);
//				list.remove(end);
//				list.add(end,max);
			}
		}
		
		System.out.println(list.size()-1);
	}

}
