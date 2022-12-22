import java.util.Timer;
import java.util.TimerTask;

public class AlarmTask extends TimerTask{

	Timer timer;

	public AlarmTask(Timer timer) {
		this.timer = timer;
	}

	@Override
	public void run() {
		System.out.println("time's up");
		timer.cancel();
	}

}
