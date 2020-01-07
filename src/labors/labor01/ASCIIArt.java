package labors.labor01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author LeeKrane
 */

public class ASCIIArt {
	
	public static void main (String[] args) {
		String resourcePath = "res/labors/labor01/";
		checkFile(resourcePath + "bild1.ascii");
		checkFile(resourcePath + "bild2.ascii");
		checkFile(resourcePath + "bild3.ascii");
	}
	
	private static void checkFile (String filePath) {
		Scanner fromFile;
		try {
			fromFile = new Scanner(new File(filePath));
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + filePath);
			return;
		}
		String line = fromFile.nextLine();
		int height = 1, width = line.length();
		while (fromFile.hasNextLine()) {
			line = fromFile.nextLine();
			if (width != line.length()) {
				System.err.println(filePath + " Exception");
				return;
			}
			height++;
		}
		System.out.println(filePath + " ok " + width + " " + height);
	}
}
