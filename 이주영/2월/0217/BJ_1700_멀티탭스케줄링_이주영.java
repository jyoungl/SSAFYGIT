package feb17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1700_멀티탭스케줄링_이주영 {
    public static int[] machine;
    public static boolean[] visited;
    public static int[] tap;
    public static int N,K,put;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        machine = new int[K];
        tap = new int[N];
        visited = new boolean[101];
        put = 0;
        for(int i=0;i<K;i++)
            machine[i] = Integer.parseInt(st.nextToken());

        // for(int Index=0;Index<N;Index++){
        //     tap[Index] = machine[Index];
        //     visited[machine[Index]] = true;
        // }

        System.out.println(schedule());
    }
    public static int schedule(){
        int ans = 0;
        for(int i=0;i<K;i++){
            if(put<N){
                if(!visited[machine[i]]){
                    visited[machine[i]] = true;
                    put++;
                }
            }
            else{
                if(!visited[machine[i]]){
                    //뒤에 또 사용하는 전자제품 저장
                    ArrayList<Integer> list = new ArrayList<>();
                    for(int j=i+1;j<K;j++){
                        if(visited[machine[j]] && !list.contains(machine[j]))
                            list.add(machine[j]);
                    }
                    if(list.size() != N){
                        for(int j=0;j<N;j++){
                            if(!list.contains(tap[j]) && visited[tap[j]]){
                                visited[tap[j]] = false;
                                tap[j] = machine[i];
                                break;
                            }
                        }
                    }
                    else{
                        visited[list.get(list.size()-1)] = false;
                    }
                    visited[machine[i]] = true;
                    ans++;
                    // for(int a=0;a<N;a++)
                    //     System.out.print(tap[a]+" ");
                    //     System.out.println();
                }    
                else{
                    continue;
                }
            }
        }
        return ans;
    }
}
