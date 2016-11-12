package app.progress_bar;

public class Task implements Runnable{
	
	private int taskTime;
	private int progress;
	private Thread thread;
	
	public Task(int taskTime) {
		this.progress = 0;
		this.taskTime = taskTime;
		this.start();
	}
	
	@Override
	public void run() {
		int sleepTime = taskTime*10;
		for (int i=0; i<100; i++) {
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			progress++;
		}
	}

	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}
	
	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public int getTaskTime() {
		return taskTime;
	}

	public void setTaskTime(int taskTime) {
		this.taskTime = taskTime;
	}
	
}
