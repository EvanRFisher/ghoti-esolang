package commands.basic.IO;

import commands.Instruction;
import state.ProgramState;

public class OUT implements Instruction {
	/**
	 * Pops the top value and exports it as an ASCII character value. ends the program if the stack is empty.
	 */
	@Override
	public char getIdentifier() {
		return 'o';
	}

	@Override
	public void run(ProgramState p) {
		if(p.getStack().size()>0) {
			int val=(p.getStack().pop());
			System.out.print((char)val);
		}
		else
			p.setDone(true);
	}

}
