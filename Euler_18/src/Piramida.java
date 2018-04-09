public class Piramida extends Node {
	private int depth;
	private Node head;

	private int indexInRaw;
	private Node lastInRaw;
	private Node firstOfRaw;

	public Piramida() {
		this.depth = 0;
		this.head = null;

		this.indexInRaw = 1;
		this.lastInRaw = null;
		this.firstOfRaw = null;
	}

	public void addNode(int data) {
		indexInRaw++;

		if (this.head == null) {
			this.head = new Node();
			this.head.setData(data);

			depth = 1;
			lastInRaw = head;
			firstOfRaw = head;

		} else {
			Node tmp = new Node();
			tmp.setData(data);
			if (indexInRaw > depth) {
				tmp.rightParent = firstOfRaw;
				firstOfRaw.leftSon = tmp;

				firstOfRaw = tmp;
				lastInRaw = firstOfRaw;
				indexInRaw = 1;
				depth++;

			} else {

				lastInRaw.rightBro = tmp;
				tmp.leftBro = lastInRaw;
				lastInRaw.rightBro = tmp;

				tmp.leftParent = lastInRaw.rightParent;
				tmp.leftParent.rightSon = tmp;

				if (indexInRaw < depth) {
					tmp.rightParent = tmp.leftParent.rightBro;
					tmp.rightParent.leftSon = tmp;
				}

				lastInRaw = tmp;
			}
		}
	}

	public int getMaxsum() {
		if (head == null)
			return -1;

		Node first = firstOfRaw;
		Node tmp = first;

		while (tmp.leftParent != null || tmp.rightParent != null) {
			while (tmp.rightBro != null) {
				if (tmp.rightSon == null)
					tmp.maxsum = tmp.data;
				else {
					if (tmp.rightSon.maxsum > tmp.leftSon.maxsum)
						tmp.maxsum = tmp.rightSon.maxsum + tmp.data;
					else
						tmp.maxsum = tmp.leftSon.maxsum + tmp.data;
				}
				tmp = tmp.rightBro;
			}

			if (tmp.rightSon == null)
				tmp.maxsum = tmp.data;
			else {
				if (tmp.rightSon.maxsum > tmp.leftSon.maxsum)
					tmp.maxsum = tmp.rightSon.maxsum + tmp.data;
				else
					tmp.maxsum = tmp.leftSon.maxsum + tmp.data;
			}

			first = first.rightParent;
			tmp = first;
		}

		if (head.rightSon != null) {
			if (tmp.rightSon.maxsum > tmp.leftSon.maxsum)
				tmp.maxsum = tmp.rightSon.maxsum + tmp.data;
			else
				tmp.maxsum = tmp.leftSon.maxsum + tmp.data;
		}

		return tmp.maxsum;
	}

}
