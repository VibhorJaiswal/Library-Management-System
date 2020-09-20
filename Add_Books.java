package library.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Add_Books extends JFrame implements ActionListener
{
	JPanel panel;
	JLabel bkid,name,isbn,publisher,edition,price,pages;
	JTextField ubkid,uname,uisbn,upublisher,uedition,uprice,upages;
	JButton add,back;
	
	
	public Add_Books() 	
	{
		setBounds(450,150,350,500);
		setLayout(null);
		panel = new JPanel();
		panel.setBackground(new Color(184, 173, 173));
		setContentPane(panel);
		panel.setLayout(null);
		
		bkid = new JLabel("Book ID:");
		bkid.setBounds(50,50,100,20);
		panel.add(bkid);
		
		ubkid = new JTextField();
		ubkid.setBounds(150,50,150,20);
		Random r = new Random();
		long random = r.nextInt(1000000);
		ubkid.setText(""+random);
		panel.add(ubkid);
		
		name = new JLabel("Name:");
		name.setBounds(50,90,100,20);
		panel.add(name);
		
		uname = new JTextField();
		uname.setBounds(150,90,150,20);
		panel.add(uname);
		
		isbn = new JLabel("ISBN:");
		isbn.setBounds(50,130,100,20);
		panel.add(isbn);
		
		uisbn = new JTextField();
		uisbn.setBounds(150,130,150,20);
		panel.add(uisbn);

		publisher = new JLabel("Publisher:");
		publisher.setBounds(50,170,100,20);
		panel.add(publisher);
		
		upublisher = new JTextField();
		upublisher.setBounds(150,170,150,20);
		panel.add(upublisher);
		
		edition = new JLabel("Edition:");
		edition.setBounds(50,210,100,20);
		panel.add(edition);
		
		uedition = new JTextField();
		uedition.setBounds(150,210,150,20);
		panel.add(uedition);
		
		price = new JLabel("Price:");
		price.setBounds(50,250,100,20);
		panel.add(price);
		
		uprice = new JTextField();
		uprice.setBounds(150,250,150,20);
		panel.add(uprice);
		
		pages = new JLabel("Pages:");
		pages.setBounds(50,290,100,20);
		panel.add(pages);
		
		upages = new JTextField();
		upages.setBounds(150,290,150,20);
		panel.add(upages);
		
		add = new JButton("Add");
		add.setBounds(70,350,100,30);
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add.addActionListener(this);
		panel.add(add);
		
		back = new JButton("Back");
		back.setBounds(200,350,100,30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		panel.add(back);
		
	}
	

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == back)
		{
			this.setVisible(false);
			new Main_Page().setVisible(true);
			
		}
		else if(ae.getSource() == add)
		{
			
			try {
				
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","");
				PreparedStatement pst = cn.prepareStatement("insert into book values(?,?,?,?,?,?,?)");
				
				
				pst.setInt(1,new Integer(ubkid.getText()));
				pst.setString(2,uname.getText());
				pst.setString(3,uisbn.getText());
				pst.setString(4,upublisher.getText());
				pst.setString(5,uedition.getText());
				pst.setInt(6,new Integer(uprice.getText()));
				pst.setInt(7,new Integer(upages.getText()));
				
				pst.executeUpdate();
				
				JOptionPane.showMessageDialog(null,"Book Added");
				
				
				Random rr = new Random();
				long random1 = rr.nextInt(1000000);
				
				ubkid.setText(""+random1);
				uname.setText("");
				uisbn.setText("");
				upublisher.setText("");
				uedition.setText("");
				uprice.setText("");
				upages.setText("");
				
				
				
				
			}
			catch(SQLIntegrityConstraintViolationException sss)
			{
				JOptionPane.showMessageDialog(null,"This book ID is not available");
			}
			catch(NumberFormatException nfe) 
			{
				JOptionPane.showMessageDialog(null,"Fill All Field Correctly");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	
	
	
	public static void main(String []args)
	{
		
		new Add_Books().setVisible(true);
//		user_login ul = new user_login("My Library");
//		ul.setComponents();
//		ul.setSize(600, 400);
//		ul.setVisible(true);
		new Add_Books().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
