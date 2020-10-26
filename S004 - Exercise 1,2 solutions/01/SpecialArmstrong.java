import java.util.Scanner;

public class SpecialArmstrong {
	public static boolean isArmstrong(int number) {
		int sumofDigitCubes = 0;
		int numberCopy = number;
		while (numberCopy != 0) {
			int digit = numberCopy % 10;
			sumofDigitCubes += digit * digit * digit;
			numberCopy /= 10;
		}
		return number == sumofDigitCubes;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.close();
		int xDecimal = Integer.parseInt(String.valueOf(x), m);
		int yDecimal = Integer.parseInt(String.valueOf(xDecimal), n);
		System.out.println(isArmstrong(yDecimal) ? "True" : "False");
	}
}
