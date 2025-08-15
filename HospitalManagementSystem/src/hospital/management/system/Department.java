package hospital.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Department extends JFrame
{
	Department()
	{
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 690, 490);
		panel.setLayout(null);
		panel.setBackground(new Color(90, 156, 163));
		add(panel);
		
		JTable table = new JTable();
		table.setBounds(0, 40, 700, 350);
		table.setBackground(new Color(90, 156, 163));
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(table);
		
		try 
		{
			Connections c = new Connections();
			String q = "select * from department";
			ResultSet resultSet = c.statement.executeQuery(q);
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		JLabel label1 = new JLabel("Department");
		label1.setBounds(145, 11, 105, 20);
		label1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(label1);
		
		JLabel label2 = new JLabel("Phone Number");
		label2.setBounds(350, 11, 150, 20);
		label2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(label2);
		
		JButton b1 = new JButton("Back");
		b1.setBounds(400, 410, 130, 30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		panel.add(b1);
		
		b1.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
			}
		});
		
		setUndecorated(true);
		setSize(700, 500);
		setLayout(null);
		setLocation(350, 250);
		setVisible(true);

	}
	public static void main(String args[])
	{
		new Department();
	}
}
