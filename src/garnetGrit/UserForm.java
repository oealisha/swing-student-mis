package garnetGrit;

import java.awt.FlowLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserForm implements ActionListener{
	
	JButton btnAdd;
	JButton btnCancel;
	
	JTextField txtFName;
	JTextField txtLName;
	JTextField txtProgram;
	JTextField txtGender;
	JTextField txtBook;
	
	JTextField txtAddress;
	JTextField txtContact;
	JTextField txtRollNo;
	//JTextField txtMarks;
	JTextField txtJava;
	JTextField txtMath;
	JTextField txtEnglish;
	JTextField txtEconomics;
	
	JRadioButton radioMale;
	JRadioButton radioFemale;
	
	JComboBox comboProgram;
	JComboBox comboSection;
	JFrame jf ;
	public UserForm(){
		jf = new JFrame("Library Management System");
		JPanel pp = new JPanel();
		
		JPanel p1 = new JPanel();
		
		FlowLayout fl = new FlowLayout(FlowLayout.LEFT,10,10);
		GridLayout gl = new GridLayout(13,2,10,10);
		
		pp.setLayout(gl);			
		p1.setLayout(fl);		//top,left,bottom,right
		pp.setBorder(new EmptyBorder(10, 10, 10, 15));
		
		/*
		 * Address
		 * Contact
		 * Roll No
		 * Marks [ Java, Math, English, Economics]
		 */
				
		//creating components	
		JLabel lblFName = new JLabel("First Name:");
		JLabel lblLName = new JLabel("Last Name");
		JLabel lblProgram = new JLabel("Program:");
		JLabel lblGender = new JLabel("Gender");
		//JLabel lblBook = new JLabel("Book Taken:");
		JLabel lblSection = new JLabel("Section");
		JLabel lblAddress = new JLabel("Address:");
		JLabel lblContact = new JLabel("Contact:");
		JLabel lblRollNo = new JLabel("RollNo:");
		JLabel lblMath= new JLabel("Math:");
		JLabel lblJava= new JLabel("Java:");
		JLabel lblEnglish = new JLabel("English:");
		JLabel lblEconomics = new JLabel("Economics:");
		
		
		 txtFName = new JTextField(10);
		 txtLName = new JTextField(10);
		 txtBook = new JTextField(10);
		 txtAddress=new JTextField();
		 txtContact = new JTextField(10);
		 txtRollNo = new JTextField(10);
		 txtJava = new JTextField(10);
		 txtMath=new JTextField();
		 txtEnglish = new JTextField(10);
		 txtEconomics = new JTextField(10);
		 
		
		
		radioMale = new JRadioButton("Male");
		radioFemale = new JRadioButton("Female");
		
		p1.add(radioMale);
		p1.add(radioFemale);
		
		ButtonGroup rg =new ButtonGroup();
		rg.add(radioMale);
		rg.add(radioFemale);
		
		
		String section[] = {"Maxthon","Mozilla","Deism","Divine","Enum","Efika","Fusion","Fourier","Grit/Garnet"};
		
		comboProgram = new JComboBox();
		comboProgram.addItem("BBA");
		comboProgram.addItem("BBA-TT");
		comboProgram.addItem("BCIS");
		comboProgram.addItem("BBA-BI");
		
		comboSection = new JComboBox(section);
		
		btnAdd=new JButton("Add");
		btnCancel=new JButton("Cancel");
		
		lblFName.setSize(100, 30);
		txtFName.setSize(160, 30);
		lblLName.setSize(100, 30);	
		txtLName.setSize(160, 30);
		lblGender.setSize(100, 30);
		p1.setSize(160, 30);
		lblProgram.setSize(100, 30);	
		comboProgram.setSize(160, 30);
		lblSection.setSize(100, 30);	
		comboSection.setSize(160, 30);
//		lblBook.setSize(100, 30);
//		txtBook.setSize(160, 30);
		
		btnAdd.setSize(100,30);
		btnCancel.setSize(100,30);
		
		
		pp.add(lblFName);
		pp.add(txtFName);
		pp.add(lblLName);
		pp.add(txtLName);
		pp.add(lblGender);
		pp.add(p1);
		pp.add(lblProgram);
		pp.add(comboProgram);
		pp.add(lblSection);
		pp.add(comboSection);
		pp.add(lblAddress);
		pp.add(txtAddress);
		pp.add(lblContact);
		pp.add(txtContact);
		pp.add(lblRollNo);
		pp.add(txtRollNo);
		pp.add(lblJava);
		pp.add(txtJava);
		pp.add(lblEnglish);
		pp.add(txtEnglish);
		pp.add(lblMath);
		pp.add(txtMath);
		pp.add(lblEconomics);
		pp.add(txtEconomics);
		
//		pp.add(lblBook);
//		pp.add(txtBook);
		
		pp.add(btnAdd);
		pp.add(btnCancel);
		
			
		btnAdd.addActionListener(this);//registering action listener
		btnCancel.addActionListener(this);//registering action listener
		
		
		jf.setContentPane(pp); // finally adding jpanel(child container) to parent container
		jf.setSize(400,600); //setting size of the from to be displayed
		jf.setVisible(true); //enabling the jframe to be displayed
	}
	
//	public static void main(String[] args) {
//		UserForm userForm = new UserForm();
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnAdd) {
			String fName= txtFName.getText().toString();
			String lName= txtLName.getText().toString();
			
			String gender=null;
			if(radioMale.isSelected()) {
				gender="male";
			}else {
				gender="female";
			}
			String program= (String) comboProgram.getSelectedItem();
			String section= (String) comboSection.getSelectedItem();
			try {
				Writer writer = new FileWriter("D://dashboard.txt",true);
				//write username and password to a file
				writer.write(fName+"\t"+lName+"\t"+gender+"\t"+program+"\t"+section+"\n");
				writer.flush();
				writer.close();				
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}		
			
		}else if(e.getActionCommand()=="Display") {
			String fname;
			String lname,gender,program,section;			
			String line = null;
			try {
				BufferedReader reader = new BufferedReader(new FileReader("D://dashboard.txt"));
				line =reader.readLine();
				//while(line!=null) {
				String credintials[] = line.split("\t");
				fname=credintials[0];
				lname=credintials[1];
				gender=credintials[2];
				program=credintials[3];
				section=credintials[4];				
			    JOptionPane.showMessageDialog(null,fname+"\t"+lname+"\t"+gender+"\t"+program+"\t"+section,"Status",JOptionPane.INFORMATION_MESSAGE);										
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		}else if(e.getActionCommand()=="Cancel") {
			jf.dispose();
			
		}
		
	}
	

}

