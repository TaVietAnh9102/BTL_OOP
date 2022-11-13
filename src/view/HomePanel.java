package view;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;

public class HomePanel extends JPanel {
	
	private JPanel mainPanel;
	private JPanel headerPanel;
	
	public HomePanel() {
		setLayout(null);
		initHeaderPanel();
		initMainPanel();
	}
	
	public void initHeaderPanel() {
		headerPanel = new JPanel();
		headerPanel.setBorder(null);
		headerPanel.setLocation(0, 0);
		headerPanel.setSize(800, 37);
		add(headerPanel);
	}
	
	public void initMainPanel() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 35, 800, 470);
		add(scrollPane);
		mainPanel = new JPanel();
		mainPanel.setBorder(null);
		mainPanel.setLayout(new WrapLayout(FlowLayout.LEFT, 10, 10));
		scrollPane.setViewportView(mainPanel);
	}
	
	public void addItem() {
		for(int i = 1; i <= 100; i++) {
			mainPanel.add(new ItemPanel());
			
		}
	}
	
	
}
