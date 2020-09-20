package library.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Statics extends JFrame implements ActionListener {
	
	
	
	JPanel panel;
	JTable iss , ret;
	JButton back;
	JScrollPane scrollpane1 , scrollpane2;
	JLabel issue,retrn;
	JTable table,table1;

	public Statics() 	
	{
		setBounds(300,50,800,700);
		setLayout(null);
		panel = new JPanel();
		panel.setBackground(new Color(184, 173, 173));
		setContentPane(panel);
		panel.setLayout(null);
		
		issue = new JLabel("Issue Details");
		issue.setBounds(300,10,200,30);
		issue.setFont(new Font("TreBuchet ms",Font.ITALIC,30));
		panel.add(issue);
		
		retrn = new JLabel("Return Details");
		retrn.setBounds(300,310,200,30);
		retrn.setFont(new Font("TreBuchet ms",Font.ITALIC,30));
		panel.add(retrn);
		
		
		scrollpane1 =new JScrollPane();
		scrollpane1.setBounds(10,50,750,250);
		panel.add(scrollpane1);
		
		scrollpane2 =new JScrollPane();
		scrollpane2.setBounds(10,350,750,250);
		panel.add(scrollpane2);
		
		
		
		table = new JTable();		
		scrollpane1.setViewportView(table);
		
		
		try
		{
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","");
			PreparedStatement pst = cn.prepareStatement("select * from issuebook");
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			cn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		table1 = new JTable();		
		scrollpane2.setViewportView(table1);
		
		
		try
		{
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","");
			PreparedStatement pst = cn.prepareStatement("select * from returnbk");
			ResultSet rs = pst.executeQuery();
			table1.setModel(DbUtils.resultSetToTableModel(rs));
			cn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		back = new JButton("Back");
		back.setBounds(350,610,100,30);
		back.setForeground(Color.white);
		back.setBackground(Color.BLACK);
		back.setFont(new Font("TreBuchet ms",Font.ITALIC,17));
		back.addActionListener(this);
		panel.add(back);
		
	}
	
	
	public static void main(String []args)
	{
		
		new Statics().setVisible(true);
//		user_login ul = new user_login("My Library");
//		ul.setComponents();
//		ul.setSize(600, 400);
//		ul.setVisible(true);
		new Statics().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == back)
		{
			this.setVisible(false);
			new Main_Page().setVisible(true);
			
		}
		
	}


}
