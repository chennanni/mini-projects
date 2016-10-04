import java.util.TimerTask;

public class AlarmTask extends TimerTask{

	private String name;
	private long time;
	
	@Override
	public void run() {
		System.out.println("\n" + name + ": time's up.");
		return;
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
