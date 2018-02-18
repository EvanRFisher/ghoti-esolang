package commands.basic.movement;

import commands.Instruction;
import state.ProgramState;

public class JUMP implements Instruction {
	/**
	 * Pops the top value of the stack. If it is non 0, leap over the next command. If the stack is empty, exits the program.
	 */
	@Override
	public char getIdentifier(){return '?';}
	@Override
	public void run(ProgramState p) {
		if(p.getStack().size()>0) {
			if(p.getStack().pop()!=0) {
				p.setPointerX(p.getPointerX()+p.getMovement()[0]);
				p.setPointerY(p.getPointerY()+p.getMovement()[1]);
			}
		}
		else
			p.setDone(true);
	}
}
