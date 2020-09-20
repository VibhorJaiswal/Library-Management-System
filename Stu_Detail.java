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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import net.proteanit.sql.DbUtils;

public class Stu_Detail  extends JFrame implements ActionListener
{

	
	
	JPanel panel;
	JButton back, search, delete;
	JTextField text;
	JTable table;
	JScrollPane scrollpane;
	
	
	public Stu_Detail() {
		
		
		setBounds(300,100,800,600);
		setLayout(null);
		panel = new JPanel();
		panel.setBackground(new Color(184, 173, 173));
		setContentPane(panel);
		panel.setLayout(null);
		
		back = new JButton("Back");
		back.setBounds(10,5,100,30);
		back.setForeground(Color.white);
		back.setBackground(Color.BLACK);
		back.setFont(new Font("TreBuchet ms",Font.ITALIC,17));
		back.addActionListener(this);
		panel.add(back);
		
		text  = new JTextField();
		text.setBounds(10,50,500,30);
		text.setFont(new Font("TreBuchet ms",Font.ITALIC,17));
		panel.add(text);
		
		search = new JButton("Search");
		search.setBounds(520,50,100,30);
		search.setForeground(Color.white);
		search.setBackground(Color.black);
		search.setFont(new Font("TreBuchet ms",Font.ITALIC,17));
		search.addActionListener(this);
		panel.add(search);
		
		delete = new JButton("Delete");
		delete.setBounds(640,50,100,30);
		delete.setForeground(Color.white);
		delete.setBackground(Color.black);
		delete.setFont(new Font("TreBuchet ms",Font.ITALIC,17));
		delete.addActionListener(this);
		panel.add(delete);
		
		scrollpane =new JScrollPane();
		scrollpane.setBounds(10,120,750,400);
		panel.add(scrollpane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter()
				
				{
					public void mouseClicked(MouseEvent me)
					{
						int i = table.getSelectedRow();
						text.setText(table.getModel().getValueAt(i, 1).toString());
					}
			
				});
		
		scrollpane.setViewportView(table);
		
		
		try
		{
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","");
			PreparedStatement pst = cn.prepareStatement("select * from student");
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			cn.close();
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

	public static void main(String[] args) {
		
		new Stu_Detail().setVisible(true);
//		user_login ul = new user_login("My Library");
//		ul.setComponents();
//		ul.setSize(600, 400);
//		ul.setVisible(true);
		new Stu_Detail().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	@Override
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource() == back)
		{
			this.setVisible(false);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			new Main_Page().setVisible(true);
			
		}
		else if(ae.getSource() == delete)
		{
			try {
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","");
			PreparedStatement pst = cn.prepareStatement("delete from student where name = ?");
			
			pst.setString(1, text.getText());
			
			pst.execute();
			JOptionPane.showMessageDialog(null,"Student Removed");
			cn.close();
			
			try
			{
				Connection cn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","");
				PreparedStatement pst1 = cn1.prepareStatement("select * from student");
				ResultSet rs = pst1.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				cn1.close();
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
			catch(CommunicationsException ce)
			{
				JOptionPane.showMessageDialog(null,"Server Down! Contact Admin...");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == search)
		{
			
			try
			{
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","");
				PreparedStatement pst = cn.prepareStatement("select * from student where name = ?");
				
				pst.setString(1,text.getText());
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				cn.close();
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
