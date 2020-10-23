import java.util.Scanner;

public class RightTriangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int x3 = sc.nextInt();
		int y3 = sc.nextInt();
		sc.close();
		double surface = Math
				.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2;
		if (surface == 0) {
			System.out.println("Impossible");
			return;
		}
		double A = Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2);
		double B = Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2);
		double C = Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2);
		if ((A > 0 && B > 0 && C > 0)
				&& (A == (B + C) || B == (A + C) || C == (A + B))) {
			System.out.println("Yes");
			System.out.printf("%.3f", surface);
		} else {
			System.out.println("No");
			System.out.printf("%.3f", surface);
		}
	}
}
