package nju.edu.lc3.simulator.gui;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;


public class SetValueView extends JFrame{
	JLabel description;
	
	JLabel location;
	JTextField loca;
	
	JLabel value;
	JTextField val;
	
	String destination;
	
	JButton ok;
	JButton apply;
	JButton cancel;
	
	
	private static SetValueView unique=null;
	class   MyDocument     extends   PlainDocument   {   
		int   maxLen   =   20;   
		public   MyDocument(int   maxLen){   
			this.maxLen   =   maxLen;   
		}   
		public   void   insertString(int   offset
				,   String   s,   javax.swing.text.AttributeSet   attributeSet)
		throws   javax.swing.text.BadLocationException   {   
		        //   �жϳ���   
			String   strLastText   =   super.getText(0,super.getLength());			
		   	if(strLastText.length() >= maxLen)return   ;
		   	if(s.length()+   strLastText.length()   >maxLen)return;
		   	super.insertString(offset, s, attributeSet);
		}
	}
	
	private SetValueView(){
		this.setResizable(false);
		this.setSize(280,250);
		
		this.setTitle("Set Value");
		
		initialize();
		this.setVisible(true);
	}
	
	public static SetValueView getInstance(){
		if(unique==null){
			unique=new SetValueView();
		}
		return unique;
	}
	
	private void initialize(){

		int pos=2;
		Container cp=this.getContentPane();
		cp.setLayout(null);
		description=new JLabel("Enter the location and the new value for it.");
		
		cp.add(description);
		description.setBounds(0,pos,300,50);
		
		pos+=50;
		
		location=new JLabel("Location:");
		cp.add(location);
		location.setBounds(5, pos, 100, 50);
		
		loca=new JTextField(10);
		loca.setDocument(new MyDocument(10));
		cp.add(loca);
		loca.setBounds(100,pos+15,100,20);
		
		pos+=50;
		
		value=new JLabel("Value:");
		cp.add(value);
		value.setBounds(5, pos, 100, 50);
		
		val=new JTextField(10);
		cp.add(val);
		val.setDocument(new MyDocument(10));
		val.setBounds(100, pos+15, 100, 20);
		
		ok=new JButton("OK");
		apply=new JButton("apply");
		cancel=new JButton("Cancel");
		
		cp.add(ok);
		cp.add(apply);
		cp.add(cancel);
		
		ok.setBackground(Color.gray);
		cancel.setBackground(Color.gray);
		apply.setBackground(Color.gray);
		
		pos+=50;
		ok.setBounds(5, pos, 80, 30);
		
		cancel.setBounds(90, pos, 80, 30);
		apply.setBounds(175, pos, 80, 30);
		
		ok.addActionListener(new OK());
		cancel.addActionListener(new Cancel());
		apply.addActionListener(new Apply());
	}
	
	public void setDestination(String des){
		destination=des;
		loca.setText(des);
	}
	public void setValue(String value){
		
	}
	private void closeWindow(){
		this.setVisible(false);
	}
	
	class Cancel implements ActionListener{
		public void actionPerformed(ActionEvent e){
			closeWindow();
		}
	}
	class OK implements ActionListener{
		public void actionPerformed(ActionEvent e){
			closeWindow();
		}
	}
	class Apply implements ActionListener{
		public void actionPerformed(ActionEvent e){
			closeWindow();
		}
	}
	
	protected void processWindowEvent(WindowEvent e){
		if(e.getID()==WindowEvent.WINDOW_CLOSING){
			this.setVisible(false);
		}
		else if(e.getID()==WindowEvent.WINDOW_CLOSED){
			this.setVisible(false);
		}
	}
}
