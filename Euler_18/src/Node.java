public class Node {

	public int data;
	public int maxsum;

	public Node leftParent;
	public Node rightParent;

	public Node leftBro;
	public Node rightBro;

	public Node leftSon;
	public Node rightSon;

	public Node() {
		this.data = 0;
		this.maxsum = 0;

		this.leftParent = null;
		this.rightParent = null;

		this.leftBro = null;
		this.rightBro = null;

		this.leftSon = null;
		this.rightSon = null;
	}

	public void setData(int data) {
		this.data = data;
	}

}
