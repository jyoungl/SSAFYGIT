import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_1238_Contact {

	static class Node{
		int V;
		Node link;
		public Node(int v, Node link) {
			super();
			V = v;
			this.link = link;
		}
		
		@Override
		public String toString() {
			return "Node [V=" + V + ", link=" + link + "]";
		}
		
		
	}
	static int cnt;
	static ArrayList<Integer> ansNumbers;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.setIn(new FileInputStream("input_1238.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		int tc = 1;
		while((str = in.readLine()) != null) {
			
			String splitStr[] = str.split(" ");
			
			int N = Integer.parseInt(splitStr[0]);
			
			int V = Integer.parseInt(splitStr[1]);
			
			Node[] nodeList = new Node[N];
			
			str = in.readLine();
			
			splitStr = str.split(" ");
			//유향 그래프 생성
			for(int i=0,n=splitStr.length;i<n;i+=2) {
				
				int from = Integer.parseInt(splitStr[i]);
				int to = Integer.parseInt(splitStr[i+1]);
				
				nodeList[from] = new Node(to,nodeList[from]);
				
			}
			ansNumbers = new ArrayList<>();
//			for(Node is : nodeList) {
//				System.out.println(is);
//			}
			
			
			
			System.out.printf("#%d %d\n",tc++,bfs(V,nodeList));
		}
		
	}
	
	public static int bfs(int start, Node[] nodeList) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		boolean[] visited = new boolean[nodeList.length];
		
		// 노드의 깊이를 저장할 배열
		int[] depth = new int[nodeList.length];
		// 처음 시작하는 곳은 깊이가 1
		depth[start] = 1;
		queue.offer(start);
		visited[start] = true;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			ansNumbers.add(current);
//			System.out.print(current+" ");
			// current 정점의 인접 정점 처리(단, 방문하지 않은 인접 정점만)
			for(Node temp=nodeList[current]; temp!=null;temp = temp.link) {
				if(!visited[temp.V]) {
					queue.offer(temp.V);
					visited[temp.V] = true;
					// 깊이 기록
					depth[temp.V] += depth[current]+1;
				}
			}
		}
		// 가장 깊은 깊이에 있는 노드 중 가장 큰 값 찾기
		int ans = 0;
		for(int i=0;i<nodeList.length;i++) {
			if(depth[i] >= depth[ans]) {
				ans = i;
			}
		}
		
		return ans;
	}

}
