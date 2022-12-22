package com.chennanni.clock;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Clock {

	public static void main(String args[]) throws InterruptedException {
		Timer timer = new Timer();
		TimerTask task = new AlarmTask(timer);

		// get input from console
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the alarm time(1/1000 second): ");
		long delay = scanner.nextLong();
		scanner.close();

		// set timer
		timer.schedule(task, delay);
	}
}
