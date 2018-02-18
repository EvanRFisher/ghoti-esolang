package interpreter.visuals;

import java.awt.image.BufferedImage;
import java.io.IOException;

import commands.Instruction;

public interface VisualTranslator {
	public BufferedImage getImage(Instruction i);
	void loadImages(String directory) throws IOException;
}
