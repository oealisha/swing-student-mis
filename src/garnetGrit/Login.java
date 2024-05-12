package garnetGrit;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login implements ActionListener {
	JFrame jframe;
	JTextField nameField;
	JTextField passwordField;
	

	Login(){		
		jframe=new JFrame("Register/Login");
		
		jframe.setSize(400,300);
		
		JButton jbuttonL=new JButton("Login");
		JButton jbuttonR=new JButton("Register");
		
		jbuttonL.setBounds(50,180,100,30);
		jbuttonR.setBounds(160,180,100,30);
		
		JLabel name=new JLabel("Username:");
		JLabel password =new JLabel("Password:");
		
		name.setBounds(20,20,80,30);
		password.setBounds(20,90,100,30);
		
		nameField=new JTextField();
		passwordField=new JTextField();
		
		nameField.setBounds(120,20,120,30);
		passwordField.setBounds(120,90,120,30);
		
		jbuttonL.addActionListener(this); // this refers to current object i.e login object
		jbuttonR.addActionListener(this);
		
		
		
		jframe.add(jbuttonL);
		jframe.add(jbuttonR);
		jframe.add(passwordField);
		jframe.add(nameField);
		jframe.add(name);
		jframe.add(password);
		
		jframe.setLayout(null);
		jframe.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		Login login = new Login();
	}
	
	public void actionPerformed(ActionEvent e) {
		String username = nameField.getText().toString();
		String password = passwordField.getText().toString();
		
//		When user registers, put their username and password [BufferedWriter, FileWriter]
		if(e.getActionCommand()=="Register") {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("./login.txt"));
				bw.write(username + ' ' + password);
				bw.close();
				JOptionPane.showMessageDialog(null, "Successfully registered!", "Authentication", JOptionPane.INFORMATION_MESSAGE);
			}catch(IOException err) {
				err.printStackTrace();
			}
			
			
		}else if(e.getActionCommand() == "Login") {
//		When user logins, check their input user name and password with file data [BufferedReader, FileReader]
			try {
				BufferedReader br = new BufferedReader(new FileReader("./login.txt"));
				String text = br.readLine();
				String[] credentials = text.split(" ");
				
				if(credentials[0].equals(username) && credentials[1].equals(password)) {
					JOptionPane.showMessageDialog(null, "Successfully Login!", "Authentication", JOptionPane.INFORMATION_MESSAGE);
					jframe.dispose(); // closes current j frame i.e Login ko JFrame
					Dashboard dashboard = new Dashboard();
				}else {
					JOptionPane.showMessageDialog(null, "Your credentials is incorrect!", "Authentication", JOptionPane.WARNING_MESSAGE);
				}
		
				System.out.println(credentials);
			}catch(IOException err) {
				err.printStackTrace();
			}
			
		}
	}
}
