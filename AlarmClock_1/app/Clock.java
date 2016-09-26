package com.chennanni.clock;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Clock {

	public static void main(String args[]) {
		Timer timer = new Timer();
		TimerTask task = new AlarmTask();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the alarm time: ");
		long delay = scanner.nextLong();
		scanner.close();
		
		timer.schedule(task, delay);
	}
}
