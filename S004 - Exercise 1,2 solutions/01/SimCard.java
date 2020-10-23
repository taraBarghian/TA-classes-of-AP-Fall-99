import java.util.Scanner;

public class SimCard {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char c = sc.next().charAt(0);
		sc.close();
		long ans = 0;
		for (int i = 0; i <= 9; i++) {
			long cnt = 0, pw = 1;
			for (int j = (s.charAt(0) == 0 ? 4 : 5); j < s.length(); j++) {
				if (s.charAt(j) - '0' == i) {
					cnt++;
					pw *= 10;
				}
			}
			if (cnt > 1) {
				ans += pw;
			}
			if (i == 0) {
				ans += 10 * cnt;
			}
		}
		boolean invalid = false;
		if (c == 'i') {
			ans += 20;
		} else if (c == 'h') {
			ans += 25;
		} else if (c == 'r') {
			ans += 30;
		} else {
			invalid = true;
		}
		if (!s.startsWith("09") && !s.startsWith("989")) {
			invalid = true;
		}
		if ((s.startsWith("0912") || s.startsWith("98912")) && c != 'h') {
			invalid = true;
		}
		if ((s.startsWith("0936") || s.startsWith("98936")) && c != 'i') {
			invalid = true;
		}
		if ((s.startsWith("0921") || s.startsWith("98921")) && c != 'r') {
			invalid = true;
		}
		if (s.startsWith("0912") || s.startsWith("98912")
				|| s.startsWith("0936") || s.startsWith("98936")
				|| s.startsWith("0921") || s.startsWith("98921")) {
			ans += 50;
		}

		System.out.println(invalid ? "Invalid" : ans);
	}
}
