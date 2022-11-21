package view;

import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
//set limit jtextfield
public class JTextFieldLimit extends PlainDocument {
	private int limit;

	JTextFieldLimit(int limit) {
//		super();
		this.limit = limit;
	}

	
	
	public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
		//if (str == null) return;

		if ((getLength() + str.length()) > limit) {
			str = str.substring(0, limit - getLength());
			
		}
		super.insertString(offset, str, attr);
	}
}