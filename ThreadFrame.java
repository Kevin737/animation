import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreadFrame extends JFrame {

	private JButton Start, addFile, removeFile;
	private ArrayList<File> files = new ArrayList<File>(10);
	private JLabel[] labels = new JLabel[10]; 
	
	public ThreadFrame() {
		
		
		JPanel buttonPanel = new JPanel();
		JPanel filePanel = new JPanel();
		filePanel.setLocation(200, 100);
		
		addFile = new JButton("Add file to List");
		removeFile = new JButton("Remove File from List"); 
		Start = new JButton("Start LetterWordCounter"); 
		
		addFile.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFileChooser object = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt","text");
				object.setFileFilter(filter);
				int returnVal = object.showOpenDialog(addFile); 
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		        	  files.add(object.getSelectedFile());
				
			         for(int i = 0; i < files.size(); i ++) {
			        	 labels[i] = new JLabel(files.get(i).getAbsolutePath());
			        	 filePanel.add(labels[i]); 
			        	 filePanel.validate();
			        	
			        	 
			        	
			      }
				}
			}
		});
		
		removeFile.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				files.remove(files.size());
				for (int i = 0; i < labels.length; i++) {
		        	 labels[i] = new JLabel(); 
		        	 for(JLabel label: labels) {
		        		 System.out.println(label.getText()); 
		        	 }
		        	 
		         }
			}
		});
		buttonPanel.add(addFile);
		buttonPanel.add(removeFile);
		buttonPanel.add(Start);
		
		add(buttonPanel);
		add(filePanel);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		setVisible(true); 
		setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(600, 200);
		pack(); 
		
	}

	
	public static void main(String[] args) {
		ThreadFrame multi = new ThreadFrame(); 
		
	
	}

}
