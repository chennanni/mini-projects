package app.progress_bar;

import java.awt.Container;

import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class Monitor extends Thread {
	
	private Container container;
	private JTextField countTextField;
	private Window window;
	
	Object store[][] = new Object[Constants.MAX_TASK_NUM][2];
	
	public Monitor(Window window) {
		this.container = window.getContentPane();
		this.countTextField = window.getCountTaskField();
		this.window = window;
		start(); // start the thread when the object is initiated
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				for (int i=0; i<Constants.MAX_TASK_NUM; i++) {
					if (store[i][0] != null) {
						int progress = ((Task) store[i][0]).getProgress();
						JProgressBar progressBar = (JProgressBar) store[i][1];
						progressBar.setValue(progress);
						if (progress == 100) { // if a task is completed
							container.remove(progressBar); // delete it from the container
							container.repaint();
							store[i][0] = null; // delete it from the local store
							store[i][1] = null;
							window.setCount(window.getCount()-1); // reset the task count
							countTextField.setText(window.getCount() + ""); // repaint
							//window.pack();
							window.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT+Constants.TASK_HEIGHT*window.getCount());
						}
					}
				}
			}
		}
	}
	
	public void register(Task task, JProgressBar progressBar) {
		for (int i=0; i<Constants.MAX_TASK_NUM; i++) { // find the next available spot to store
			if (store[i][0] == null) {
				store[i][0] = task;
				store[i][1] = progressBar;
				break;
			}
		}
	}

}
