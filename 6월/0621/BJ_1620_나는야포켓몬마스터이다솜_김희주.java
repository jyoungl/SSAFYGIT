import java.io.*;
import java.util.*;

public class BOJ_1620_나는야포켓몬마스터이다솜 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] pokemons = new String[N];
		Map<String,Integer> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			pokemons[i] = in.readLine();
			map.put(pokemons[i],i+1);
		}

		StringBuilder sb = new StringBuilder();
		String input;
		for(int i=0;i<M;i++){
			input = in.readLine();
			if(input.charAt(0)>='0' && input.charAt(0)<='9'){
				sb.append(pokemons[Integer.parseInt(input)-1]).append('\n');
			}else{
				sb.append(map.get(input)).append('\n');
			}
		}
		System.out.print(sb);

	}
}
