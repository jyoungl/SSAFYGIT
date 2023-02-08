package feb08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_5639_이진검색트리_이주영 {
	public static class Node {
		int now;
		Node left;
		Node right;
		
		public Node(int now) {
			this.now = now;
		}
		
		public void insert(int x) {
			if(x<this.now) {
				if(this.left == null)
					this.left = new Node(x);
				else
					this.left.insert(x);
			}
			else {
				if(this.right == null)
					this.right = new Node(x);
				else
					this.right.insert(x);
			}
				
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node tree = new Node(Integer.parseInt(br.readLine()));
		while(true) {
			String str = br.readLine();
			if(str==null||str.equals(""))
				break;
			tree.insert(Integer.parseInt(str));
		}
		postOrder(tree);
	}
	public static void postOrder(Node node) {
		if(node.left != null)
			postOrder(node.left);
		if(node.right != null)
			postOrder(node.right);
		System.out.println(node.now);
	}
}
