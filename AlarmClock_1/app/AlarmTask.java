package com.chennanni.clock;

import java.util.TimerTask;

public class AlarmTask extends TimerTask{

	@Override
	public void run() {
		System.out.println("time's up");
	}

}
