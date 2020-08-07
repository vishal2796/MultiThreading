package threadanimation;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ChangeBgColor extends JFrame implements ActionListener,Runnable {

	Container cp;
	JButton btn1,btn2,btn3,btn4;
	JTextArea ta;
	Thread t1,t2;
	int r=10,g=20,b=30;
	
	/**
	 * 
	 */
	public ChangeBgColor()
	{
		cp=getContentPane();
		cp.setLayout(new FlowLayout());
		
		btn1= new JButton("Start");
		btn2=new JButton("Stop");
		btn3=new JButton("Suspend");
		btn4=new JButton("Resume");
		cp.add(btn1);
		cp.add(btn2);
		cp.add(btn3);
		cp.add(btn4);
		ta= new JTextArea(5,20);
		ta.setForeground(Color.BLUE);
		ta.setFont(new Font("Arial",Font.ITALIC,15));
		cp.add(new JScrollPane(ta));
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		
		setVisible(true);
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1)
		{
			t1=new Thread(this);
			t1.setName("APLHA");
			t1.start();
			
			t2=new Thread(this);
			t2.setName("Bg");
			t2.start();
		}
		if(e.getSource()==btn2)
		{
			t1.stop();t2.stop();
		}
		if(e.getSource()==btn1)
		{
			t1.suspend();t2.suspend();
		}
		if(e.getSource()==btn1)
		{
			t1.resume();t2.resume();
		}
		
	}
	public static void main(String[] args) {
		new ChangeBgColor();
	}
	@Override
	public void run() {
		String name= Thread.currentThread().getName();
		if(name=="ALPHA")
			printAlpha();
		if(name=="Bg")
			changeBgC();
				
	}
	private void changeBgC() {
		while(true)
		{
			r+=10;g+=7;b+=5;
			cp.setBackground(new Color(r%255,g%255,b%255));
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	private void printAlpha() {
		for(int ch=65;ch<90;ch++)
		{
			ta.append(" "+(char)ch);
		}
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
