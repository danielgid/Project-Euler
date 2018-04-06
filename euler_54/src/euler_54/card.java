package euler_54;

public class card {

	private int type;
	private int value;

	public card() {
		this.type = 0;
		this.value = 0;
	}

	public card(int type, int value) {
		this.type = type;
		this.value = value;
	}

	public void set_type(int type) {
		this.type = type;
	}

	public void set_value(int value) {
		this.value = value;
	}
	
	public void set_card(int type, int value) {
		this.type = type;
		this.value = value;
	}

	public int get_type() {
		return this.type;
	}

	public int get_value() {
		return this.value;
	}

}
