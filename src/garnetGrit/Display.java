//3

package garnetGrit;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Display {
	JFrame jframe;
	DefaultTableModel model = new DefaultTableModel();
	
	Display() {
		jframe = new JFrame("Users");
		jframe.setSize(1180, 400);
		
		// table headings
		
		model.addColumn("First Name");
		model.addColumn("Last Name");
		model.addColumn("Gender");
		model.addColumn("Address");
		model.addColumn("Contact");
		model.addColumn("Roll no");
		model.addColumn("Program");
		model.addColumn("Java");
		model.addColumn("Math");
		model.addColumn("English");
		model.addColumn("Macro Economics");
		
		
		JButton viewButton = new JButton("View Profile");
		viewButton.setBounds(0, 0, 100, 30);
		
		JTable table=new JTable(model);
		ArrayList<User> list=new ArrayList<User>();
		
		FileOperation fo= new FileOperation();
		list=fo.readFile();
		
		
		//table body
		
		for(User user: list) {
			model.addRow(new Object[]{ user.getFirstName(),
				user.getLastName(),
				user.getGender(),
				user.getAddress(),
				user.getContact(),
				user.getRollNo(),
				user.getProgram(),
				user.getJava(),
				user.getMath(),
				user.getEnglish(),
				user.getEconomics(),
				});
		}
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		table.setBounds(30, 40, 600, 600);
		
		JScrollPane sp = new JScrollPane(table);
		jframe.add(sp);
		jframe.setVisible(true);
		
	}
	
	
}
