package commands;
import state.ProgramState;

public interface Instruction {
	char getIdentifier();
	void run(ProgramState p);
}
