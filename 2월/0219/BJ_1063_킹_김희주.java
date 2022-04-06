import java.io.*;
import java.util.*;

public class BOJ_1063_킹 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		Map<String, Points> map = new HashMap<>();
		map.put("R",new Points(0,1));
		map.put("L",new Points(0,-1));
		map.put("B",new Points(-1,0));
		map.put("T",new Points(1,0));
		map.put("RT",new Points(1,1));
		map.put("LT",new Points(1,-1));
		map.put("RB",new Points(-1,1));
		map.put("LB",new Points(-1,-1));

		Points king = new Points(st.nextToken());
		Points stone = new Points(st.nextToken());

		int N = Integer.parseInt(st.nextToken());

		while(--N>=0){
			String move = in.readLine();
			int nr = king.r + map.get(move).r;
			int nc = king.c + map.get(move).c;

			if(nr<0 || nr>=8 || nc<0 || nc>=8) continue;
			if(nr != stone.r || nc != stone.c){
				king.set(nr,nc);
			}else {
				int sr = stone.r + map.get(move).r;
				int sc = stone.c + map.get(move).c;

				if(sr<0 || sr>=8 || sc<0 || sc>=8) continue;

				king.set(stone);
				stone.set(sr,sc);
			}
		}

		System.out.println(king);
		System.out.println(stone);

	}
}

class Points{
	int r;
	int c;
	public Points(int r, int c){
		this.r = r;
		this.c = c;
	}
	public Points(String point){
		this.c = point.charAt(0)-'A';
		this.r = point.charAt(1)-'1';
	}
	public void set(Points p){
		this.r = p.r;
		this.c = p.c;
	}
	public void set(int r,int c){
		this.r = r;
		this.c = c;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append((char)(c+'A')).append(r+1);
		return sb.toString();
	}

}