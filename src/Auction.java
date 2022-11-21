import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.LoginController;

public class Auction {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new LoginController();
	}
}
