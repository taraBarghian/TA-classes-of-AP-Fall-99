import java.util.Scanner;
import java.util.regex.*;

public class Grayscale {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Pattern p = Pattern.compile(
			"#(([\\da-f]{2})\\2\\2|([\\da-f])\\3\\3)",
			Pattern.CASE_INSENSITIVE
		);
		while (sc.hasNext()) {
			String color = sc.next();
			if (p.matcher(color).matches()) {
				System.out.println(color);
			}
		}
		sc.close();
	}
}
