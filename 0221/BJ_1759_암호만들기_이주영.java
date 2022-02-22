import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1759_암호만들기_이주영 {
	static int L;
	static int C;
	static String[] arr;
	static String[] res;
	static ArrayList<String[]> list;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();
	
	public static void func(int cnt, int start) {
		if(cnt == L) {
			//Arrays.sort(res);
			int m = 0; //모음수
			int v = 0; //자음수... 왜 해야함?
			for(int i=0;i<L;i++) {
				if(res[i].equals("a") || res[i].equals("e") || res[i].equals("u") || res[i].equals("o") || res[i].equals("i"))
					m++;
				else
					v++;
			}
			
			if(m >= 1 && v >= 2) {
				for(int i=0;i<L;i++)
					sb.append(res[i]);
				sb.append("\n");
			}
			
//			if(!list.contains(res)) 
//				list.add(res);					
			return;
		}
		
		for(int i=start;i<C;i++) {
			res[cnt] = arr[i];
			func(cnt+1, i+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken()); //암호 길이
		C = Integer.parseInt(st.nextToken()); //암호 구성 알파벳
		
		arr = new String[C];
//		ArrayList<String> arr1 = new ArrayList<>(); //알파벳 자음
//		ArrayList<String> arr12 = new ArrayList<>(); //알파벳 모음
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<C;i++) {
			String s = st.nextToken();
			//if(s == "a" || s == "e" || s == "i" || s == "o" || s == "u")
			arr[i] = s;
		}
		
		Arrays.sort(arr);
		res = new String[L];
		check = new boolean[C];
		list = new ArrayList<>();
		func(0, 0);	
		
//		for(int i=0;i<list.size();i++) {
//			String temp = list.get(i).toString();
//			System.out.println(temp);
//		}
			//sb.append(list.get(i)).append("\n");
		
		System.out.println(sb);
	}

}
