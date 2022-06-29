package Tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {
	
	Node root;
	List<String> elements;
	
	public Tree() {
		root = null;
	}
	
	 public Tree(Node rootNode) {
		 root = rootNode;
	 }
	 public Node GetRoot() {
		return root;
		 
	 }
	 public void SetRoot(Node rootNode) {
		 root = rootNode;
	 }
	 
	 void preorder_run(Node node) {
		 if (node == null) return;
		 elements.add(node.data);
		 preorder_run(node.GetLeftChild());
		 preorder_run(node.GetRightChild());
	 }
	 
	 public String Preorder() {
		 elements = new ArrayList<String>();
		 preorder_run(root);
		 return String.join("-", elements);
	 }
	 
	 public String Inorder() {
		 elements = new ArrayList<String>();
		 inorder_run(root);
		 return String.join("-", elements);
		 
	 }
	 private void inorder_run(Node node) {
		 if (node == null) return;
		 inorder_run(node.GetLeftChild());
		 elements.add(node.data);
		 inorder_run(node.GetRightChild());
	}

	public String Postorder() {
		 elements = new ArrayList<String>();
		 postorder_run(root);
		 return String.join("-", elements);
	 }

	private void postorder_run(Node node) {
		if (node == null) return;
		postorder_run(node.GetLeftChild()); 
		postorder_run(node.GetRightChild());	
		elements.add(node.data);
	}

	public void SetLeft(Node currNode) {
		root.SetLeftChild(currNode);	
	}

}
