package commands.basic.movement;

import commands.Instruction;
import state.ProgramState;

public class REFV implements Instruction {
	/**
	 * Reflects the vertical movement of the pointer
	 */
	@Override
	public char getIdentifier(){return '_';}
	@Override
	public void run(ProgramState p) {int[] a=p.getMovement();p.setMovement( a[0],  -a[1]);}
}
