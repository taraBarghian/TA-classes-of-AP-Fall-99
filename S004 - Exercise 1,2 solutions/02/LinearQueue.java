import java.util.Scanner;

public class LinearQueue {
	private static String[] queue;
	private static int maxSize = 5;
	private static int size = 0;

	private static boolean isEmpty() {
		return size == 0;
	}

	private static boolean isFull() {
		return size == maxSize;
	}

	private static void enqueue(String name, int quantity) {
		if (isFull()) {
			System.out.println("Queue is full");
			return;
		}
		queue[size++] = name + "_" + quantity;
	}

	private static void dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		for (int i = 0; i < size - 1; i++) {
			queue[i] = queue[i + 1];
		}
		size--;
	}

	private static void printQueue() {
		for (int i = 0; i < size; i++) {
			System.out.println(queue[i]);
		}
	}

	public static void main(String[] args) {
		queue = new String[maxSize];
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String command = sc.next();
			if (command.equals("Enqueue")) {
				String name = sc.next();
				int quantity = sc.nextInt();
				enqueue(name, quantity);
			} else {
				dequeue();
			}
		}
		printQueue();
		sc.close();
	}
}
