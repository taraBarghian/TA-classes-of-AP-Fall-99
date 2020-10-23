import java.util.Scanner;

public class Planet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		int g = sc.nextInt();
		int z = sc.nextInt();
		int v = sc.nextInt();
		int r = sc.nextInt();
		int year = sc.nextInt();
		int month = sc.nextInt();
		int day = sc.nextInt();
		int hour = sc.nextInt();
		int minute = sc.nextInt();
		int second = sc.nextInt();
		sc.close();
		double hourPerDay = t * 2 / 3600;
		long startTime = (long) ((year * 12 * 30 * hourPerDay * 60 * 60)
				+ (month * 30 * hourPerDay * 60 * 60)
				+ (day * hourPerDay * 60 * 60) + (hour * 60 * 60)
				+ (minute * 60) + second);
		int travelParts = z - g;
		if (travelParts < 0) {
			travelParts += n;
		}
		if (n - travelParts < travelParts) {
			travelParts = n - travelParts;
		}
		long travelTime = (r * travelParts / n) / v * 60 * 60;
		long finishTime = startTime + travelTime + ((g - z) * t * 2 / n);
		int finishYear = (int) (finishTime / (12 * 30 * hourPerDay * 60 * 60));
		finishTime %= 12 * 30 * hourPerDay * 60 * 60;
		int finishMonth = (int) (finishTime / (30 * hourPerDay * 60 * 60));
		finishTime %= 30 * hourPerDay * 60 * 60;
		int finishDay = (int) (finishTime / (hourPerDay * 60 * 60));
		finishTime %= hourPerDay * 60 * 60;
		int finishHour = (int) (finishTime / (60 * 60));
		finishTime %= 60 * 60;
		int finishMinute = (int) (finishTime / 60);
		finishTime %= 60;
		int finishSecond = (int) finishTime;
		if (finishDay == 0) {
			finishDay = 30;
			finishMonth--;
		}
		if (finishMonth == 0) {
			finishMonth = 12;
			finishYear--;
		} else if (finishMonth > 12) {
			finishMonth %= 12;
			finishYear++;
		}
		int travelYear = (int) (travelTime / (12 * 30 * hourPerDay * 60 * 60));
		travelTime %= 12 * 30 * hourPerDay * 60 * 60;
		int travelMonth = (int) (travelTime / (30 * hourPerDay * 60 * 60));
		travelTime %= 30 * hourPerDay * 60 * 60;
		int travelDay = (int) (travelTime / (hourPerDay * 60 * 60));
		travelTime %= hourPerDay * 60 * 60;
		int travelHour = (int) (travelTime / (60 * 60));
		travelTime %= 60 * 60;
		int travelMinute = (int) (travelTime / 60);
		travelTime %= 60;
		int travelSecond = (int) travelTime;
		System.out.printf("%d/%d/%d %d:%d:%d\n", finishYear, finishMonth,
				finishDay, finishHour, finishMinute, finishSecond);
		System.out.printf("%d year %d month %d day %d hour %d minute %d second",
				travelYear, travelMonth, travelDay, travelHour, travelMinute,
				travelSecond);
	}
}
