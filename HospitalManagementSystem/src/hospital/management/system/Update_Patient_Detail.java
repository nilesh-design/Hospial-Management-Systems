package hospital.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Update_Patient_Detail extends JFrame
{
	public Update_Patient_Detail() 
	{
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 940, 490);
		panel.setLayout(null);
		panel.setBackground(new Color(90, 156, 163));
		add(panel);
		
		ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/updated.png"));
		Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		ImageIcon imageIcon1 = new ImageIcon(image);
		JLabel label = new JLabel(imageIcon1);
		label.setBounds(500, 60, 300, 300);
		panel.add(label);
		
		JLabel label1 = new JLabel("Update Patient Details");
		label1.setBounds(124, 11, 260, 25);
		label1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label1.setForeground(Color.WHITE);
		panel.add(label1);
		
		JLabel label2 = new JLabel("Name : ");
		label2.setBounds(25, 88, 100, 20);
		label2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label2.setForeground(Color.WHITE);
		panel.add(label2);  
		
		Choice choice = new Choice();
		choice.setBounds(280, 85, 140, 25);
		panel.add(choice);
		
		try 
		{
			Connections connection = new Connections();
			ResultSet resultSet = connection.statement.executeQuery("select * from Patient_Info");
			while(resultSet.next())
			{
				choice.add(resultSet.getString("Name"));
			}
		} 
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}
		
		JLabel label3 = new JLabel("Room Number : ");
		label3.setBounds(25, 129, 150, 20);
		label3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label3.setForeground(Color.WHITE);
		panel.add(label3);  
		
		JTextField textFieldR = new JTextField();
		textFieldR.setBounds(280, 129, 140, 20);
		panel.add(textFieldR);
		
		JLabel label4 = new JLabel("In-Time : ");
		label4.setBounds(25, 174, 100, 20);
		label4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label4.setForeground(Color.WHITE);
		panel.add(label4);  
		
		JTextField textFieldInTime = new JTextField();
		textFieldInTime.setBounds(280, 174, 140, 20);
		panel.add(textFieldInTime);
		
		JLabel label5 = new JLabel("Amount Paid (Rs) : ");
		label5.setBounds(25, 216, 180, 20);
		label5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label5.setForeground(Color.WHITE);
		panel.add(label5);  
		
		JTextField textFieldAmount = new JTextField();
		textFieldAmount.setBounds(280, 216, 140, 20);
		panel.add(textFieldAmount);
		
		JLabel label6 = new JLabel("Pending Amount (Rs) : ");
		label6.setBounds(25, 261, 210, 25);
		label6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label6.setForeground(Color.WHITE);
		panel.add(label6);  
		
		JTextField textFieldPending = new JTextField();
		textFieldPending.setBounds(280, 261, 140, 20);
		panel.add(textFieldPending);
		
		JButton check = new JButton("Check");
		check.setBounds(281, 378, 89, 23);
		check.setBackground(Color.BLACK);
		check.setForeground(Color.WHITE);
		panel.add(check);
		check.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String id = choice.getSelectedItem();
				String q = "select * from Patient_Info where name = '"+id+"'";
				try 
                {
					Connections connections = new Connections();
					ResultSet resultSet = connections.statement.executeQuery(q);
					while (resultSet.next()) 
					{
						textFieldR.setText(resultSet.getString("Room_Number"));
						textFieldInTime.setText(resultSet.getString("Time"));
						textFieldAmount.setText(resultSet.getString("Deposite"));
					}
					
					ResultSet resultSet1 = connections.statement.executeQuery("select * from room where room_no = '"+textFieldR.getText()+"'");
					while (resultSet1.next()) 
					{
						String price = resultSet1.getString("Price");
						int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
						textFieldPending.setText(""+amountPaid);
					}
				} 
                catch (Exception e2) 
                {
					e2.printStackTrace();
				}
			}
		}); 
		
		JButton update = new JButton("Update");
		update.setBounds(56, 378, 89, 23);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		panel.add(update);
		update.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try 
                {
					Connections connections = new Connections();
					String q = choice.getSelectedItem();
					String room = textFieldR.getText();
					String time = textFieldInTime.getText();
					String amount = textFieldAmount.getText();
					connections.statement.executeUpdate("update Patient_Info set Room_Number = '"+room+"', Time = '"+time+"', Deposite = '"+amount+"' where name = '"+q+"'");
					
					JOptionPane.showMessageDialog(null, "Updated Successfully");
					setVisible(false);
				} 
                catch (Exception e2) 
                {
					e2.printStackTrace();
				}
			}
		}); 
		
		JButton back = new JButton("Back");
		back.setBounds(168, 378, 89, 23);
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
		setSize(950, 500);
		setLayout(null);
		setLocation(400, 250);
		setVisible(true);
	}
	public static void main(String[] args) 
	{
		new Update_Patient_Detail();
	}
}
