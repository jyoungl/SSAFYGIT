import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BJ_2961_도영이가만든맛있는음식_이주영 {
	static int N;
	static boolean[] isSelected;
	static int[] S; //요리의 신맛
	static int[] B; //요리의 쓴맛
	static LinkedList<Integer> list = new LinkedList<>();
	static LinkedList<Integer> list2 = new LinkedList<>();	
	
	public static void funS(int cnt) {
		if(cnt == N) { //기저조건
			int res = 1;
			for(int i=0;i<N;i++) {
				if(isSelected[i])
					res *= S[i];
			}
			list.add(res);
			return;
		}
		
		isSelected[cnt] = true;
		funS(cnt+1);
		isSelected[cnt] = false;
		funS(cnt+1);
	}
	
	public static void funB(int cnt) {
		if(cnt == N) { //기저조건
			int res = 0;
			for(int i=0;i<N;i++) {
				if(isSelected[i])
					res += B[i];
			}
			list2.add(res);
			return;
		}
		
		isSelected[cnt] = true;
		funB(cnt+1);
		isSelected[cnt] = false;
		funB(cnt+1);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];
		for(int i=0;i<N;i++) {
			String[] str = br.readLine().split(" ");
			S[i] = Integer.parseInt(str[0]); //요리의 신맛
			B[i] = Integer.parseInt(str[1]); //요리의 쓴맛
		}
		
		isSelected = new boolean[N];
		funS(0);
		isSelected = new boolean[N];
		funB(0);
		list.remove(list.size()-1); //공집합 제거
		list2.remove(list2.size()-1); //공집합 제거
		
		int min = Integer.MAX_VALUE;
		for(int i=0;i<list.size();i++) {
			int x = list.get(i) - list2.get(i);
			min = Math.min(Math.abs(x), min);
		}
		
		System.out.println(min);
	}

}
