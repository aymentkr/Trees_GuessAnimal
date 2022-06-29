package Tree;

public class Node {
	
	String data;
	Node left;
    Node right;
	
	 public Node() {
		 
	 }
	 public Node(String data) {
		 this.data = data;
		 right = null;
		 left = null;
	 }
	 public Node GetLeftChild() {
		 return left;
	 }
	 public Node GetRightChild() {
		 return right;
		 
	 }
	 public void SetLeftChild (Node ln) {
		 left = ln;
	 }
	 public void SetRightChild (Node rn) {
		 right = rn;
	 }
	 public Boolean HasLeftChild() {
		 return left != null;
	 }
	 public Boolean HasRightChild() {
		 return right != null;
	 }
	 public Boolean IsLeaf() {
		 return (!HasLeftChild() && !HasRightChild()); 
	 }
	 public void SetData(String data) {
		 this.data = data;
	 }
	 public String GetData() {
		 return data;
	 }

}
