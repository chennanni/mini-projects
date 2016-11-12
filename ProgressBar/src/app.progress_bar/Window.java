package app.progress_bar;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class Window extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private int count;
	private JTextField countTaskField;
	private JButton newTaskButton;
    private Monitor monitor;
    
	public Window() {
		// create a container
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		// add a label
		container.add(new JLabel("Number Of Task"));
		
		// add a text field
		countTaskField = new JTextField("0", 5);
		container.add(countTaskField);
		
		// add a button
		newTaskButton = new JButton("Start A New Task");
	    container.add(newTaskButton);
	    
		// create a monitor for this container 
		monitor = new Monitor(this);
		
	    // add button action listener
		newTaskButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				if (count < Constants.MAX_TASK_NUM) {
					// increase task count
					count++;
					countTaskField.setText(count + "");
					// add a new progress bar
					JProgressBar progressBar = addProgressBar(container);
					// create a new task
					int taskTime = 1 + (int)(Math.random() * 5); 
					Task task = createTask(taskTime);
					// register the task to the progress bar
					monitor.register(task, progressBar);
				}
			}
		});
	    
		// set window property
		setTitle("Just Another App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		setVisible(true);
	}
	
	private JProgressBar addProgressBar(Container container) {
		// add a progress bar
		JProgressBar progressBar = new JProgressBar(0, 100);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		container.add(progressBar);
		
		// resize the window
		//pack();
		setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT+Constants.TASK_HEIGHT*count);
		
		return progressBar;
	}
	
	private Task createTask(int second) {
		Task task = new Task(second);
		return task;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public JTextField getCountTaskField() {
		return countTaskField;
	}

	public void setCountTaskField(JTextField countTaskField) {
		this.countTaskField = countTaskField;
	}

	public JButton getNewTaskButton() {
		return newTaskButton;
	}

	public void setNewTaskButton(JButton newTaskButton) {
		this.newTaskButton = newTaskButton;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
