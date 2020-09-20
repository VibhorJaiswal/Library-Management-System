package library.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class forgot_pass extends JFrame implements ActionListener
{

	JPanel panel;
	JLabel usrname, name, question,answer, password;
	JTextField username,uname,uques,ans,pass;
	JButton search,retrieve, back;
	
	
	public forgot_pass() {
	
		setBounds(400,150,550, 450);
		setLayout(null);
		panel = new JPanel();
		panel.setBackground(new Color(184, 173, 173));
		setContentPane(panel);
		panel.setLayout(null);
		
		usrname = new JLabel("Username:");
		usrname.setBounds(50,100,100,20);
		panel.add(usrname);
		
		username = new JTextField();
		username.setBounds(200,100,150,20);
		panel.add(username);
		
		search = new JButton("Search");
		search.setBounds(400,95,100,30);
		search.setBackground(Color.BLACK);
		search.setForeground(Color.WHITE);
		search.addActionListener(this);
		panel.add(search);
		
		name = new JLabel("Name:");
		name.setBounds(50,140,100,20);
		panel.add(name);
		
		uname = new JTextField();
		uname.setBounds(200,140,150,20);
		uname.setEditable(false);
		panel.add(uname);
		
		question = new JLabel("Security Question:");
		question.setBounds(50,180,150,20);
		panel.add(question);
		
		uques = new JTextField();
		uques.setBounds(200,180,150,20);
		uques.setEditable(false);
		panel.add(uques);
		
		answer = new JLabel("Answer:");
		answer.setBounds(50,220,100,20);
		panel.add(answer);
		
		ans = new JTextField();
		ans.setBounds(200,220,150,20);
		panel.add(ans);
		
		retrieve = new JButton("Retrieve");
		retrieve.setBounds(400,215,100,30);
		retrieve.setBackground(Color.BLACK);
		retrieve.setForeground(Color.WHITE);
		retrieve.addActionListener(this);
		panel.add(retrieve);
		
		password = new JLabel("Password:");
		password.setBounds(50,260,100,20);
		panel.add(password);
		
		pass = new JTextField();
		pass.setBounds(200,260,150,20);
		pass.setEditable(false);
		panel.add(pass);
		
		back = new JButton("Back");
		back.setBounds(190,350,100,30);
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		panel.add(back);	
		back.addActionListener(this);
		
		
}
	
	
	
	public static void main(String []args)
	{
		
		new forgot_pass().setVisible(true);
//		forgot_pass fs = new forgot_pass("My Library");
//		fs.setComponents();
//		fs.setSize(550, 450);
//		fs.setVisible(true);
		new forgot_pass().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == back)
		{
			this.setVisible(false);
			new user_login().setVisible(true);
			
		}
		else if(ae.getSource() == search)
		{
			
			try
			{
				
				
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","");
				PreparedStatement pst = cn.prepareStatement("select * from acc where username = ?");
				
				pst.setString(1,username.getText());
				
				
				ResultSet rs = pst.executeQuery();
				
				rs.next();
				
				uname.setText(rs.getString("name"));
				uques.setText(rs.getString("ques"));
				
				cn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == retrieve)
		{
			try {
				
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","");
				PreparedStatement pst = cn.prepareStatement("select ans from acc where username = ?");
				
				pst.setString(1,username.getText());
				
				ResultSet rs = pst.executeQuery();
				
				rs.next();
				
				String check = rs.getString("ans");
				
				if(check.equals(ans.getText()))
				{
					pass.setText(check);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Answer does not Match");
				}
				
				cn.close();
				
			}
			catch(SQLException e)
			{
				JOptionPane.showMessageDialog(null,"Account Not Created");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	
}
