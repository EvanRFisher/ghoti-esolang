package commands.basic.math;

import java.util.Deque;

import commands.Instruction;
import state.ProgramState;

public class MOD implements Instruction {
	/**
	 * Pops X and Y from the stack, then pushes X%Y. Exits program if stack has less than 2 values or Y is 0.
	 */
	@Override
	public char getIdentifier(){return '%';}
	@Override
	public void run(ProgramState p) {
		Deque<Integer> d=p.getStack();
		if(d.size()>=2) {
			int X=d.pop(),Y=d.pop();
			if(Y==0)
				p.setDone(true);
			else
				d.push(X%Y);
		}
		else
			p.setDone(true);
	}

}
