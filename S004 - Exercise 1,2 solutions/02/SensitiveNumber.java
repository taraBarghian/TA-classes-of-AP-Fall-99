import java.util.Scanner;

public class SensitiveNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String number = sc.next();
		sc.close();
		int[] digitFrequencies = new int[10];
		for (int i = 0; i < number.length(); i++) {
			digitFrequencies[number.charAt(i) - '0']++;
		}
		boolean isSensitive = true;
		for (int i = 1; i < 10; i++) {
			if (digitFrequencies[i] % i != 0) {
				isSensitive = false;
				break;
			}
		}
		System.out.print(isSensitive ? "Yes" : "No");
	}
}
