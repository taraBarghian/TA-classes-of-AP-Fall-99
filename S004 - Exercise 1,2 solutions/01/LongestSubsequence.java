import java.util.Scanner;

public class LongestSubsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int longest = 0;
		int current = 0;
		int last = -1;
		while (true) {
			int x = sc.nextInt();
			if (x == -1) {
				break;
			}
			if (x == last + 1) {
				current++;
			} else {
				current = 1;
			}
			if (current > longest) {
				longest = current;
			}
			last = x;
		}
		sc.close();
		System.out.println(longest);
	}
}
