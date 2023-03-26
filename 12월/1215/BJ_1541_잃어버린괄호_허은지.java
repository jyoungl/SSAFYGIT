import java.io.*;
import java.util.*;

public class S2_1541_잃어버린괄호 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        
//        Queue<Character> queue = new LinkedList<>();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
//			if(str.charAt(i)=='+' || str.charAt(i)=='-') queue.add(str.charAt(i));
			if(str.charAt(i)=='+' || str.charAt(i)=='-') list.add(str.charAt(i));
		}
        
        StringTokenizer st = new StringTokenizer(str,"+, -");
        int size = st.countTokens();
        
        boolean isMinus = false;
        int min = 0;
        
        for (int i = 0; i < size; i++) {
        	if(!isMinus) {
				min += Integer.parseInt(st.nextToken());
			} else {
				min -= Integer.parseInt(st.nextToken());
			}
//        	if(i<size-1 && queue.poll() == '-') isMinus = true;
        	if(i<size-1 && list.get(i) == '-') isMinus = true;
		}
        
        System.out.println(min);
    }
}
