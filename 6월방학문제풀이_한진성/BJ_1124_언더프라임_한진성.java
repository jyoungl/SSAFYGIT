import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1124_언더프라임 {

	static int arr[] = new int[100001];
	static ArrayList<Integer> list = new ArrayList<>(); 
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st= new StringTokenizer(in.readLine());
		int idx = 0;
		for(int i=2;i<=100000;i++) {
			int P = i;
			if(arr[i] == 0) {
				for(int j = P+P; j <= 100000;j+=P) {
					arr[j] = 1;
				}
			}
		}
		
		
		for(int i=2;i<=100000;i++) {
			if(arr[i] == 0) {
				list.add(i);
			}
		}
//		System.out.println(list);
		
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int ans = 0;
		for(int i=A;i<=B;i++) {
			int num = i;
			idx = 0;
			cnt = 0;
			while(true) {
				
				if(num % list.get(idx) == 0) {
					num = num / list.get(idx);
					cnt++;
				}else {
					idx++;
				}
//				System.out.println(num);
				if(num == 1) {
					break;
				}
				
			}
//			System.out.println("====");
			for(int j=0,n=list.size();j<n;j++) {
				if(list.get(j) == cnt) {
					ans++;
				}
			}
			
		}
		
		System.out.println(ans);
	}

}
