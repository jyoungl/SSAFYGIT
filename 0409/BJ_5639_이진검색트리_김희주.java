import java.io.*;

public class BOJ_5639_이진검색트리 {
	static StringBuilder sb = new StringBuilder();
	static Node tree;

	private static class Node{
		int data;
		Node left;
		Node right;
		private Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new FileReader("C:\\SSAFY\\workspace\\01_java\\Algorithm_BOJ_2204\\input.txt"));

		String line = in.readLine();
		tree = new Node(Integer.parseInt(line));
		while((line = in.readLine())!=null){
			int data = Integer.parseInt(line);
			Node node = new Node(data);

			Node parent = tree;
			for(Node child = parent;child!=null;){
				parent = child;
				if(node.data<parent.data) child = parent.left;
				else child = parent.right;
			}

			if(node.data<parent.data) parent.left = node;
			else parent.right = node;
		}

		post(tree);
		System.out.print(sb);
	}

	private static void post(Node root){
		if(root.left!=null) post(root.left);
		if(root.right!=null) post(root.right);
		sb.append(root.data).append('\n');
	}

//	private static String change(int root, int parent, int way) throws IOException {
//		String next = in.readLine();
//		int left = -1, right = -1;
//
//		//오른쪽(root보다 작음)
//		if (next != null) left = Integer.parseInt(next);
//		if (left != -1 && left < root && (way<=0 || left>parent))
//			next = change(left, root, -1);
//
//		//왼쪽(root보다 큼)
//		if (next != null) right = Integer.parseInt(next);
//		if (right != -1 && right > root && (way>=0 || right < parent)) next = change(right, root, 1);
//
//		//root
//		sb.append(root).append('\n');
//
//		return next;
//	}
}
