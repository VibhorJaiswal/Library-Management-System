package library.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Entrance extends JFrame implements ActionListener
{
	
	JPanel panel;
	JButton enter;
	JLabel rbk;

	public Entrance() 	
	{
		setBounds(300,100,400,600);
		setLayout(null);
		panel = new JPanel();
		panel.setBackground(new Color(184, 173, 173));
		setContentPane(panel);
		panel.setLayout(null);
		
		enter = new JButton("Get Started");
		enter.setBounds(120,250,150,50);
		enter.setFont(new Font("TreBuchet ms",Font.ITALIC,20));
		enter.setBackground(Color.green);
		enter.addActionListener(this);
		panel.add(enter);
		
		rbk = new JLabel("");
		rbk.setVerticalAlignment(SwingConstants.TOP);
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("library\\management\\system\\Images\\Entrance.jpg"));
		Image i8 = i7.getImage().getScaledInstance(400,600, Image.SCALE_DEFAULT);
		ImageIcon i9 = new ImageIcon(i8);
		rbk = new JLabel(i9);
		rbk.setBounds(0,0,400,600);
		panel.add(rbk);
	}
	
	
	
	public static void main(String []args)
	{
		
		new Entrance().setVisible(true);
//		user_login ul = new user_login("My Library");
//		ul.setComponents();
//		ul.setSize(600, 400);
//		ul.setVisible(true);
		new Entrance().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}



	@Override
	public void actionPerformed(ActionEvent ae) {


		if(ae.getSource() == enter)
		{
			this.setVisible(false);
			new user_login().setVisible(true);
			
		}
	}



	
}
