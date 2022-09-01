import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1105_팔 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        
        String L =st.nextToken();
        
        String R = st.nextToken();
    
        if(L.length() != R.length()) {
        	System.out.println(0);
        	return;
        }
        int cnt = 0;
        
        if(L.equals(R)) {
        	
        	for(int i=0;i<L.length();i++) {
        		if(L.charAt(i) == '8') {
        			cnt++;
        		}
        	}
        	System.out.println(cnt);
        	return;
        }

        for(int i=0;i<L.length();i++) {
        	if(L.charAt(i)=='8' && R.charAt(i) =='8') {

        		cnt++;
        	}else {
        		if(L.charAt(i) == R.charAt(i)) {
        			continue;
        		}
        		break;
        	}
        }
        
        System.out.println(cnt);
    }

}
