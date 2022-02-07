import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Bqj_2493_탑 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int input = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		Stack<int[]> st = new Stack<>();
		
		for(int i=1;i<=input;i++) {
			int now = Integer.parseInt(str[i-1]);
			
			if(i==1) {
				sb.append("0 ");
			}
			
			while(!st.isEmpty()) {
				if(st.peek()[1] > now) {
					sb.append(st.peek()[0] + " ");
					break;
				}
				else {
					st.pop();
				}
				
				if(st.isEmpty()) {
					sb.append("0 ");
					break;
				}
			}
		
			st.push(new int[] {i, now});
		}
		System.out.println(sb.toString().trim());
	}

}

//public static void main(String[] args) throws IOException {
//	// TODO Auto-generated method stub
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	StringBuilder sb = new StringBuilder();
//	int input = Integer.parseInt(br.readLine());
//	String[] str = br.readLine().split(" ");
//	int[] arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
//	
//	sb.append("0 ");
//	
//	for(int x=1;x<arr.length;x++) {
//		boolean b = false;
//		for(int i=x-1;i>=0;i--) {
//			if(arr[i] >= arr[x]) {
//				sb.append(i+1+" ");
//				b = true;
//				break;
//			}
//		}
//		
//		if(b == false) {
//			sb.append("0 ");
//		}
//	}
//	System.out.println(sb.toString().trim());
//}
