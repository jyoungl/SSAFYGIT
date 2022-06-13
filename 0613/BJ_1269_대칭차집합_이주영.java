import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_1269_대칭차집합_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int anum = Integer.parseInt(st.nextToken());
		int bnum = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> a = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<anum;i++)
			a.add(Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		
		for(int i=0;i<bnum;i++) {
			int x = Integer.parseInt(st.nextToken());
			if(a.contains(x))
				a.remove(x);
			else
				cnt++;
		}
		
		int res = a.size() + cnt;
		System.out.println(res);
		
		
//		Arrays.sort(a);
//		Arrays.sort(b);
//			
//		int cnt = 0;
//		for(int i=0;i<Math.min(anum, bnum);i++) {
//			for(int j=0;j<Math.max(anum, bnum);j++) {
//				if(a[i] == b[j]) {
//					cnt++;
//					break;
//				}
//				
//				if(a[i]<b[j])
//					break;
//			}
//		}
//		
//		int res = (anum - cnt) + (bnum - cnt);
//		System.out.println(res);
	}

}
