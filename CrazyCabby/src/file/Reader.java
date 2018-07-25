package file;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Reader {
	private ArrayList<player> data = new ArrayList<player>();
	private JPanel p ;
	private JFrame f ;
	String name = null;
	int score;
	public Reader(JPanel f, int score, JFrame fa) {
		p =f;
		this.f = fa;
		
		this.score = score;
		readFile();
	}
	public void readFile() {
		String line = null;
		Scanner s = null;
		
			try {
			s =new Scanner(new File("/home/jwax/eclipse-workspace/CrazyCabby/src/file/highScores"));
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			while(s.hasNextLine()) {
			String name = s.nextLine();
			int num = Integer.parseInt(s.nextLine());
				data.add(new player(name,num));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Collections.sort(data, new Sort());
		
		s.close();
		addData();
		
	}
	public void addData() {
		for(int x = 0 ; x<data.size();x++) {
			if(x == 5) {
				break;
			}
			else {
				p.add(new JLabel(data.get(x).getName() + " "+data.get(x).getScore()));
			}
		}
		
		addWriter();
	}
	public void exit() {
		this.f.dispose();
	}
	public void addWriter() {
	JTextField f = new JTextField();
	JButton j = new JButton();
	j.setText("SubMit");
	j.setSize(20, 20);
	f.setMinimumSize(new Dimension(10,30));
	j.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(!f.getText().isEmpty())
			 name = f.getText();
			 try {
				 if(name != null) {
					BufferedWriter r = new BufferedWriter(new FileWriter("/home/jwax/eclipse-workspace/CrazyCabby/src/file/highScores",true));
					if(data.size()>0) {
					r.newLine();
					r.write(name);
					r.newLine();
					r.write(Integer.toString(score));
					r.close();
					exit();
					}
					else {
						r.write(name);
						r.newLine();
						r.write(Integer.toString(score));
						r.close();
						exit();
					}
				 }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	});
		
		
		p.add(f);
		p.add(j);
		
	}
	public ArrayList<player> getData() {
		return data;
	}
	
}

