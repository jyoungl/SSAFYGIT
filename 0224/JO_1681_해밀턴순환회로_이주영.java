import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1681_해밀턴순환회로_이주영 {
	static int[][]arr;
    static boolean[]visited;
    static int min, sum, N;
    
    public static void dfs(int x, int y, int cnt) {
        if(sum>min) {
            return;
        }
        sum = sum + arr[x][y];  
        visited[x] = true; 
        if(cnt == N-1) {
            sum = sum + arr[y][0];   
            if(arr[y][0]==0) {  
                return;
            }
            min = Math.min(min, sum);
            sum = sum - arr[y][0];  
            return;
        }
        
        
        for(int i = 0; i<N; i++) {
            if(!visited[i] && arr[y][i]!=0 &&(sum<min)) {  
                dfs(y,i,cnt+1);
                sum = sum - arr[y][i]; 
                visited[i] = false; 
            }
        }
	}
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        
        for(int x = 0; x<N; x++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            for(int y = 0; y<N; y++) {
                arr[x][y]=Integer.parseInt(st.nextToken());
            }
        }
        min = Integer.MAX_VALUE;
        for(int j = 1; j<N; j++) { 
            visited = new boolean[N];
            sum = 0;
            if(arr[0][j]!=0) {
                dfs(0,j,1);
            }
        }
        System.out.println(min);
    }

}
