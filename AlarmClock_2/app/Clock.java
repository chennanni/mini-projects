import java.util.Scanner;
import java.util.Timer;

public class Clock {

	public static void main(String args[]) {
		Timer timer = new Timer();
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			AlarmTask task = new AlarmTask();
			
			System.out.print("Enter the alarm name or q for quit: ");
			String input1 = scanner.nextLine();
			if (input1.compareTo("q") == 0) {
				scanner.close();
				timer.cancel();
				return;
			} else {	
				task.setName(input1);
			}
			
			System.out.print("Enter the alarm time or q for quit: ");
			String input2 = scanner.nextLine();
			try {
				if (input2 == "q") {
					scanner.close();
					return;
				} else if (Long.valueOf(input2) > 0 && Long.valueOf(input2) < Long.MAX_VALUE) {
					long delay = Long.valueOf(input2);
					task.setTime(delay);
					timer.schedule(task, delay);
				}
			} catch (NumberFormatException e) {
				System.out.println("Input format is not corrent.");
			}
		}
	}
}
