import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {
	static int[] nums;
	static int[] cal;
	static List<Character> operactor = new ArrayList<>();
	static char[] opPerm;
	static int max,min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		nums = new int[N];
		
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine()," ");
		
		// 덧셈
		int k = Integer.parseInt(st.nextToken());
		for(int i=0;i<k;i++) {
			operactor.add('+');
		}
		// 뺄셈
		k = Integer.parseInt(st.nextToken());
		for(int i=0;i<k;i++) {
			operactor.add('-');
		}
		// 곱셈
		k = Integer.parseInt(st.nextToken());
		for(int i=0;i<k;i++) {
			operactor.add('*');
		}
		// 나눗셈
		k = Integer.parseInt(st.nextToken());
		for(int i=0;i<k;i++) {
			operactor.add('/');
		}
		opPerm = new char[operactor.size()];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		perm(0,0);
		System.out.println(max);
		System.out.println(min);
	}
	
	static void perm(int cnt, int flag) {
		
		// 기저조건
		if(cnt == operactor.size()) {
			int num = nums[0];
			for(int i=0;i<nums.length-1;i++) {
				switch(opPerm[i]){
				case '+':
					num = num + nums[i+1];
					break;
				case '-':
					num = num - nums[i+1];					
					break;
				case '*':
					num = num * nums[i+1];
					break;
				case '/':
					num = num / nums[i+1];
					break;
				}
			}
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		
		// 유도파트
		
		for(int i=0,n=operactor.size();i<n;i++) {
			
			if((flag & 1<<i) != 0) {
				continue;
			}
			
			opPerm[cnt] = operactor.get(i);
			perm(cnt+1,flag | 1<<i);
		}
		
	}
	
}
