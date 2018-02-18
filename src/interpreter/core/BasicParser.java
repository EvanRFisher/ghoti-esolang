package interpreter.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import commands.Instruction;
import commands.basic.*;
import commands.basic.IO.*;
import commands.basic.math.*;
import commands.basic.math.stack.*;
import commands.basic.movement.*;
import state.ProgramState;

public class BasicParser implements FileParser {

	@Override
	public ProgramState parseFile(File f) throws IOException, SyntaxException {
		BufferedReader in=new BufferedReader(new FileReader(f));
		in.readLine();
		String size=in.readLine();
		Matcher m=Pattern.compile("([0-9]+) ([0-9]+)").matcher(size.trim());
		if(m.matches()) {
			Instruction[][] program;int xSize,ySize;
			try {
				xSize=Integer.parseInt(m.group(1));
				ySize=Integer.parseInt(m.group(2));
				program=new Instruction[ySize][xSize];
			}
			catch(Exception e) {
				in.close();
				System.out.println(e.getMessage());
				throw new SyntaxException("Invalid Size");
			}
			int row=0;
			String s;
			while((s=in.readLine())!= null) {
				int i=0;
				s=s.toLowerCase();
				if(s.charAt(s.length()-1)=='\n')
					s=s.substring(0, s.length());
				if(s.length()>xSize) {
					in.close();
					throw new SyntaxException("Error on Line "+row+": Line too long. Maximum length: "+xSize+". Line Length: "+s.length());
				}
				if(row>ySize) {
					in.close();
					throw new SyntaxException("Error on Line "+row+": Program too long. Maximum length: "+ySize);
				}
				for(;i<s.length();i++) {
					program[row][i]=evalChar(s.charAt(i));
				}
				for(;i<xSize;i++) {
					program[row][i]=evalChar(' ');
				}
				row++;
			}
			in.close();
			ProgramState p=new ProgramState(program);
			return p;
		}
		else{
			in.close();
			throw new SyntaxException("Missing Size Line");
		}
	}
	private Instruction evalChar(char p) {
		switch(p) {
			/*Value Operator*/
			case '1':case '2':case '3':case '4':
			case '5':case '6':case '7':case '8':
			case '9':case '0':case 'a':case 'b':
			case 'c':case 'd':case 'e':case 'f':
				return new VAL("0123456789abcdef".indexOf(p));
			/*Mathematical Operators*/
			case '+': return new ADD();
			case ',': return new DIV();
			case '-': return new SUB();
			case '*': return new MUL();
			case '%': return new MOD();
			/*Comparison Operators*/
			case '=': return new EQU();
			case '}': return new GTH();
			case '{': return new LTH();
			/*Stack Operators*/
			case '~': return new DUP();
			case '`': return new DEL();
			case '$': return new FLP();
			/*IO Operators*/
			case 'o': return new OUT();
			case 'i': return new INP();
			/*Movement Operators*/
			case '>': return new MOVR();
			case '<': return new MOVL();
			case '^': return new MOVU();
			case 'v': return new MOVD();
			case '/': return new REF1();
			case '\\':return new REF2();
			case '|': return new REFH();
			case '_': return new REFV();
			case '?': return new JUMP();
			case '!': return new LEAP();
			/*NOP Operator*/
			default:  return new NOP();
		}
	}
}
