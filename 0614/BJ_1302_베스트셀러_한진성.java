import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_1302_베스트셀러 {
	
	static class Book implements Comparable<Book>{
		
		int cnt;
		String name;
		
		
		public Book(int cnt, String name) {
			super();
			this.cnt = cnt;
			this.name = name;
		}


		@Override
		public int compareTo(Book o) {
			if(cnt < o.cnt) {
				return 1;
			}else if(cnt == o.cnt){
				return name.compareTo(o.name);
			}else {
				return -1;
			}
		}
		
		
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(in.readLine());
		
		List<Book> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			String temp = in.readLine();
			boolean check = false;
			for(int j=0,n=list.size();j<n;j++) {
				if(list.get(j).name.equals(temp)) {
					list.get(j).cnt++;
					check = true;
				}
			}
			if(!check) {
				list.add(new Book(1,temp));
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.get(0).name);

	}

}
