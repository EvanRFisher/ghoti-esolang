package commands.basic.movement;

import commands.Instruction;
import state.ProgramState;

public class REFH implements Instruction {
	/**
	 * Reflects the horizontal movement of the pointer.
	 */
	@Override
	public char getIdentifier(){return '|';}
	@Override
	public void run(ProgramState p) {int[] a=p.getMovement();p.setMovement(-a[0], a[1]);}
}
