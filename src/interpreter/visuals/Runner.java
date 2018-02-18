package interpreter.visuals;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import interpreter.core.BasicParser;
import interpreter.core.FileParser.SyntaxException;

public class Runner extends JFrame {

	public static void main(String[] args) {
		File progFile=new File("C:\\Users\\EvanLaptop\\Desktop\\progFinal.txt");/*
		do {
			progFile=new File(JOptionPane.showInputDialog("Input the filepath of the program:"));
		}while(!(progFile.exists()&&progFile.isFile()));
		*/
		File imageFile=new File("C:\\Users\\EvanLaptop\\Desktop\\ShifticImages");
		/*do {
			imageFile=new File(JOptionPane.showInputDialog("Input the directory of the tileset:"));
		}while(!(imageFile.exists()&&imageFile.isDirectory()));
		*/
		Runner r=new Runner();
		ProgramPane c=null;
		
		try {
			c = new ProgramPane(progFile.getAbsolutePath(),new BasicVisualTranslator(imageFile.getAbsolutePath()),new BasicParser());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "File Error:"+e.getMessage());
			e.printStackTrace();
		} catch (SyntaxException e) {
			JOptionPane.showMessageDialog(null, "Syntax Error:"+e.getMessage());
			e.printStackTrace();
		}
		
		r.setSize(c.getPreferredSize());r.add(c);r.setVisible(true);r.setDefaultCloseOperation(EXIT_ON_CLOSE);
		r.repaint();
		ActionListener stepper=new SteppingListener(c,r);
		new Timer(1000, stepper).start();
	}
	
	static class SteppingListener implements ActionListener {
		ProgramPane c;Runner r;
		public SteppingListener(ProgramPane c,Runner r) {this.c=c;this.r=r;}
		public void actionPerformed(ActionEvent arg0) {c.step();r.repaint();}
	}
}
