import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 입력 사람들이 만난 기록의 수 N
2. 사람들과 만난 기록 이름 a b
3. 대소문자 구분
4. 총총이의 이름은 ChongChong
5. 총총이를 만나는 순간부터 무지개댄스 전파
 */
public class S4_26069_붙임성좋은총총이 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        set.add("ChongChong");

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if(set.contains(a)) {
                if(set.contains(b)) continue;
                else set.add(b);
            } else if(set.contains(b)) {
                set.add(a);
            }
        }

        System.out.println(set.size());
    }

}
