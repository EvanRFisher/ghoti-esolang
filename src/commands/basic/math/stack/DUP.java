package commands.basic.math.stack;

import java.util.Deque;

import commands.Instruction;
import state.ProgramState;

public class DUP implements Instruction {
	/**
	 * Pushes a copy of the topmost element on the stack onto the stack. Ends the program if the stack is empty.
	 */
	@Override
	public char getIdentifier(){return '~';}
	@Override
	public void run(ProgramState p) {
		Deque<Integer> d=p.getStack();
		if(d.size()>0) {
			d.push(d.peek());
		}
		else
			p.setDone(true);
	}

}
