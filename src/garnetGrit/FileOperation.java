package garnetGrit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileOperation {

	public FileOperation() {
		
	}
	
	// when I pass user, it should convert to string and write it to file 
	public void writeFile(User user) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("./records.txt", true));  //append =true
			bw.write(user.getFirstName() + '\t' + user.getLastName() +'\t'+ user.getGender()+ '\t'+ user.getAddress()+ '\t'+ 
					user.getContact()+ '\t'+user.getRollNo()+'\t'+  user.getProgram()+'\t'+  user.getJava()+'\t'+   user.getMath()+'\t'+
					 user.getEnglish()+'\t'+  user.getEconomics() +'\n');
			
			bw.close();
			System.out.println("User has been written.");
		}catch(IOException err) {
			err.printStackTrace();
		}
	}
	
	// when I call readFile, file lai read garera users ko value return dinu paro
	public ArrayList<User> readFile() {
		ArrayList<User> students = new ArrayList<User>(); //User ko list 
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("./records.txt")); 
			String line = br.readLine();
			 //return in array 
			
			while(line != null) {
				/* Jaba samma line hunxa (not null), taba samma hamle
				 *  record readLine garne ani class User ko object 
				 *  banayerw students list ma user object add garne */
				String[] record= line.split("\t");
				User user = new User();
				
				user.setFirstName(record[0]);
				user.setLastName(record[1]);
				user.setGender(record[2]);
				user.setAddress(record[3]);
				user.setContact(Double.parseDouble(record[4]));
				user.setRollNo(Integer.parseInt(record[5]));
				user.setProgram(record[6]);
				user.setJava(Integer.parseInt(record[7]));
				user.setMath(Integer.parseInt(record[7]));
				user.setEnglish(Integer.parseInt(record[7]));
				user.setEconomics(Integer.parseInt(record[7]));
				line = br.readLine();
				
				students.add(user);  
			}
			
			
			
			
			
			System.out.println("User has been read.");
		}catch(IOException err) {
			err.printStackTrace();
		}
		
		return students;
	}
	

}
