package interpreter.visuals;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import interpreter.core.FileParser;
import interpreter.core.FileParser.SyntaxException;
import state.ProgramState;

import javax.swing.JPanel;

public class ProgramPane extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2703289544054733837L;
	
	private ProgramState p;
	int pWidth, pHeight;
	VisualTranslator v;
	public ProgramPane(String programDirectory,VisualTranslator v,FileParser p) throws IOException, SyntaxException {
		super();
		this.v=v;
		this.p=p.parseFile(new File(programDirectory));
		pWidth=this.p.getProgram()[0].length;
		pHeight=this.p.getProgram().length;
		if(pWidth<pHeight)
			super.setPreferredSize(new Dimension(500,500*pHeight/pWidth));
		else
			super.setPreferredSize(new Dimension(500*pWidth/pHeight,500));
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2=(Graphics2D)g;
		Dimension d=super.getSize();//new Dimension(500,500);//
		double rectWidth=d.getWidth()/pWidth,rectHeight=d.getHeight()/pHeight;
		for(int x=0;x<pWidth;x++)
			for(int y=0;y<pHeight;y++) {
				BufferedImage b=v.getImage(p.getProgram()[y][x]);
				g2.drawImage(b, (int)(    x*rectWidth),(int)(    y*rectHeight),
						        (int)((x+1)*rectWidth),(int)((y+1)*rectHeight),
						        0                     ,0                      ,
						        b.getWidth()          ,b.getHeight()          ,null);
			}
		g2.setColor(new Color(0,0,0,120));
		g2.fillRect((int)(p.getPointerX()*rectWidth), (int)(p.getPointerY()*rectHeight), (int)rectWidth, (int)rectHeight);
		g2.setColor(new Color(0,0,0,60));
		g2.fillRect((int)((p.getPointerX()+p.getMovement()[0])*rectWidth), (int)((p.getPointerY()+p.getMovement()[1])*rectHeight),
				    (int)rectWidth,                                        (int)rectHeight);
		//g2.drawLine((int)((p.getPointerX()+.5)*rectWidth), (int)((p.getPointerY()+.5)*rectHeight), (int)((p.getPointerX()+p.getMovement()[0]+.5)*rectWidth), (int)((p.getPointerY()+p.getMovement()[1]+.5)*rectHeight));
		g2.setColor(Color.BLACK);
		g2.drawString(p.getStack().toString(), 0, 10);
	}
	public void step() {
		p.step();
	}
}
