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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class user_login extends JFrame implements ActionListener {

	JPanel panel;
	JButton login,signup,forgot;
	JLabel l1, l2,l3;
	JPasswordField pass;
	JTextField uname;
	
	public user_login() 	
	{
		setBounds(400,150,600,400);
		setLayout(null);
		panel = new JPanel();
		panel.setBackground(new Color(184, 173, 173));
		setContentPane(panel);
		panel.setLayout(null);
		
		l1 = new JLabel("Username:");
		l1.setBounds(120,50,100,100);
		panel.add(l1);
		
		uname = new JTextField();
		uname.setBounds(220,90,150,20);
		panel.add(uname);
		
		l2 = new JLabel("Password:");
		l2.setBounds(120,100,100,100);
		panel.add(l2);
		
		pass = new JPasswordField();
		pass.setBounds(220,140,150,20);
		panel.add(pass);
		
		login = new JButton("Login");
		login.setBounds(160,200,100,30);
		login.setBackground(Color.green);
		login.setForeground(Color.white);
		login.addActionListener(this);
		login.setFont(new Font("TreBuchet ms",Font.ITALIC,17));
		panel.add(login);
		
		signup = new JButton("Sign Up");
		signup.setBounds(300,200,100,30);
		signup.setBackground(Color.blue);
		signup.setForeground(Color.white);
		signup.addActionListener(this);
		signup.setFont(new Font("TreBuchet ms",Font.ITALIC,17));
		panel.add(signup);
		
		forgot = new JButton("Forgot Password");
		forgot.setBackground(Color.MAGENTA);
		forgot.setForeground(Color.white);
		forgot.setBounds(200,250,170,30);
		forgot.setFont(new Font("TreBuchet ms",Font.ITALIC,17));
		forgot.addActionListener(this);
		panel.add(forgot);
		
	}
	
	
	
	public static void main(String []args)
	{
		
		new user_login().setVisible(true);
//		user_login ul = new user_login("My Library");
//		ul.setComponents();
//		ul.setSize(600, 400);
//		ul.setVisible(true);
		new user_login().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}



	@Override
	public void actionPerformed(ActionEvent ae) {


		if(ae.getSource() == forgot)
		{
			this.setVisible(false);
			new forgot_pass().setVisible(true);
			
		}
		else if(ae.getSource() == signup)
		{
			this.setVisible(false);
			new user_signup().setVisible(true);
			
		}
		else if(ae.getSource() == login)
		{
			
			try {
				
				
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","");
				PreparedStatement pst = cn.prepareStatement("select pass from acc where username = ?");
				
				pst.setString(1, uname.getText());
				
				ResultSet rs = pst.executeQuery();
				
				rs.next();
				
				String check = ""+rs.getString("pass");
				String test =new String(pass.getPassword());
				
				if(test.equals(check))
				{
				
					this.setVisible(false);
					new Main_Page().setVisible(true);
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Username and Password does not match");
					pass.setText("");
					uname.setText("");
				}
				cn.close();
			}
			catch(SQLException e)
			{
				JOptionPane.showMessageDialog(null,"Account Not Created");
				pass.setText("");
				uname.setText("");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
	}
}
