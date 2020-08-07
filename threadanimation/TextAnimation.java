package threadanimation;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextAnimation extends JFrame implements ActionListener, Runnable{
	Container cp;
	JButton btn1,btn2,btn3,btn4;
	Thread t1,t2;
	int x1=20,y1=150,x2=800,y2=250;
	
	public TextAnimation()
	{
		cp=getContentPane();
		cp.setLayout(new FlowLayout());
		
		btn1= new JButton("Start");
		btn2= new JButton("Stop");
		btn3= new JButton("Suspend");
		btn4= new JButton("Resume");
		cp.add(btn1);
		cp.add(btn2);
		cp.add(btn3);
		cp.add(btn4);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		
		setVisible(true);
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new TextAnimation();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			t1= new Thread(this);
			t1.setName("HELLO");
			t1.start();
			
			t2=new Thread(this);
			t2.setName("HI");
			t2.start();
	 }
		if(e.getSource()==btn2) {
					t1.stop();	t2.stop();
			 }
			 	if(e.getSource()==btn3) {
			 		t1.suspend(); t2.suspend();
			 	}
			 	if(e.getSource()==btn4) {
			 		t1.resume();t2.resume();	
			 	}
	}
	@Override
	public void run() {
		String name= Thread.currentThread().getName();
		if(name=="HELLO")
			startHello();
		if(name=="HI")
			startHi();
		
	}
	private void startHi() {
		while(true) {
		x2-=5;
		repaint();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
	private void startHello() {
		while(true) {
		x1+=5;
		repaint();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.CYAN);
		g.setFont(new Font("Monotype Corsiva",Font.BOLD,25));
		g.drawString("Hello", x1, y1);
		g.setColor(Color.red);
		g.drawString("Hi", x2, y2);
	}
}