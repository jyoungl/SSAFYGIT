import java.io.*;
import java.util.*;

public class BOJ_16637_괄호추가하기 {
	static long MAX = Integer.MIN_VALUE;
	static int operator, N;
	static char[] expression;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		expression = in.readLine().toCharArray();
		operator = N / 2;

		findMax(1, new boolean[N]);
		System.out.println(MAX);
	}

	private static void findMax(int cnt, boolean[] visited) {
		if (cnt >= N) {
			calc(visited);
			return;
		}

		visited[cnt] = false;
		findMax(cnt + 2, visited);
		if (cnt != 1 && visited[cnt - 2]) return;
		visited[cnt] = true;
		findMax(cnt + 2, visited);

	}

	private static void calc(boolean[] visited) {
		Deque<X> deque = new ArrayDeque<>();
		for(int i=0;i<N;i++){
			if(!visited[i]){
				if(i%2==0) deque.addLast(new X(expression[i]-'0', true));
				else deque.addLast(new X(expression[i],false));
			}else{
				char op = expression[i];
				int a = deque.pollLast().num;
				int b = expression[++i]-'0';
				if(op=='+') deque.addLast(new X(a+b,true));
				else if(op=='-') deque.addLast(new X(a-b,true));
				else deque.addLast(new X(a*b,true));
			}
		}

		long result = deque.pollFirst().num;
		while(!deque.isEmpty()){
			char op = deque.pollFirst().op;
			int tmp = deque.pollFirst().num;

			if(op=='+') result += tmp;
			else if(op=='-') result -= tmp;
			else result *= tmp;
		}

		MAX = Math.max(MAX, result);
	}

	private static class X {
		int num;
		boolean isNum;
		char op;

		X(int x, boolean isNum) {
			this.isNum = isNum;
			if(isNum) num = x;
			else op = (char)(x);

		}

	}
}
