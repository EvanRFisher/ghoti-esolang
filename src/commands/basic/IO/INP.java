package commands.basic.IO;

import java.util.Scanner;

import commands.Instruction;
import state.ProgramState;

public class INP implements Instruction {
	/**
	 * Waits for user input, then pushes one character on the stack.
	 */
	static Scanner s=new Scanner(System.in);
	static String buffer="";
	static int bufferpos=0;
	@Override
	public char getIdentifier() {
		return 'o';
	}

	@Override
	public void run(ProgramState p) {
		while(bufferpos>=buffer.length()) {
			buffer=s.nextLine();
			bufferpos=0;
		}
		p.getStack().push((int) buffer.charAt(bufferpos++));
	}

}
