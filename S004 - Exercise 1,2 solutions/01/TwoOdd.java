import java.util.Scanner;

public class TwoOdd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.close();
		boolean isTwoOdd = true;
		int previousDigit = (number % 10) + 2;
		while (number != 0) {
			int digit = number % 10;
			if (previousDigit - digit != 2) {
				isTwoOdd = false;
				break;
			}
			previousDigit = digit;
			number /= 10;
		}
		System.out.print(isTwoOdd ? "YES" : "NO");
	}
}
