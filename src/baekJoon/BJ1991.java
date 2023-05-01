package baekJoon;

import java.util.*;
import java.io.*;

class Node {
	char data;
	Node left, right;

	public Node(char data) {
		this.data = data;
	}
}
class Tree {
	Node Root;
	public void Add(char Data, char left_Data, char right_Data) {
		if (Root == null) {
			if (Data != '.') {
				Root = new Node(Data);
			}
			if (left_Data != '.') {
				Root.left = new Node(left_Data);
			}
			if (right_Data != '.') {
				Root.right = new Node(right_Data);
			}
		}
		else {
			search(Root, Data, left_Data, right_Data);
		}
	}

	public void search(Node Root, char Data, char left_Data, char right_Data) {
		if (Root == null) {
			return;
		}
		else if (Root.data == Data) {
			if (left_Data != '.') {
				Root.left = new Node(left_Data);
			}
			if (right_Data != '.') {
				Root.right = new Node(right_Data);
			}
		}
		else {
			search(Root.left, Data, left_Data, right_Data);
			search(Root.right, Data, left_Data, right_Data);
		}
	}

	public void preOrder(Node Root) {
		System.out.print(Root.data);
		if (Root.left != null) {
			preOrder(Root.left);
		}
		if (Root.right != null) {
			preOrder(Root.right);
		}
	}

	public void inOrder(Node Root) {
		if (Root.left != null) {
			inOrder(Root.left);
		}
		System.out.print(Root.data);
		if (Root.right != null) {
			inOrder(Root.right);
		}
	}

	public void postOrder(Node Root) {
		if (Root.left != null) {
			postOrder(Root.left);
		}
		if (Root.right != null) {
			postOrder(Root.right);
		}
		System.out.print(Root.data);
	}
}

public class BJ1991{

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());

		Tree tree = new Tree();
		for (int i = 0; i<num; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			tree.Add(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
		}

		tree.preOrder(tree.Root);
		System.out.println();
		tree.inOrder(tree.Root);
		System.out.println();
		tree.postOrder(tree.Root);
	}
}

