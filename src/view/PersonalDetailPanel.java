package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import models.Member;

public class PersonalDetailPanel extends JPanel {

	private static Font LABEL_FONT = new Font("Arial", Font.BOLD, 13);
	private static Font FIELD_FONT = new Font("Arial", Font.PLAIN, 15);
	private static Color LABEL_FORE_GROUND_COLOR = Color.BLACK;
	
	private JPanel panel;
	
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel emailLabel;
	private JLabel genderLabel;
	private JLabel birthDayLabel;
	private JLabel phoneLabel;
	private JLabel avatar;
	
	private Member member;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField genderField;
	private JTextField birthDateField;
	private JTextField emailField;
	private JTextField phoneField;
	
	 
	public PersonalDetailPanel(Member member) throws ParseException {
		this.member = member;
		setBackground(new Color(255, 255, 255));	
		setBounds(152, 87, 810, 505);
		setLayout(null);
		initComponents();
	}
	
	private void initComponents() throws ParseException {
		panel = new JPanel();
		panel.setBackground(new Color(102, 204, 255));
		panel.setBounds(60, 60, 690, 385);
		add(panel);
		panel.setLayout(null);
		initLabels();
		initFields();
	}
	
	
	
	private void initLabels() {
		avatar = new JLabel("Avatar");
		avatar.setBounds(40, 75, 230, 230);
		panel.add(avatar);
		avatar.setIcon(getIcon(avatar.getWidth(), avatar.getHeight(), "/pic/ps.png"));
		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(290, 40, 96, 32);
		panel.add(firstNameLabel);
		firstNameLabel.setFont(LABEL_FONT);
		firstNameLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		firstNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setBounds(290, 95, 96, 32);
		panel.add(lastNameLabel);
		lastNameLabel.setFont(LABEL_FONT);
		lastNameLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		lastNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		emailLabel = new JLabel("Email");
		emailLabel.setBounds(290, 150, 96, 32);
		panel.add(emailLabel);
		emailLabel.setFont(LABEL_FONT);
		emailLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		genderLabel = new JLabel("Gender");
		genderLabel.setBounds(290, 205, 96, 32);
		panel.add(genderLabel);
		genderLabel.setFont(LABEL_FONT);
		genderLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		genderLabel.setHorizontalAlignment(SwingConstants.LEFT);;
		
		birthDayLabel = new JLabel("Birth Day");
		birthDayLabel.setBounds(290, 260, 96, 32);
		panel.add(birthDayLabel);
		birthDayLabel.setFont(LABEL_FONT);
		birthDayLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		birthDayLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		phoneLabel = new JLabel("Phone");
		phoneLabel.setBounds(290, 315, 96, 32);
		panel.add(phoneLabel);
		phoneLabel.setFont(LABEL_FONT);
		phoneLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		phoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
	}
	
	private void initFields() throws ParseException {
		
		firstNameField = new JTextField(20);
		firstNameField.setEditable(false);
		firstNameField.setBounds(425, 40, 215, 32);
		panel.add(firstNameField);
		firstNameField.setText(member.getFname());
		firstNameField.setFont(FIELD_FONT);
		
		lastNameField = new JTextField();
		lastNameField.setEditable(false);
		lastNameField.setBounds(425, 95, 215, 32);
		panel.add(lastNameField);
		lastNameField.setText(member.getLname());
		lastNameField.setFont(FIELD_FONT);
		
		emailField = new JTextField();
		emailField.setEditable(false);
		emailField.setBounds(425, 155, 215, 32);
		panel.add(emailField);
		emailField.setText(member.getEmail());
		emailField.setFont(FIELD_FONT);
		
		
		phoneField = new JTextField();
		phoneField.setEditable(false);
		phoneField.setBounds(425, 315, 215, 32);
		panel.add(phoneField);
		phoneField.setText(member.getPhone());
		phoneField.setFont(FIELD_FONT);
		
		genderField = new JTextField();
		genderField.setEditable(false);
		genderField.setBounds(425, 205, 215, 32);
		panel.add(genderField);
		genderField.setText((member.getGender()==0)?"Male":"Female");
		genderField.setFont(FIELD_FONT);
		genderField.setColumns(10);
		
		birthDateField = new JTextField();
		birthDateField.setEditable(false);
		birthDateField.setBounds(425, 260, 215, 32);
		panel.add(birthDateField);
		birthDateField.setText(member.getBirthdate());
		birthDateField.setFont(FIELD_FONT);
		birthDateField.setColumns(10);
	}
	
	
	private ImageIcon getIcon(int w, int h, String src) {
		ImageIcon icon = new ImageIcon(PersonalDetailPanel.class.getResource(src));
		Image image = icon.getImage();
		Image imgScale = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		return new ImageIcon(imgScale);
	}
	
}
