package state;
import java.util.ArrayDeque;
import java.util.Deque;

import commands.Instruction;

public class ProgramState {
	Instruction[][] program;
	int pointerX,pointerY;
	Deque<Integer> stack;
	int[] movement;
	boolean done=false;
	public ProgramState(Instruction[][] program) {
		this(program,0,0,1,0);
	}
	public ProgramState(Instruction[][] program, int pX,int pY,int dx, int dy) {
		this.program=program;
		pointerX=pX;
		pointerY=pY;
		movement=new int[]{dx,dy};
		stack=new ArrayDeque<Integer>();
	}
	public void step() {
		if(!done) {
			pointerX=(pointerX+movement[0]+program[0].length)%program[0].length;
			pointerY=(pointerY+movement[1]+program   .length)%program   .length;
			program[pointerY][pointerX].run(this);
			/*
			for(int y=0;y<program.length;y++) {
				for(int x=0;x<program[0].length;x++) {
					if(x==pointerX&&y==pointerY)
						System.out.print('@');
					else
					System.out.print(program[y][x].getIdentifier());
						
				}
				System.out.println();
			}
			System.out.println("-----"+stack.size()+"-----");
			*/
			//System.out.println(stack);
			//for(int i=0;i<stack.length;i++)
		}
	}
	public void setPointerX(int newX) 				{pointerX=newX;}
	public void setPointerY(int newY) 				{pointerY=newY;}
	public void setMovement(int dx,int dy) 			{movement[0]=dx;movement[1]=dy;}
	public void setDone(boolean isDone) 			{done=isDone;}
	
	public int   			getPointerX() 			{return pointerX;}
	public int 	 			getPointerY() 			{return pointerY;}
	public int[] 			getMovement() 			{return movement;}
	public boolean  		getDone() 				{return done;}
	public Deque<Integer> 	getStack() 				{return stack;}
	public Instruction[][]  getProgram()			{return program;}
}
