import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1786_찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		char[] text = in.readLine().toCharArray();
		char[] pattern = in.readLine().toCharArray();

		int tLength = text.length;
		int pLength = pattern.length;

		int[] pi = new int[pLength];

		for (int i = 1, j = 0; i < pLength; i++) {
			//j가 0보다 크면서 패턴의 i번째가 패턴의 j번째보다 달라지는 순간 반복
			while (j > 0 && pattern[i] != pattern[j]) {
				// j를  -1 해준다.
				j = pi[j - 1];
			}
			// 패턴 i번째와 패턴의 j번쨰가 같으면 해당하는 패턴 i번째의 부분일치하는 j 위치 1 증가?
			if (pattern[i] == pattern[j]) {
				pi[i] = ++j;
			} else { // 패턴이 일치하는 부분이 없다면 해당 부분일치하는 j값 0으로 하기
				pi[i] = 0;
			}
		}

		int cnt = 0;
		
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0, j = 0; i < tLength; i++) {
			// //j가 0보다 크면서 텍스트의 i번째가 패턴의 j번째보다 달라지는 순간 반복
			while (j > 0 && text[i] != pattern[j]) {
				// j를  -1 해준다.
				j = pi[j - 1];
			}
			// 텍스트의 i번째와 패턴의 j번쨰가 같으면 해당하는 패턴 i번째의 부분일치하는 j 위치 1 증가?
				if (text[i] == pattern[j]) {
					// 모든 문자열이 같은 경우
					if (j == pLength - 1) {
						// 카운트 1 증가
						cnt++;
						// 리스트에 해당 문자열의 시작 번호 추가
						list.add((i + 1) - pLength);
						// j를 현재 위치부터 다시 탐색하기?
						j = pi[j];
					} else {
						j++;
					}
				}
			}

		System.out.println(cnt);
		for(int i=0,n=list.size();i<n;i++) {
			if(cnt > 0) {
				System.out.println(list.get(i)+1);
			}
		}
	}

}
