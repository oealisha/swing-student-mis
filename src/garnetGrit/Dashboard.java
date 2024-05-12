
//2

package garnetGrit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import java.awt.Font;
//import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.Writer;

public class Dashboard implements ActionListener {

	Dashboard(){
		JFrame jframe=new JFrame("Dashboard");
		jframe.setSize(600,300);
		
		//creating obj for two button
		
		JButton addUser=new JButton("Add User");
		JButton displayUser=new JButton("Display User");
		
		addUser.addActionListener(this);
		displayUser.addActionListener(this);
		
		addUser.setBounds(30,70,200,40);
		displayUser.setBounds(280,70,200,40);
		
	 jframe.add(displayUser);
	 jframe.add(addUser);
	 jframe.setLayout(null);
	 jframe.setVisible(true);
	 	
	}
	
	public static void main(String[]args) {
		new Dashboard();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Add User") {
			UserForm userForm = new UserForm();
		}else if(e.getActionCommand() == "Display User") {
			Display display = new Display();
		}
	}
}
