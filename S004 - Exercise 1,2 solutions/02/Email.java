import java.util.Scanner;
import java.util.regex.*;

public class Email {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String email = sc.next();
		sc.close();
		Pattern p = Pattern.compile(
				"^[A-Za-z\\d][A-Za-z\\d.]*\\.[A-Za-z]{2,3}@([A-Za-z\\d]*\\$){3}[A-Za-z\\d$]*$");
		System.out.print(p.matcher(email).matches() ? "YES" : "NO");
	}
}
