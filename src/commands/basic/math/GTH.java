package commands.basic.math;

import java.util.Deque;

import commands.Instruction;
import state.ProgramState;

public class GTH implements Instruction {
	/**
	 * Pops X and Y from the stack, then pushes 1 if X>Y and 0 if X<=Y. Exits program if stack has less than 2 values.
	 */
	@Override
	public char getIdentifier(){return '}';}
	@Override
	public void run(ProgramState p) {
		Deque<Integer> d=p.getStack();
		if(d.size()>=2) {
			int X=d.pop(),Y=d.pop();
			d.push(X>Y?1:0);
		}
		else
			p.setDone(true);
	}

}
