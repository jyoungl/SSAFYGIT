import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2628_종이자르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		int M = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(st.nextToken());
		// 세로리스트
		LinkedList<Integer> list1 = new LinkedList<>();
		// 가로리스트
		LinkedList<Integer> list2 = new LinkedList<>();
		
		list1.add(N);
		list2.add(M);
		int R = Integer.parseInt(in.readLine());
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(in.readLine()," ");
			
			//가로, 세로 여부
			int D = Integer.parseInt(st.nextToken());
			// 길이
			int L = Integer.parseInt(st.nextToken());
			// 가로로 자를 경우
			if(D == 0) {
				
				// 리스트 길이만큼 반복
				for(int j=0,n=list1.size();j<n;j++) {
					if(list1.get(j) > L) {
						int temp = list1.remove(j) - L;
						list1.add(j,temp);
						list1.add(j,L);
						break;
					}else {
						L = L - list1.get(j);
					}
				}
			// 세로로 자를 경우
			}else {
				for(int j=0,n=list2.size();j<n;j++) {
					if(list2.get(j) > L) {
						int temp = list2.remove(j) - L;
						list2.add(j,temp);
						list2.add(j,L);
						break;
					}else {
						L = L - list2.get(j);
					}
				}
			}
		}
		System.out.println(list1);
		System.out.println(list2);
		Collections.sort(list1,Collections.reverseOrder());
		Collections.sort(list2,Collections.reverseOrder());
		
		System.out.println(list1.get(0)*list2.get(0));
	}

}
