package library.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import com.toedter.calendar.JDateChooser;

public class Return_Book extends JFrame implements ActionListener
{
	
	JPanel panel;
	JLabel bkid,stuid,bk,name,course,branch,dateiss,dateret;
	JTextField ubkid,ubk,ustuid,uname,ucourse,ubranch,udateiss;
	JButton search,retrn,back;
	JDateChooser udateret;
	
	public Return_Book() 	
	{
		setBounds(300,200,700,350);
		setLayout(null);
		panel = new JPanel();
		panel.setBackground(new Color(184, 173, 173));
		setContentPane(panel);
		panel.setLayout(null);
		
		bkid = new JLabel("Book ID:");
		bkid.setBounds(20,50,100,20);
		panel.add(bkid);
		
		ubkid = new JTextField();
		ubkid.setBounds(120,50,150,20);
		panel.add(ubkid);
		
		bk = new JLabel("Book Name:");
		bk.setBounds(20,90,100,20);
		panel.add(bk);
		
		ubk = new JTextField();
		ubk.setBounds(120,90,150,20);
		ubk.setEditable(false);
		panel.add(ubk);
		
		course = new JLabel("Course:");
		course.setBounds(20,130,100,20);
		panel.add(course);
		
		ucourse = new JTextField();
		ucourse.setBounds(120,130,150,20);
		ucourse.setEditable(false);
		panel.add(ucourse);
		
		stuid = new JLabel("Student ID:");
		stuid.setBounds(300,50,100,20);
		panel.add(stuid);
		
		ustuid = new JTextField();
		ustuid.setBounds(400,50,150,20);
		panel.add(ustuid);
		
		search = new JButton("Search");
		search.setBounds(560,45,100,30);
		search.setForeground(Color.white);
		search.setBackground(Color.black);
		search.setFont(new Font("TreBuchet ms",Font.ITALIC,17));
		search.addActionListener(this);
		panel.add(search);
		
		name = new JLabel("Name:");
		name.setBounds(300,90,100,20);
		panel.add(name);
		
		uname = new JTextField();
		uname.setBounds(400,90,150,20);
		uname.setEditable(false);
		panel.add(uname);
		
		branch = new JLabel("Branch:");
		branch.setBounds(300,130,100,20);
		panel.add(branch);
		
		ubranch = new JTextField();
		ubranch.setBounds(400,130,150,20);
		ubranch.setEditable(false);
		panel.add(ubranch);
		

		dateiss = new JLabel("Date of Issue:");
		dateiss.setBounds(20,170,150,20);
		panel.add(dateiss);
		
		udateiss = new JTextField();
		udateiss.setBounds(120,170,150,20);
		udateiss.setEditable(false);
		panel.add(udateiss);
		
		dateret = new JLabel("Date of Return:");
		dateret.setBounds(300,170,150,20);
		panel.add(dateret);
		
		udateret = new JDateChooser();
		udateret.setBounds(400,170,150,20);
		panel.add(udateret);
		
		retrn = new JButton("Return");
		retrn.setBounds(200,250,100,30);
		retrn.setForeground(Color.white);
		retrn.setBackground(Color.black);
		retrn.setFont(new Font("TreBuchet ms",Font.ITALIC,17));
		retrn.addActionListener(this);
		panel.add(retrn);
		
		back = new JButton("Back");
		back.setBounds(310,250,100,30);
		back.setForeground(Color.white);
		back.setBackground(Color.black);
		back.setFont(new Font("TreBuchet ms",Font.ITALIC,17));
		back.addActionListener(this);
		panel.add(back);
		
	}
	
	
	public static void main(String []args)
	{
		
		new Return_Book().setVisible(true);
//		user_login ul = new user_login("My Library");
//		ul.setComponents();
//		ul.setSize(600, 400);
//		ul.setVisible(true);
		new Return_Book().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent ae) {


		if(ae.getSource() == back)
		{
			this.setVisible(false);
			new Main_Page().setVisible(true);
			
		}
		else if(ae.getSource() == search)
		{
			try {
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","");
				PreparedStatement pst = cn.prepareStatement("select * from issuebook where stuid = ? and bkid = ?");
				
				pst.setInt(1,new Integer (ustuid.getText()));
				pst.setInt(2,new Integer (ubkid.getText()));
				
				ResultSet rs = pst.executeQuery();
				
				rs.next();
				
				ubk.setText(rs.getString("bkname"));
				ucourse.setText(rs.getString("course"));
				udateiss.setText(rs.getString("date_of_iss"));
				
				uname.setText(rs.getString("stuname"));
				ubranch.setText(rs.getString("branch"));
				
				
				
				
				
			}
			catch(NumberFormatException ne)
			{
				JOptionPane.showMessageDialog(null,"Invalid ID");
			}
			catch(CommunicationsException ce)
			{
				JOptionPane.showMessageDialog(null,"Server Down! Contact Admin...");
			}
			catch(SQLException se)
			{
				JOptionPane.showMessageDialog(null,"Incorrect ID");
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else if(ae.getSource() == retrn)
		{
			try {
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","");
				PreparedStatement pst = cn.prepareStatement("insert into returnbk values (?,?,?,?,?,?,?,?)");
				PreparedStatement pst1 = cn.prepareStatement("delete from issuebook where bkid = ? and stuid = ?");
				
//				pst.setInt(1,new Integer (ustuid.getText()));
//				pst.setInt(2,new Integer (ubkid.getText()));
//				
//				ResultSet rs = pst.executeQuery();
//				
//				rs.next();
//				
//				ubk.setText(rs.getString("bkname"));
//				ucourse.setText(rs.getString("course"));
//				udateiss.setText(rs.getString("date_of_iss"));
//				
//				uname.setText(rs.getString("stuname"));
// 				ubranch.setText(rs.getString("branch"));
				
				pst.setInt(1,new Integer(ubkid.getText()));
				pst.setInt(2, new Integer(ustuid.getText()));
				pst.setString(3,ubk.getText());
				pst.setString(4,uname.getText());
				pst.setString(5,ucourse.getText());
				pst.setString(6,ubranch.getText());
				pst.setString(7, udateiss.getText());
				pst.setString(8,((JTextField) udateret.getDateEditor().getUiComponent()).getText());
				
				pst1.setInt(1, new Integer( ubkid.getText()));
				pst1.setInt(2, new Integer(ustuid.getText()));
				
				
				pst.executeUpdate();
				pst1.executeUpdate();
				
				JOptionPane.showMessageDialog(null,"Book Returned");
				
				
			}
			catch(NumberFormatException ne)
			{
				JOptionPane.showMessageDialog(null,"Invalid ID");
			}
			catch(CommunicationsException ce)
			{
				JOptionPane.showMessageDialog(null,"Server Down! Contact Admin...");
			}
			catch(SQLException se)
			{
				se.printStackTrace();
				//JOptionPane.showMessageDialog(null,"Incorrect ID");
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
	}

}
