import java.io.*;

public class BOJ_1193_분수찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();

		int start = 1;
		int cnt = 1;
		for (int i = 4; ; i += 4) {
			if (start == X || start + 1 == X) {
				sb.append("1/").append(start == X ? cnt : cnt + 1);
				System.out.println(sb);
				return;
			}

			//위로 향하는 대각선
			if(X>start-cnt && X<=start) {
				sb.append(start - X+1).append('/').append(cnt - (start - X));
				System.out.println(sb);
				return;
			}

			start++;cnt++;
			//아래로 향하는 대각선
			if(X>=start && X<start+cnt){
				sb.append(X-start+1).append('/').append(cnt-(X-start));
				System.out.println(sb);
				return;
			}

			cnt ++;
			start += i;

		}



	}
}
