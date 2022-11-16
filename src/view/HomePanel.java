package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JScrollPane;
import javax.swing.JViewport;

import models.Category;
import models.Item;

import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.RenderingHints.Key;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class HomePanel extends JPanel {
	
	private JPanel categoryPanel;
	private HashMap<String, ItemTableScrollPane> tabs;
	private String currentTab;
	private ActionListener itemListener;
	private ActionListener categoryListener;
	
	public HomePanel(ActionListener itemListener, ActionListener categoryListener) {
		setLayout(null);
		setBounds(152, 87, 810, 505);
		initCategoryScroll();
		tabs = new HashMap<>();
		this.itemListener = itemListener;
		this.categoryListener = categoryListener;
		currentTab = "All";
		addCategory(new Category(-1, "All", "admin"));
	}
	
	
	public void initCategoryScroll() {
		JScrollPane scrollPaneCategory = new JScrollPane();
		scrollPaneCategory.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPaneCategory.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneCategory.setBounds(40, 0, 730, 35);
		
		
		JButton moveLeft = new JButton("<");
		moveLeft.setBorderPainted(false);
		moveLeft.setBorder(new EmptyBorder(0, 0, 0, 0));
		moveLeft.setForeground(new Color(93,97,140));
		moveLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JViewport vp = scrollPaneCategory.getViewport();
				Point current = vp.getViewPosition();
				Point next = new Point(Math.max((int)current.getX()-25, 0 ) , (int)current.getY()); 
				vp.setViewPosition(next);
			}
		});
		moveLeft.setFont(new Font("Arial", Font.BOLD, 10));
		moveLeft.setBounds(0, 0, 40, 35);
		add(moveLeft);
		
		JButton moveRight = new JButton(">");
		moveRight.setBorderPainted(false);
		moveRight.setBorder(new EmptyBorder(0, 0, 0, 0));
		moveRight.setForeground(new Color(93,97,140));
		moveRight.setBackground(new Color(255, 255, 255));
		moveRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JViewport vp = scrollPaneCategory.getViewport();
				Point current = vp.getViewPosition();
				Point next = new Point((int)current.getX() + 25, (int)current.getY()); 
				vp.setViewPosition(next);
			}
		});
		moveRight.setFont(new Font("Arial", Font.BOLD, 10));
		moveRight.setBounds(770, 0, 40, 35);
		add(moveRight);
		
		categoryPanel = new JPanel();
		categoryPanel.setBackground(new Color(255, 255, 255));
		categoryPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		categoryPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPaneCategory.setViewportView(categoryPanel);
		add(scrollPaneCategory);
	}
	
	
	public void showTab(String categoryName) {
		tabs.get(currentTab).setVisible(false);
		currentTab = categoryName;
		tabs.get(currentTab).setVisible(true);
		
	}
	
	public void addItem(List<Item> items) {
		for(Item item : items) {
			if(tabs.containsKey(item.getCatName())) {
				addItem(item);
			}
		}
	}
	
	public void addItem(Item item) {
		if(tabs.containsKey(item.getCatName())) {
			ItemPanel itemPanel = new ItemPanel(item, itemListener);
			itemPanel.setItemBidding();
			tabs.get(item.getCatName()).addItemPanel(new ItemPanel(item, itemListener));
			tabs.get("All").addItemPanel(itemPanel);
		}
		
	}
	
	public void addCategory(List<Category> categories) {
		for(Category category : categories) {
			if(!tabs.containsKey(category.getCat_Name())) {
				addCategory(category);
			}
		}
	}
	
		
	public void addCategory(Category category) {
		if(!tabs.containsKey(category.getCat_Name())) {
			JButton button = new JButton(category.getCat_Name());
			button.setPreferredSize(new Dimension(75,34));
			button.addActionListener(categoryListener);
			categoryPanel.add(button);
			button.setForeground(new Color(93,97,140));
			button.setFont(new Font("Arial", Font.BOLD, 10));
			button.setBorder(new LineBorder(new Color(93,97,140)));
			
			ItemTableScrollPane tab = new ItemTableScrollPane();
			tab.setBounds(0, 35, 810, 470);
			tab.setVisible(false);
			add(tab);
			
			tabs.put(category.getCat_Name(), tab);
		}
	}
	
}
