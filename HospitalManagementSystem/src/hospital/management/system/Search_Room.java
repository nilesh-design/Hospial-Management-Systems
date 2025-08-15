package hospital.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Search_Room extends JFrame
{
	Search_Room() 
	{
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 690, 490);
		panel.setLayout(null);
		panel.setBackground(new Color(90, 156, 163));
		add(panel);
		
		JLabel search = new JLabel("Search For Room");
		search.setBounds(250, 11, 186, 31);
		search.setFont(new Font("Tahoma", Font.BOLD, 20));
		search.setForeground(Color.WHITE);
		panel.add(search);
		
		JLabel status = new JLabel("Status : ");
		status.setBounds(70, 70, 80, 20);
		status.setFont(new Font("Tahoma", Font.BOLD, 14));
		status.setForeground(Color.WHITE);
		panel.add(status);
		
		Choice choice = new Choice();
		choice.setBounds(170, 70, 120, 20);
		choice.add("Available");
		choice.add("Occupied");
		panel.add(choice);
		
		JTable table = new JTable();
		table.setBounds(0, 150, 700, 210);
		table.setBackground(new Color(90, 156, 163));
		table.setForeground(Color.white);
		panel.add(table);
		
		try 
		{
			Connections connection = new Connections();
			String qString = "select * from room";
			ResultSet resultSet = connection.statement.executeQuery(qString);
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		JLabel label1 = new JLabel("Room Number");
		label1.setBounds(0, 120, 150, 20);
		label1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label1.setForeground(Color.WHITE);
		panel.add(label1);
		
		JLabel label2 = new JLabel("Availability");
		label2.setBounds(175, 120, 150, 20);
		label2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label2.setForeground(Color.WHITE);
		panel.add(label2);
		
		JLabel label3 = new JLabel("Price");
		label3.setBounds(350, 120, 150, 20);
		label3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label3.setForeground(Color.WHITE);
		panel.add(label3);
		
		JLabel label4 = new JLabel("Bed Type");
		label4.setBounds(528, 120, 150, 20);
		label4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label4.setForeground(Color.WHITE);
		panel.add(label4);
		
		JButton button = new JButton("Search");
		button.setBounds(160, 420, 120, 20);
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		panel.add(button);
		button.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String q = "select * from Room where Availability = '"+choice.getSelectedItem()+"'";
				try 
                {
					Connections connections = new Connections();
					ResultSet resultSet = connections.statement.executeQuery(q);
					table.setModel(DbUtils.resultSetToTableModel(resultSet));
				} 
                catch (Exception e2) 
                {
					e2.printStackTrace();
				}
			}
		}); 
		
		JButton back = new JButton("Back");
		back.setBounds(380, 420, 120, 25);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		panel.add(back);
		back.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String q = "select * from Room where Availability = '"+choice.getSelectedItem()+"'";
				try 
                {
					setVisible(false);
				} 
                catch (Exception e2) 
                {
					e2.printStackTrace();
				}
			}
		}); 
		
		setUndecorated(true);
		setSize(700, 500);
		setLayout(null);
		setLocation(450, 250);
		setVisible(true);
	}
	public static void main(String[] args) 
	{
		new Search_Room();
	}
}