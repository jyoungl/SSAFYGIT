import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2980_도로와신호등 {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		
		int L = Integer.parseInt(st.nextToken());
		
		TrafficLight[] traf = new TrafficLight[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine()," ");
			int dic = Integer.parseInt(st.nextToken());
			int red = Integer.parseInt(st.nextToken());
			int green = Integer.parseInt(st.nextToken());
			traf[i] = new TrafficLight(dic, red, green);
		}
		int time = 0;
		for(int i=1;i<L;i++) {	
			for(int j=0;j<N;j++) {
				if(traf[j].timer % traf[j].red == 0 && traf[j].traffic == false) {
					traf[j].timer = 0;
					traf[j].traffic = true;
				}else if(traf[j].timer % traf[j].green == 0 && traf[j].traffic==true) {
					traf[j].timer = 0;
					traf[j].traffic = false;
				}
				traf[j].timer++;
//				System.out.print(traf[j].traffic + " ");
			}
//			System.out.println();
			for(int j=0;j<N;j++) {
				if(i == traf[j].dic && traf[j].traffic == false) {
					i--;
				}
			}
			time++;
		}
		
		System.out.println(time);
		
	}
	
}

class TrafficLight{
	int dic;
	int red;
	int green;
	int timer;
	boolean traffic = true;
	
	
	public TrafficLight(int dic, int red, int green) {
		super();
		this.dic = dic;
		this.red = red;
		this.green = green;
	}
	
	
}
