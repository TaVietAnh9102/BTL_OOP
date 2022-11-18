package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.IconUIResource;
import javax.swing.text.IconView;

import org.w3c.dom.ls.LSException;

import models.Item;
import models.Member;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

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
		panel.setBounds(91, 36, 638, 432);
		add(panel);
		panel.setLayout(null);
		initLabels();
		initFields();
	}
	
	
	
	private void initLabels() {
		avatar = new JLabel("Avatar");
		avatar.setBounds(20, 35, 148, 184);
		panel.add(avatar);
		avatar.setIcon(getIcon(148, 184, "/pic/VAB.jpg"));
		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(236, 55, 96, 32);
		panel.add(firstNameLabel);
		firstNameLabel.setFont(LABEL_FONT);
		firstNameLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		firstNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setBounds(236, 110, 96, 32);
		panel.add(lastNameLabel);
		lastNameLabel.setFont(LABEL_FONT);
		lastNameLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		lastNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		emailLabel = new JLabel("Email");
		emailLabel.setBounds(236, 165, 96, 32);
		panel.add(emailLabel);
		emailLabel.setFont(LABEL_FONT);
		emailLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		genderLabel = new JLabel("Gender");
		genderLabel.setBounds(236, 220, 96, 32);
		panel.add(genderLabel);
		genderLabel.setFont(LABEL_FONT);
		genderLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		genderLabel.setHorizontalAlignment(SwingConstants.LEFT);;
		
		birthDayLabel = new JLabel("Birth Day");
		birthDayLabel.setBounds(236, 275, 96, 32);
		panel.add(birthDayLabel);
		birthDayLabel.setFont(LABEL_FONT);
		birthDayLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		birthDayLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		phoneLabel = new JLabel("Phone");
		phoneLabel.setBounds(236, 330, 96, 32);
		panel.add(phoneLabel);
		phoneLabel.setFont(LABEL_FONT);
		phoneLabel.setForeground(LABEL_FORE_GROUND_COLOR);
		phoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
	}
	
	private void initFields() throws ParseException {
		
		firstNameField = new JTextField(20);
		firstNameField.setEditable(false);
		firstNameField.setBounds(342, 55, 175, 32);
		panel.add(firstNameField);
		firstNameField.setText(member.getFname());
		firstNameField.setFont(FIELD_FONT);
		
		lastNameField = new JTextField();
		lastNameField.setEditable(false);
		lastNameField.setBounds(342, 110, 175, 32);
		panel.add(lastNameField);
		lastNameField.setText(member.getLname());
		lastNameField.setFont(FIELD_FONT);
		
		emailField = new JTextField();
		emailField.setEditable(false);
		emailField.setBounds(340, 165, 175, 32);
		panel.add(emailField);
		emailField.setText(member.getEmail());
		emailField.setFont(FIELD_FONT);
		
		
		phoneField = new JTextField();
		phoneField.setEditable(false);
		phoneField.setBounds(340, 330, 175, 32);
		panel.add(phoneField);
		phoneField.setText(member.getPhone());
		phoneField.setFont(FIELD_FONT);
		
		genderField = new JTextField();
		genderField.setEditable(false);
		genderField.setBounds(340, 220, 175, 32);
		panel.add(genderField);
		genderField.setText((member.getGender()==0)?"Male":"Female");
		genderField.setFont(FIELD_FONT);
		genderField.setColumns(10);
		
		birthDateField = new JTextField();
		birthDateField.setEditable(false);
		birthDateField.setBounds(340, 275, 175, 32);
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
