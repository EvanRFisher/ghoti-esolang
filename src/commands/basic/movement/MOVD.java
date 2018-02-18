package commands.basic.movement;

import commands.Instruction;
import state.ProgramState;

public class MOVD implements Instruction {
	/**
	 * Sets the movement of the pointer to down.
	 */
	@Override
	public char getIdentifier(){return 'v';}
	@Override
	public void run(ProgramState p) {p.setMovement(0, 1);}

}
