import java.util.Scanner;

public class Encryption {
	public static String reverse(String str) {
		String result = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			result += str.charAt(i);
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		String output = "";
		while (!input.isEmpty()) {
			if (input.length() % 2 != 0) {
				input = reverse(input);
			}
			int index = (input.length() - 1) / 2;
			output += input.charAt(index);
			input = input.substring(0, index) + input.substring(index + 1);
		}
		System.out.print(output);
	}
}
