package library.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

public class user_signup extends JFrame implements ActionListener {
	
	JPanel panel;
	JButton create,back;
	JTextField uname, username, uanswer;
	JComboBox ques;
	JPasswordField pass;
	JLabel usrname,name,password,question,answer;
	
	
	public user_signup() {}
	
	{
		setBounds(400,150,500, 400);
		setLayout(null);
		panel = new JPanel();
		panel.setBackground(new Color(184, 173, 173));
		setContentPane(panel);
		panel.setLayout(null);
		
		name = new JLabel("Name");
		name.setBounds(70,60,100,20);
		panel.add(name);
		
		uname = new JTextField();
		uname.setBounds(200,60,150,20);
		panel.add(uname);
		
		usrname = new JLabel("Username");
		usrname.setBounds(70,100,100,20);
		panel.add(usrname);
		
		username = new JTextField();
		username.setBounds(200,100,150,20);
		panel.add(username);
		
		password = new JLabel("Password");
		password.setBounds(70,140,100,20);
		panel.add(password);
		
		pass = new JPasswordField();
		pass.setBounds(200,140,150,20);
		panel.add(pass);
		
		question = new JLabel("Security Question");
		question.setBounds(70,180,150,20);
		panel.add(question);
		
		
		String[] questions = {"First Mobile No." , "Your Pet Name", "Favourite Dish"};
		ques = new JComboBox(questions);
		ques.setBounds(200,180,150,20);
		panel.add(ques);		
		
		answer = new JLabel("Answer");
		answer.setBounds(70,220,150,20);
		panel.add(answer);
		
		uanswer = new JTextField();
		uanswer.setBounds(200,220,150,20);
		panel.add(uanswer);
		
		create = new JButton("Create");
		create.setBounds(100,300,100,30);
		create.addActionListener(this);
		create.setForeground(Color.white);
		create.setBackground(Color.black);
		create.setFont(new Font("TreBuchet ms",Font.ITALIC,17));
		panel.add(create);
		
		back = new JButton("Back");
		back.setBounds(250,300,100,30);
		back.addActionListener(this);
		back.setForeground(Color.white);
		back.setBackground(Color.black);
		back.setFont(new Font("TreBuchet ms",Font.ITALIC,17));
		panel.add(back);
	}

	public static void main(String []args)
	{
		
		new user_signup().setVisible(true);
//		user_login ul = new user_login("My Library");
//		ul.setComponents();
//		ul.setSize(600, 400);
//		ul.setVisible(true);
		new user_signup().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		user_signup us = new user_signup("My Library");
//		us.setComponents();
//		us.setSize(500, 600);
//		us.setVisible(true);
//		us.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {


		if(ae.getSource() == back)
		{
			this.setVisible(false);
			new user_login().setVisible(true);
			
		}
		else if(ae.getSource() == create)
		{
			try {
				
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","");
					PreparedStatement pst = cn.prepareStatement("insert into acc values (?,?,?,?,?)");
					
					String s1 = username.getText();
					pst.setString(1,s1);
					
					String s2 = uname.getText();
					pst.setString(2, s2);
					

					String s3 = new String( pass.getPassword());
					pst.setString(3,s3);
					
					String s4 = (String)ques.getSelectedItem();
					pst.setString(4,s4);
					
					pst.setString(5,uanswer.getText());
					
					
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Account Created Successfully... ");


					this.setVisible(false);
					new user_login().setVisible(true);
					
			
			}
			catch(SQLIntegrityConstraintViolationException e)
			{
				JOptionPane.showMessageDialog(null,"Username Taken... ");
			}
			catch(CommunicationsException ce)
			{
				JOptionPane.showMessageDialog(null,"Server Down! Contact Admin...");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
