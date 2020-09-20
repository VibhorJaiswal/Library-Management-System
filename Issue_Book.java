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
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import com.toedter.calendar.JDateChooser;

public class Issue_Book extends JFrame implements ActionListener
{
	
	JPanel panel;
	JLabel bkid,bkname,isbn,publisher,edition,price,pages,stuid,sname,fname,course,branch,year,sem,date;
	JTextField ubkid,ubkname,uisbn,upublisher,uedition,uprice,upages,ustuid,usname,ufname,ucourse,ubranch,uyear,usem;
	JButton bk_search,stu_search,issue,back;
	JDateChooser udate;
	
	public Issue_Book() 	
	{
		setBounds(300,100,900,600);
		setLayout(null);
		panel = new JPanel();
		panel.setBackground(new Color(184, 173, 173));
		setContentPane(panel);
		panel.setLayout(null);
		
		bkid = new JLabel("Book ID:");
		bkid.setBounds(20,30,100,20);
		panel.add(bkid);
		
		ubkid = new JTextField();
		ubkid.setBounds(140,30,150,20);
		panel.add(ubkid);
		
		bk_search = new JButton("Search");
		bk_search.setBounds(300,25,100,30);
		bk_search.setFont(new Font("TreBuchet ms",Font.ITALIC,17));
		bk_search.setForeground(Color.white);
		bk_search.setBackground(Color.black);
		bk_search.addActionListener(this);
		panel.add(bk_search);
		
		bkname = new JLabel("Name:");
		bkname.setBounds(20,70,100,20);
		panel.add(bkname);
		
		ubkname = new JTextField();
		ubkname.setBounds(140,70,150,20);
		ubkname.setEditable(false);
		panel.add(ubkname);
		
		isbn = new JLabel("ISBN:");
		isbn.setBounds(20,110,100,20);
		panel.add(isbn);
		
		uisbn = new JTextField();
		uisbn.setBounds(140,110,150,20);
		uisbn.setEditable(false);
		panel.add(uisbn);
		
		publisher = new JLabel("Publisher:");
		publisher.setBounds(20,150,100,20);
		panel.add(publisher);
		
		upublisher = new JTextField();
		upublisher.setBounds(140,150,150,20);
		upublisher.setEditable(false);
		panel.add(upublisher);
		
		edition = new JLabel("Edition:");
		edition.setBounds(20,190,100,20);
		panel.add(edition);
		
		uedition = new JTextField();
		uedition.setBounds(140,190,150,20);
		uedition.setEditable(false);
		panel.add(uedition);
		
		price = new JLabel("Price:");
		price.setBounds(20,230,100,20);
		panel.add(price);
		
		uprice = new JTextField();
		uprice.setBounds(140,230,150,20);
		uprice.setEditable(false);
		panel.add(uprice);
		
		pages = new JLabel("Pages:");
		pages.setBounds(20,270,100,20);
		panel.add(pages);
		
		upages = new JTextField();
		upages.setBounds(140,270,150,20);
		upages.setEditable(false);
		panel.add(upages);
		
		stuid = new JLabel("Student ID:");
		stuid.setBounds(450,30,100,20);
		panel.add(stuid);
		
		ustuid = new JTextField();
		ustuid.setBounds(570,30,150,20);
		panel.add(ustuid);
		
		stu_search = new JButton("Search");
		stu_search.setBounds(730,25,100,30);
		stu_search.setFont(new Font("TreBuchet ms",Font.ITALIC,17));
		stu_search.setForeground(Color.white);
		stu_search.setBackground(Color.black);
		stu_search.addActionListener(this);
		panel.add(stu_search);
		
		sname = new JLabel("Name:");
		sname.setBounds(450,70,100,20);
		panel.add(sname);
		
		usname = new JTextField();
		usname.setBounds(570,70,150,20);
		usname.setEditable(false);
		panel.add(usname);
		
		fname = new JLabel("Father's Name:");
		fname.setBounds(450,110,100,20);
		panel.add(fname);
		
		ufname = new JTextField();
		ufname.setBounds(570,110,150,20);
		ufname.setEditable(false);
		panel.add(ufname);
		
		course = new JLabel("Course:");
		course.setBounds(450,150,100,20);
		panel.add(course);
		
		ucourse = new JTextField();
		ucourse.setBounds(570,150,150,20);
		ucourse.setEditable(false);
		panel.add(ucourse);
		
		branch = new JLabel("Branch:");
		branch.setBounds(450,190,100,20);
		panel.add(branch);
		
		ubranch = new JTextField();
		ubranch.setBounds(570,190,150,20);
		ubranch.setEditable(false);
		panel.add(ubranch);
		
		year = new JLabel("Year:");
		year.setBounds(450,230,100,20);
		panel.add(year);
		
		uyear = new JTextField();
		uyear.setBounds(570,230,150,20);
		uyear.setEditable(false);
		panel.add(uyear);
		
		sem = new JLabel("Semester:");
		sem.setBounds(450,270,100,20);
		panel.add(sem);
		
		usem = new JTextField();
		usem.setBounds(570,270,150,20);
		usem.setEditable(false);
		panel.add(usem);
		
		date = new JLabel("Date Of Issue:");
		date.setBounds(200,350,200,20);
		panel.add(date);
		
		udate = new JDateChooser();
		udate.setBounds(300,350,150,20);
		panel.add(udate);
		
		issue = new JButton("Issue");
		issue.setBounds(250,400,100,30);
		issue.setFont(new Font("TreBuchet ms",Font.ITALIC,17));
		issue.setForeground(Color.white);
		issue.setBackground(Color.black);
		issue.addActionListener(this);
		panel.add(issue);
		
		back = new JButton("Back");
		back.setBounds(360,400,100,30);
		back.setFont(new Font("TreBuchet ms",Font.ITALIC,17));
		back.setForeground(Color.white);
		back.setBackground(Color.black);
		back.addActionListener(this);
		panel.add(back);
	}
	
	
	
	
	public static void main(String []args)
	{
		
		new Issue_Book().setVisible(true);
//		user_login ul = new user_login("My Library");
//		ul.setComponents();
//		ul.setSize(600, 400);
//		ul.setVisible(true);
		new Issue_Book().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}




