package commands.basic;

import commands.Instruction;
import state.ProgramState;

public class NOP implements Instruction {
	/**
	 * An NOP is a command that does nothing. These will not modify the program state when run.
	 */
	@Override
	public char getIdentifier(){return ' ';}
	@Override
	public void run(ProgramState p) {}

}
