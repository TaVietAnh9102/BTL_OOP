package view;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class SubmitItemPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	public SubmitItemPanel() {
		setBounds(152, 87, 800, 505);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(30, 29, 167, 196);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(273, 40, 135, 29);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(427, 40, 216, 29);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(273, 219, 135, 29);
		add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(427, 221, 216, 50);
		add(textArea);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(273, 91, 135, 29);
		add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(429, 96, 214, 29);
		add(textField_1);
		textField_1.setColumns(10);
		
	}
}
