package commands.basic;

import commands.Instruction;
import state.ProgramState;

public class VAL implements Instruction {
	/**
	 * Pushes the ASCII value of the character onto the stack.
	 */
	int val;
	public VAL(int i) {this.val=i;}
	@Override
	public char getIdentifier(){return val>15?(char)val:"0123456789abcdef".charAt(val);}
	@Override
	public void run(ProgramState p) {p.getStack().push((int)val);}

}
