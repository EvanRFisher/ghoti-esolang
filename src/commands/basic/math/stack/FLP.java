package commands.basic.math.stack;

import java.util.ArrayDeque;
import java.util.Deque;

import commands.Instruction;
import state.ProgramState;

public class FLP implements Instruction {
	/**
	 * Pops the top value on the stack as N. Then flips the top N values of the stack. End the program if the stack is empty.
	 */
	@Override
	public char getIdentifier(){return '$';}
	@Override
	public void run(ProgramState p) {
		Deque<Integer> d=p.getStack();
		if(d.size()>0) {
			int n=d.pop();
			Deque<Integer> s=new ArrayDeque<Integer>();
			for(int i=0;i<n&&d.size()>0;i++)
				s.add(d.pop());
			while(s.size()>0)d.push(s.remove());
		}
		else
			p.setDone(true);
	}

}