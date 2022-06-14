import java.io.*;
import java.util.*;

public class BOJ_1302_베스트셀러 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Map<String,Integer> map = new HashMap<>();
		String title;
		int cnt;
		int max=0;
		String result="";
		for(int i=0;i<N;i++){
			title = in.readLine();
			cnt = map.getOrDefault(title,0)+1;
			map.put(title,cnt);
			if(max<cnt || (max==cnt && result.compareTo(title)>0)) {
				max = cnt;
				result = title;
			}
		}
		System.out.println(result);
	}
}
