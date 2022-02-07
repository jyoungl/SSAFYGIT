import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D4_1218_괄호짝짓기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<Character>();
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[] ch = br.readLine().toCharArray();
			boolean b = true;
			
			for(int i=0;i<N;i++) {
				if(ch[i] == '(' || ch[i] == '{' || ch[i] == '[') {
					st.push(ch[i]);
				}
				
				else if(ch[i] == ')') {
					if(st.isEmpty() || st.pop() != '(') {
						b = false;
						break;
					}
				}
				
				else if(ch[i] == '}') {
					if(st.isEmpty() || st.pop() != '{') {
						b = false;
						break;
					}
				}
				
				else if(ch[i] == ']') {
					if(st.isEmpty() || st.pop() != '[') {
						b = false;
						break;
					}
				}
			}
			
			if(!st.isEmpty()) {
				b = false;
			}
			
			//결과 출력
			if(b == true) {
				sb.append("#"+tc+" 1\n");
			}
			else {
				sb.append("#"+tc+" 0\n");
			}
			st.clear();
		}
		System.out.println(sb);
	}

}
