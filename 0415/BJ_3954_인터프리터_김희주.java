import java.io.*;
import java.util.*;

public class BOJ_3954_인터프리터 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		int END = 50000000;
		int mod = 256;

		while (--T >= 0) {
			st = new StringTokenizer(in.readLine());
			int M = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int I = Integer.parseInt(st.nextToken());

			int[] arr = new int[M];

			String command = in.readLine();
			String input = in.readLine();

			//stack으로 []짝맞추기
			int[] pair = new int[C];
			Stack<Integer> stack = new Stack<>();
			for (int c = 0; c < C; c++) {
				if (command.charAt(c) == '[') {
					stack.push(c);
				} else if (command.charAt(c) == ']') {
					pair[c] = stack.peek();
					pair[stack.pop()] = c;
				}
			}

			int pointer = 0;
			int ipos = 0;
			int count = 0;
			int c;
			int min=0,max=0;
			for (c = 0; c < C; c++) {
				int now = command.charAt(c);
				if(++count==END){
					min = max = c;
				}

				if(count>END){
					min = Math.min(min,c);
					max = Math.max(max,c);
				}

				if(count>END*2){
					sb.append("Loops ").append(min-1).append(' ').append(max).append('\n');
					break;
				}

				switch (now) {
					case '-'://underflow
						arr[pointer] = (arr[pointer] +255) % mod;
						break;
					case '+'://overflow
						arr[pointer] = (arr[pointer] + 1) % mod;
						break;
					case '<':
						pointer = (pointer + M - 1) % M;
						break;
					case '>':
						pointer = (pointer + 1) % M;
						break;
					case '[':
						if(arr[pointer]==0){
							c = pair[c];
						}
						break;
					case ']':
						if(arr[pointer]!=0){
							c = pair[c];
						}
						break;
					case '.': break;
					case ',':
						arr[pointer] = ipos < I ? input.charAt(ipos++) : 255;
						break;
				}

			}

			if (count<=END) {
				sb.append("Terminates\n");
			}

		}

		System.out.print(sb);
	}
}
