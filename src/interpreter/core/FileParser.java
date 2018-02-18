package interpreter.core;

import java.io.File;
import java.io.IOException;

import state.ProgramState;

public interface FileParser {
	public ProgramState parseFile(File f) throws IOException,SyntaxException;
	class SyntaxException extends Exception{
		/**
		 * 
		 */
		private static final long serialVersionUID = -8628008781997801905L;

		public SyntaxException(String message) {super(message);}
	}
}
