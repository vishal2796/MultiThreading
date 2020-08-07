package threadanimation;
import java.awt.*;
import javax.swing.*;

public class practice implements Runnable {
	public void printDigit()
	{
		for(int ch=1;ch<50;ch++)
		{
			System.out.println(" "+ch);
		}
		try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void printAlpha()
	{
		for(int ch=65;ch<90;ch++)
		{
			System.out.println(" "+(char)ch);
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		String name= Thread.currentThread().getName();
		if(name=="ALPHA")
			printAlpha();
		if(name=="DIGIT")
			printDigit();
	}
	
	public static void main(String[] args) {
		Thread t1= new Thread(new practice());
		Thread t2= new Thread(new practice());
		
		t1.setName("ALPHA");
		t2.setName("DIGIT");
		t1.start();
		t2.start();
	}

}
