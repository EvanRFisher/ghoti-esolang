package commands.basic.movement;

import commands.Instruction;
import state.ProgramState;

public class MOVU implements Instruction {
	/**
	 * Sets the movement of the pointer to up.
	 */
	@Override
	public char getIdentifier(){return '^';}
	@Override
	public void run(ProgramState p) {p.setMovement(0, -1);}

}
