package Tools;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class MyBorder{
	private Border border=null;
	
	public MyBorder() {
		border=BorderFactory.createLineBorder(Color.black, 2);
	}
	
	public Border getMyBorder() { 
		return border;
	}
}
