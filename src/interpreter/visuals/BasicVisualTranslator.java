package interpreter.visuals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import commands.Instruction;

public class BasicVisualTranslator implements VisualTranslator {
	HashMap<Character,BufferedImage> h;
	
	public BasicVisualTranslator(String path) throws IOException {
		loadImages(path);
	}
	
	@Override
	public BufferedImage getImage(Instruction i) {
		return h.get(i.getIdentifier());
	}

	@Override
	public void loadImages(String directory) throws IOException {
		if(directory.charAt(directory.length()-1)!='\\'||directory.charAt(directory.length()-1)!='/')
			directory=directory+"/";
		h=new HashMap<Character,BufferedImage>();
		String unk="UNK";
		String[] fileNames= {" NOP"  ,"iINP"  ,"oOUT"  ,
							 "+ADD"  ,",DIV"  ,"=EQU"  ,
							 "}GTH"  ,"{LTH"  ,"%MOD"  ,
							 "*MUL"  ,"-SUB"  ,"`DEL"  ,
							 "~DUP"  ,"$FLP"  ,"?JMP" ,
							 "!LEAP" ,"vMOVD" ,"<MOVL" ,
							 ">MOVR" ,"^MOVU" ,"/REF1" ,
							 "\\REF2","|REFH" ,"_REFV"  };
		
		for(int i=0;i<fileNames.length;i++) {
			String fn=fileNames[i].substring(1, fileNames[i].length());
			if(new File(directory+fn+".png").exists())
				h.put(fileNames[i].charAt(0), ImageIO.read(new File(directory+fn+".png")));
			else
				h.put(fileNames[i].charAt(0), ImageIO.read(new File(directory+unk+".png")));
		}
		fileNames=getVals();
		for(int i=0;i<fileNames.length;i++) {
			String fn=fileNames[i].substring(1, fileNames[i].length());
			if(new File(directory+fn+".png").exists())
				h.put(fileNames[i].charAt(0), ImageIO.read(new File(directory+fn+".png")));
			else
				h.put(fileNames[i].charAt(0), ImageIO.read(new File(directory+unk+".png")));
		}
	}
	String[] getVals() {
		String[] out= new String[16];
		for(int i=0;i<16;i++)
			out[i]="0123456789abcdef".charAt(i)+"VAL"+i;
		return out;
	}
}
