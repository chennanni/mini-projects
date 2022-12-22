import java.util.Timer;
import java.util.TimerTask;

public class AlarmTask extends TimerTask{

	Timer timer;
	private String name;
	private long time;

	public AlarmTask(Timer timer) {
		this.timer = timer;
	}

	@Override
	public void run() {
		System.out.println("\n" + name + ": time's up.");
		timer.cancel();
	}

	public Timer getTimer() {
		return timer;
	}
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
}
