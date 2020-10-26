import java.util.Scanner;

public class MinimumDistance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		int[] z = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
			z[i] = sc.nextInt();
		}
		sc.close();
		double minimumDistance = Double.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				double distance = Math.sqrt(
					Math.pow(x[i] - x[j], 2)
					+ Math.pow(y[i] - y[j], 2)
					+ Math.pow(z[i] - z[j], 2)
				);
				if (distance < minimumDistance) {
					minimumDistance = distance;
				}
			}
		}
		System.out.printf("%.3f", minimumDistance);
	}
}
