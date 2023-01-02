package jan02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_2529_부등호_이주영 {
	public static char[] c;
	public static boolean[] visited;
	public static ArrayList<String> ans = new ArrayList<>();
	public static int k;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		c = new char[k];
		visited = new boolean[10];
		
		for(int i=0;i<k;i++) {
			c[i] = st.nextToken().charAt(0);
		}
		
		for(int i=0;i<=9;i++) {
			visited[i] = true;
			check(i, 0, String.valueOf(i));
			visited[i] = false;
		}
		
		Collections.sort(ans);
		System.out.println(ans.get(ans.size() - 1));
		System.out.println(ans.get(0));
	}

	public static void check(int now, int cnt, String a) {
		if (cnt == k) {
            ans.add(a);
            return;
        }
 
        for (int i = 0; i <= 9; i++) {
            if (visited[i]) continue;
            
            if (chk(now, i, c[cnt])) {
                visited[i] = true;
                check(i,cnt+1,a+String.valueOf(i));
                visited[i] = false;
            }
        }
        
	}
	
	public static boolean chk(int a, int b, char c) {
 	   if(c == '>') {
 		   if(a>b) return true;
 	   }
 	   if(c == '<')
 		   if(a<b) return true;
 	   
 	   return false;
    }
}
