package hospital.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;

import javax.print.attribute.PrintJobAttribute;
import javax.swing.*;
import javax.xml.xpath.XPathEvaluationResult.XPathResultType;

public class Patient_Discharge extends JFrame
{
	Patient_Discharge()
	{
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 790, 390);
		panel.setLayout(null);
		panel.setBackground(new Color(90, 156, 163));
		add(panel);
		
		JLabel label1 = new JLabel("Check-Out :");
		label1.setBounds(100, 20, 150, 20);
		label1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label1.setForeground(Color.WHITE);
		panel.add(label1);
		
		JLabel label2 = new JLabel("Customer Id :");
		label2.setBounds(30, 80, 150, 20);
		label2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label2.setForeground(Color.WHITE);
		panel.add(label2);
		
		Choice choice = new Choice();
		choice.setBounds(200, 80, 150, 25);
		panel.add(choice);
		
		try 
		{
			Connections connection = new Connections();
			ResultSet resultSet = connection.statement.executeQuery("select * from Patient_Info");
			while(resultSet.next())
			{
				choice.add(resultSet.getString("number"));
			}
		} 
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}
		
		JLabel label3 = new JLabel("Room Number :");
		label3.setBounds(30, 130, 150, 20);
		label3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label3.setForeground(Color.WHITE);
		panel.add(label3);
		
		JLabel RNo = new JLabel();
		RNo.setBounds(200, 130, 150, 20);
		RNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		RNo.setForeground(Color.WHITE);
		panel.add(RNo);
		
		JLabel label4 = new JLabel("In Time :");
		label4.setBounds(30, 180, 150, 20);
		label4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label4.setForeground(Color.WHITE);
		panel.add(label4);
		
		JLabel InTime = new JLabel();
		InTime.setBounds(200, 180, 250, 20);
		InTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		InTime.setForeground(Color.WHITE);
		panel.add(InTime);
		
		JLabel label5 = new JLabel("Out Time :");
		label5.setBounds(30, 230, 150, 20);
		label5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label5.setForeground(Color.WHITE);
		panel.add(label5);
		
		Date date = new Date();
		
		JLabel OutTime = new JLabel("" + date);
		OutTime.setBounds(200, 230, 230, 20);
		OutTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		OutTime.setForeground(Color.WHITE);
		panel.add(OutTime);
		
		JButton discharge = new JButton("Discharge");
		discharge.setBounds(30, 300, 120, 30);
		discharge.setBackground(Color.BLACK);
		discharge.setForeground(Color.WHITE);
		panel.add(discharge);
		discharge.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Connections connection = new Connections();
				try 
                {
					connection.statement.executeUpdate("delete from Patient_Info where number = '"+choice.getSelectedItem()+"'");
					connection.statement.executeUpdate("update room set Availability = 'Available' where room_no = '"+RNo.getText()+"'");
					JOptionPane.showMessageDialog(null, "Done");
					setVisible(false);
				} 
                catch (Exception e2) 
                {
					e2.printStackTrace();
				}
			}
		}); 
		
		JButton check = new JButton("Check");
		check.setBounds(170, 300, 120, 30);
		check.setBackground(Color.BLACK);
		check.setForeground(Color.WHITE);
		panel.add(check);
		check.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Connections connections = new Connections();
				try 
                {
					ResultSet rs = connections.statement.executeQuery("select * from Patient_Info where number = '"+choice.getSelectedItem()+"'");
					while(rs.next())
					{
						RNo.setText(rs.getString("Room_Number"));
						InTime.setText(rs.getString("Time"));
					}
				} 
                catch (Exception e3) 
                {
					e3.printStackTrace();
				}
			}
		}); 
		
		JButton back = new JButton("Back");
		back.setBounds(310, 300, 120, 30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		panel.add(back);
		back.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
			}
		});
		
		setUndecorated(true);
		setSize(800, 400);
		setLayout(null);
		setLocation(400, 250);
		setVisible(true);
	}
	public static void main(String[] args) 
	{
		new Patient_Discharge();
	}
}
