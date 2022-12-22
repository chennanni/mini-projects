import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

public class Clock {

	public static void main(String args[]) {
		// set num of timer
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter how many timer you need:");
		String timer_num = scanner.nextLine();
		List<AlarmTask> alarmTaskList = new ArrayList<>();

		// create alarm task
		for (int i=0; i<Integer.valueOf(timer_num); i++) {
			Timer timer = new Timer();
			AlarmTask task = new AlarmTask(timer);

			System.out.print("Enter the alarm name:");
			String input1 = scanner.nextLine();
			task.setName(input1);

			System.out.print("Enter the alarm time(1/1000 second):");
			String input2 = scanner.nextLine();
			try {
				if (Long.valueOf(input2) > 0 && Long.valueOf(input2) < Long.MAX_VALUE) {
					long delay = Long.valueOf(input2);
					task.setTime(delay);
					alarmTaskList.add(task);
				}
			} catch (NumberFormatException e) {
				System.out.println("Input format is not corrent.");
			}
		}

		// create timer
		for (AlarmTask t : alarmTaskList) {
			t.getTimer().schedule(t, t.getTime());
		}
	}
}
