import java.io.*;
import java.util.*;

public class BOJ_1759_암호만들기 {
	static int L, C;
	static char[] alphabets;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alphabets = new char[C];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < C; i++) alphabets[i] = st.nextToken().charAt(0);
		Arrays.sort(alphabets);

		makePw(0, 0, 0, 0);

		System.out.print(sb);
	}

	private static void makePw(int cnt, int start, int vowel, int flag) {
		if (cnt == L) {
			if (vowel < 1) return;
			if (L - vowel < 2) return;

			for (int i = 0; i < C; i++) {
				if ((flag & 1 << i) != 0) sb.append(alphabets[i]);
			}

			sb.append("\n");
			return;
		}

		for (int i = start; i < C; i++) {
			if ((flag & 1 << i) != 0) continue;
			makePw(cnt + 1, i + 1, isVowel(alphabets[i]) ? vowel+1 : vowel, flag | 1 << i);
		}


	}

	private static boolean isVowel(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}
}
