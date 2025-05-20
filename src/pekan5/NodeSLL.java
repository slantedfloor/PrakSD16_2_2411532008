package pekan5;

public class NodeSLL {
	// node bagian data
	int data;
	// pointer ke node berikutnya
	NodeSLL next;
	// konstruktor menginisialisasi node dengan data
	public NodeSLL(int data) {
		this.data = data;
		this.next = null;
	}
}