	@Override
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource() == back)
		{
			this.setVisible(false);
			new Main_Page().setVisible(true);
			
		}
		else if(ae.getSource() == bk_search)
		{
			try {
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","");
				PreparedStatement pst = cn.prepareStatement("select * from book where book_id = ?");
				
				pst.setInt(1,new Integer(ubkid.getText()));
				
				ResultSet rs = pst.executeQuery();
				
				rs.next();
				
				ubkname.setText(rs.getString("name"));
				uisbn.setText(rs.getString("isbn"));
				upublisher.setText(rs.getString("publisher"));
				uedition.setText(rs.getString("edition"));
				uprice.setText(rs.getString("price"));
				upages.setText(rs.getString("pages"));
				
				
				
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
		else if(ae.getSource() == stu_search)
		{
			try {
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","");
				PreparedStatement pst = cn.prepareStatement("select * from student where stu_id = ?");
				
				pst.setInt(1,new Integer(ustuid.getText()));
				
				ResultSet rs = pst.executeQuery();
				
				rs.next();
				
				usname.setText(rs.getString("name"));
				ufname.setText(rs.getString("fname"));
				ucourse.setText(rs.getString("course"));
				ubranch.setText(rs.getString("branch"));
				uyear.setText(rs.getString("year"));
				usem.setText(rs.getString("sem"));
				
				
				
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
		else if(ae.getSource() == issue)
		{
			try {
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","");
				PreparedStatement pst = cn.prepareStatement("insert into issuebook values (?,?,?,?,?,?,?)");
				
				pst.setInt(1,new Integer(ubkid.getText()));
				pst.setInt(2, new Integer(ustuid.getText()));
				pst.setString(3,ubkname.getText());
				pst.setString(4,usname.getText());
				pst.setString(5,ucourse.getText());
				pst.setString(6,ubranch.getText());
				pst.setString(7,((JTextField) udate.getDateEditor().getUiComponent()).getText());
				
				pst.executeUpdate();
				
				JOptionPane.showMessageDialog(null,"Book Issued");
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
	}

}
