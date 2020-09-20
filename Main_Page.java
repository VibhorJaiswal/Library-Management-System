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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Main_Page extends JFrame implements ActionListener
{
	JPanel panel;
	JLabel bk,sta,stu,nbk,rbk;
	JButton adbk , issue , retrn , adstu , statics;
	JMenu exit;
	JMenuItem logout,bdetail,sdetail;
	JMenuBar menu;
	
	
	public Main_Page() 	
	{
		setBounds(300,100,800,600);
		setLayout(null);
		panel = new JPanel();
		panel.setBackground(new Color(184, 173, 173));
		setContentPane(panel);
		panel.setLayout(null);
		
		
		menu = new JMenuBar();
		menu.setBounds(120,20,500,30);
		panel.add(menu);
		
		JMenu record = new JMenu("Record");
		record.setFont(new Font("TreBuchet ms",Font.ITALIC,17));
		
		 sdetail = new JMenuItem("Student Detail");
		 sdetail.setFont(new Font("TreBuchet ms",Font.ITALIC,17));
		 sdetail.addActionListener(this);
		record.add(sdetail);
		
		 bdetail = new JMenuItem("Book Detail");
		 bdetail.addActionListener(this);
		 bdetail.setFont(new Font("TreBuchet ms",Font.ITALIC,17));
		record.add(bdetail);
		
		menu.add(record);
		
		exit = new JMenu("Exit");
		exit.setFont(new Font("TreBuchet ms",Font.ITALIC,17));
		
		logout = new JMenuItem("Logout");
		exit.add(logout);
		logout.addActionListener(this);
		logout.setFont(new Font("TreBuchet ms",Font.ITALIC,17));
		menu.add(exit);
		
		bk = new JLabel("");
		bk.setVerticalAlignment(SwingConstants.TOP);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library\\management\\system\\Images\\Books.png"));
		Image i2 = i1.getImage().getScaledInstance(150,150, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		bk = new JLabel(i3);
		bk.setBounds(60,70,150,150);
		panel.add(bk);
		
		adbk = new JButton("Add Book");
		adbk.setBounds(95,240,100,30);
		adbk.setForeground(Color.white);
		adbk.setBackground(Color.black);
		adbk.addActionListener(this);
		panel.add(adbk);
		
		nbk = new JLabel("");
		nbk.setVerticalAlignment(SwingConstants.TOP);
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("library\\management\\system\\Images\\issue.png"));
		Image i5 = i4.getImage().getScaledInstance(150,150, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		nbk = new JLabel(i6);
		nbk.setBounds(300,70,150,150);
		panel.add(nbk);
		
		issue = new JButton("Issue");
		issue.setBounds(330,240,100,30);
		issue.setForeground(Color.white);
		issue.setBackground(Color.black);
		issue.addActionListener(this);
		panel.add(issue);
		
		rbk = new JLabel("");
		rbk.setVerticalAlignment(SwingConstants.TOP);
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("library\\management\\system\\Images\\return.png"));
		Image i8 = i7.getImage().getScaledInstance(150,150, Image.SCALE_DEFAULT);
		ImageIcon i9 = new ImageIcon(i8);
		rbk = new JLabel(i9);
		rbk.setBounds(540,70,150,150);
		panel.add(rbk);
		
		retrn = new JButton("Return");
		retrn.setBounds(570,240,100,30);
		retrn.setForeground(Color.white);
		retrn.setBackground(Color.black);
		retrn.addActionListener(this);
		panel.add(retrn);
		
		stu = new JLabel("");
		stu.setVerticalAlignment(SwingConstants.TOP);
		ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("library\\management\\system\\Images\\addStu.png"));
		Image i11 = i10.getImage().getScaledInstance(150,150, Image.SCALE_DEFAULT);
		ImageIcon i12 = new ImageIcon(i11);
		stu = new JLabel(i12);
		stu.setBounds(170,300,150,150);
		panel.add(stu);
		
		adstu = new JButton("Add Student");
		adstu.setBounds(190,470,120,30);
		adstu.setForeground(Color.white);
		adstu.setBackground(Color.black);
		adstu.addActionListener(this);
		panel.add(adstu);
		
		sta = new JLabel("");
		sta.setVerticalAlignment(SwingConstants.TOP);
		ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("library\\management\\system\\Images\\statics.png"));
		Image i14 = i13.getImage().getScaledInstance(150,150, Image.SCALE_DEFAULT);
		ImageIcon i15 = new ImageIcon(i14);
		sta = new JLabel(i15);
		sta.setBounds(430,300,150,150);
		panel.add(sta);
		
		statics = new JButton("Statics");
		statics.setBounds(450,470,100,30);
		statics.setForeground(Color.white);
		statics.setBackground(Color.black);
		statics.addActionListener(this);
		panel.add(statics);
		
		
	}
	
	
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == logout)
		{
			this.setVisible(false);
			new Entrance().setVisible(true);
			
		}
		else if(ae.getSource() == bdetail)
		{
			this.setVisible(false);
			new Book_Details().setVisible(true);
		}
		else if(ae.getSource() == issue)
		{
			this.setVisible(false);
			new Issue_Book().setVisible(true);
		}
		else if(ae.getSource() == adbk)
		{
			this.setVisible(false);
			new Add_Books().setVisible(true);
		}
		else if(ae.getSource() == retrn)
		{
			this.setVisible(false);
			new Return_Book().setVisible(true);
		}
		else if(ae.getSource() == sdetail)
		{
			this.setVisible(false);
			new Stu_Detail().setVisible(true);
		}
		else if(ae.getSource() == statics)
		{
			this.setVisible(false);
			new Statics().setVisible(true);
		}
		else if(ae.getSource() == adstu)
		{
			this.setVisible(false);
			new Add_Stu().setVisible(true);
		}
		
	}
	
	
	
	
	
	
	public static void main(String []args)
	{
		
		new Main_Page().setVisible(true);
//		user_login ul = new user_login("My Library");
//		ul.setComponents();
//		ul.setSize(600, 400);
//		ul.setVisible(true);
		new Main_Page().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
