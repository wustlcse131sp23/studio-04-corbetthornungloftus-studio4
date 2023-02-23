package studio4;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File


		String shape = in.next();
		int red = in.nextInt();
		int blue = in.nextInt();
		int green = in.nextInt();
		boolean isFilled = in.nextBoolean();




		//draw
		if (shape.equals("rectangle")) {
			StdDraw.setPenColor(red, blue, green);
			double x = in.nextDouble();
			double y = in.nextDouble();
			double halfWidth = in.nextDouble();
			double halfLength = in.nextDouble();
			StdDraw.filledRectangle(x, y, halfWidth, halfLength);
		} else if (shape.equals("ellipse")) {
			StdDraw.setPenColor(red, blue, green);
			double x = in.nextDouble();
			double y = in.nextDouble();
			double halfWidth = in.nextDouble();
			double halfLength = in.nextDouble();
			if (isFilled) {
				StdDraw.filledEllipse(x, y, halfWidth, halfLength);
			} else {
				StdDraw.ellipse(x, y, halfWidth, halfLength);
			}
		} else if (shape.equals("triangle")) {
			double x1 = in.nextDouble();
			double y1 = in.nextDouble();
			double x2 = in.nextDouble();
			double y2 = in.nextDouble();
			double x3 = in.nextDouble();
			double y3 = in.nextDouble();

			double [] xValues = {x1, x2, x3};
			double [] yValues = {y1, y2, y3};

			StdDraw.setPenColor(red, blue, green);
			if (isFilled) {
				StdDraw.filledPolygon(xValues, yValues);
			} else {
				StdDraw.polygon(xValues, yValues);
			}
		}
	}
}
