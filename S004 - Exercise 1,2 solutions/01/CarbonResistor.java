import java.util.Scanner;

public class CarbonResistor {
	public static int getColorValue(String color) {
		switch (color) {
		case "black":
			return 0;
		case "brown":
			return 1;
		case "red":
			return 2;
		case "orange":
			return 3;
		case "yellow":
			return 4;
		case "green":
			return 5;
		case "blue":
			return 6;
		case "purple":
			return 7;
		case "grey":
			return 8;
		case "white":
			return 9;
		}
		return -1;
	}

	public static double getToleranceValue(String color) {
		switch (color) {
		case "brown":
			return 1;
		case "red":
			return 2;
		case "green":
			return 0.5;
		case "blue":
			return 0.25;
		case "purple":
			return 0.1;
		case "grey":
			return 0.05;
		case "golden":
			return 5;
		case "silver":
			return 10;
		case "colorless":
			return 20;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String c1 = sc.next();
		String c2 = sc.next();
		String c3 = sc.next();
		String c4 = "colorless";
		if (sc.hasNext()) {
			c4 = sc.next();
		}
		sc.close();
		int resistance = ((getColorValue(c1) * 10) + getColorValue(c2))
				* (int) Math.pow(10, getColorValue(c3));
		double tolerance = resistance * (getToleranceValue(c4) / 100);
		System.out.printf("%d ± %.2f", resistance, tolerance);
	}
}
