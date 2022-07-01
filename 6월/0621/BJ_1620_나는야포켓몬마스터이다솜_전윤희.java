package 기타;

import java.io.*;
import java.util.*;

// 이중for문으로 풀면 시간초과
public class BJ_1620_나는야포켓몬마스터이다솜_해시맵 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		int pocketmon = Integer.parseInt(st.nextToken());
		int question = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> pocket = new HashMap<>();
		String[] name = new String[pocketmon+1];
		for (int i = 1; i <= pocketmon; i++) {
			String pocketmonName = br.readLine();
			pocket.put(pocketmonName, i);
			name[i] = pocketmonName;
		}
		for (int i = 0; i < question; i++) {
			String s = br.readLine();
			
			// 숫자를 입력받은 경우
			if(48<=s.charAt(0)&&s.charAt(0)<=57) {
				int index=Integer.parseInt(s);
				sb.append(name[index]);
			}
			else { // 문자를 입력받은 경우
				sb.append(pocket.get(s));
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
