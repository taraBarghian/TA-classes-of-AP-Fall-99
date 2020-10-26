import java.util.Scanner;

public class Unicode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String hex = sc.next();
		sc.close();
		int charCode = Integer.parseInt(hex, 16);
		System.out.println((char) charCode);
		System.out.println((charCode >= 1536 && charCode <= 1791) ? "persian"
				: "non-persian");
	}
}
