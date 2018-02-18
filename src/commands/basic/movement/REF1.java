package commands.basic.movement;

import commands.Instruction;
import state.ProgramState;

public class REF1 implements Instruction {
	/**
	 * Reflects movement of the pointer over the / mirror
	 */
	@Override
	public char getIdentifier(){return '/';}
	@Override
	public void run(ProgramState p) {int[] a=p.getMovement();p.setMovement(-a[1], -a[0]);}
}
