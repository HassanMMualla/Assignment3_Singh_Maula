package reusax_corp;

import java.util.Scanner;

public class IO {
	
	static Scanner msPacman = new Scanner(System.in);
	
	public static String scanLine() {
		String readLine = msPacman.nextLine();
		return readLine;
	}
	
	public static int scanInt() {
		int readInt = msPacman.nextInt();
		msPacman.nextLine();
		return readInt;
	}
	
	public static double scanDouble() {
		double readDouble = msPacman.nextDouble();
		msPacman.nextLine();
		return readDouble;
	}

	public static float scanFloat() {
		float readFloat = msPacman.nextFloat();
		msPacman.nextLine();
		return readFloat;
	}

	public static boolean scanBoolean() {
		boolean readBoolean = msPacman.nextBoolean();
		msPacman.nextLine();
		return readBoolean;
	}

	public static void eatLine() {
		msPacman.nextLine();
	}

	public static byte scanByte() {
		byte readByte = msPacman.nextByte();
		msPacman.nextLine();
		return readByte;
	}
}