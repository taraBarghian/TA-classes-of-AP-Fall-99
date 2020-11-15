
public class Stack {
	private String[] elements = new String[100];
	private int size = 0;

	public boolean empty() {
		return this.size == 0;
	}

	public String push(String element) {
		elements[size++] = element;
		return element;
	}

	public String pop() {
		if (this.empty()) {
			return "error";
		}
		return this.elements[--size];
	}

	public String peek() {
		if (this.empty()) {
			return "error";
		}
		return this.elements[size - 1];
	}

	public int search(String element) {
		for (int i = 0; i < this.size; i++) {
			if (this.elements[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	public void clear() {
		this.size = 0;
	}

	public String toString() {
		String result = "[";
		for (int i = 0; i < this.size; i++) {
			result += this.elements[i] + ((i < this.size - 1) ? ", " : "");
		}
		result += "]";
		return result;
	}

	public static void main(String[] args) {
		Stack st = new Stack();
		System.out.println(st.empty()); // true
		st.push("1");
		System.out.println(st.empty()); // false
		System.out.println(st.search("1")); // 0
		System.out.println(st.peek()); // 1
		System.out.println(st.pop()); // 1
		System.out.println(st.empty()); // true
		st.push("1");
		st.clear();
		System.out.println(st.empty()); // true
	}
}
