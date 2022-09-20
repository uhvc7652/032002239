package Tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyLabelButton extends JLabel implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8092579434837358600L;
	public void mouseClicked(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
		this.setBackground(Color.white);
		this.setForeground(Color.black);
	}
	public void mouseReleased(MouseEvent e) {
		this.setBackground(Color.black);
		this.setForeground(Color.white);
	}
	public void mouseEntered(MouseEvent e) {
		this.setBackground(Color.black);
		this.setForeground(Color.white);
	}
	public void mouseExited(MouseEvent e) {
		this.setBackground(Color.white);
		this.setForeground(Color.black);
	}
	public MyLabelButton(int x,int y,int wid,int hei,String text) {
		this.setVisible(true);
		this.setBounds(x, y, wid, hei);
		this.setText(text);
		this.setBackground(Color.white);
		this.setForeground(Color.black);
		this.setFont(new Font("楷体", Font.BOLD, 30));
		this.setBorder(new MyBorder().getMyBorder());
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setOpaque(true);
		this.addMouseListener(this);
	}
	public MyLabelButton(String text) {
		this.setVisible(true);
		this.setText(text);
		this.setBackground(Color.white);
		this.setForeground(Color.black);
		this.setFont(new Font("楷体", Font.BOLD, 30));
		this.setBorder(new MyBorder().getMyBorder());
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setOpaque(true);
		this.addMouseListener(this);
	}
	public MyLabelButton(int x,int y,int wid,int hei,Icon icon) {
		this.setVisible(true);
		this.setBounds(x, y, wid, hei);
		this.setIcon(icon);
		this.setBackground(Color.white);
		this.setForeground(Color.black);
		this.setFont(new Font("楷体", Font.BOLD, 30));
		this.setBorder(new MyBorder().getMyBorder());
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setOpaque(true);
		this.addMouseListener(this);
	}
	public MyLabelButton(String text,int size) {
		this.setVisible(true);
		this.setText(text);
		this.setBackground(Color.white);
		this.setForeground(Color.black);
		this.setFont(new Font("楷体", Font.BOLD, size));
		this.setBorder(new MyBorder().getMyBorder());
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setOpaque(true);
		this.addMouseListener(this);
	}
	
}
