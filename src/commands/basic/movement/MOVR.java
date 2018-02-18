package commands.basic.movement;

import commands.Instruction;
import state.ProgramState;

public class MOVR implements Instruction {
	/**
	 * Sets the movement of the pointer to right.
	 */
	@Override
	public char getIdentifier(){return '>';}
	@Override
	public void run(ProgramState p) {p.setMovement(1, 0);}

}
