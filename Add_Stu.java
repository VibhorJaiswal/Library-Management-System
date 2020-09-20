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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Add_Stu extends JFrame implements ActionListener
{

	
	
	JPanel panel;
	JLabel sid,name,fname,course,branch,year,sem;
	JTextField usid,uname,ufname,ubranch;
	JComboBox ucourse,uyear,usem;
	JButton add,back;
	
	
	public Add_Stu() 
	{

		setBounds(450,150,350,500);
		setLayout(null);
		panel = new JPanel();
		panel.setBackground(new Color(184, 173, 173));
		setContentPane(panel);
		panel.setLayout(null);
		
		sid = new JLabel("Student ID:");
		sid.setBounds(50,50,100,20);
		panel.add(sid);
		
		usid = new JTextField();
		usid.setBounds(150,50,150,20);
		Random r = new Random();
		long random = r.nextInt(1000000);
		usid.setText(""+random);
		panel.add(usid);
		
		name = new JLabel("Name:");
		name.setBounds(50,90,100,20);
		panel.add(name);
		
		uname = new JTextField();
		uname.setBounds(150,90,150,20);
		panel.add(uname);
		
		fname = new JLabel("Father's Name:");
		fname.setBounds(50,130,100,20);
		panel.add(fname);
		
		ufname = new JTextField();
		ufname.setBounds(150,130,150,20);
		panel.add(ufname);

		course = new JLabel("Course:");
		course.setBounds(50,170,100,20);
		panel.add(course);
		
		String[] opt = {"B.E." , "B Tech","M.. Tech","MBA","BBA", "Poly"};
		ucourse = new JComboBox(opt);
		ucourse.setBounds(150,170,150,20);
		panel.add(ucourse);
		
		branch = new JLabel("Branch:");
		branch.setBounds(50,210,100,20);
		panel.add(branch);
		
		ubranch = new JTextField();
		ubranch.setBounds(150,210,150,20);
		panel.add(ubranch);
		
		year = new JLabel("Year:");
		year.setBounds(50,250,100,20);
		panel.add(year);
		
		String[] opt1 = {"First","Second","Third","Fourth"};
		uyear = new JComboBox(opt1);
		uyear.setBounds(150,250,150,20);
		panel.add(uyear);
		
		sem = new JLabel("Semester:");
		sem.setBounds(50,290,100,20);
		panel.add(sem);
		
		String[] opt2 = {"1","2","3","4","5","6","7","8"};
		usem = new JComboBox(opt2);
		usem.setBounds(150,290,150,20);
		panel.add(usem);
		
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

	public static void main(String[] args) {
		

		new Add_Stu().setVisible(true);
//		Add_Stu ul = new Add_Stu("My Library");
//		ul.setComponents();
//		ul.setSize(600, 400);
//		ul.setVisible(true);
		new Add_Stu().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
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
				PreparedStatement pst = cn.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
				
				pst.setInt(1,new Integer(usid.getText()));
				pst.setString(2,uname.getText());
				pst.setString(3,ufname.getText());
				pst.setString(4,(String)ucourse.getSelectedItem());
				pst.setString(5,ubranch.getText());
				pst.setString(6, (String)uyear.getSelectedItem());
				pst.setString(7,(String)usem.getSelectedItem());
				
pst.executeUpdate();
				
				JOptionPane.showMessageDialog(null,"Student Registered");
				
				
				Random rr = new Random();
				long random1 = rr.nextInt(1000000);
				
				usid.setText(""+random1);
				uname.setText("");
				ufname.setText("");
				ubranch.setText("");
			}
			catch(SQLIntegrityConstraintViolationException sss)
			{
				JOptionPane.showMessageDialog(null,"This Student ID is not available");
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

}

