package commands.basic.movement;

import commands.Instruction;
import state.ProgramState;

public class LEAP implements Instruction {
	/**
	 * Leap over the next command.
	 */
	@Override
	public char getIdentifier(){return '!';}
	@Override
	public void run(ProgramState p) {
		p.setPointerX(p.getPointerX()+p.getMovement()[0]);
		p.setPointerY(p.getPointerY()+p.getMovement()[1]);
	}
}
