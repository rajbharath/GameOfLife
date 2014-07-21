
import java.util.Scanner;

public class IOWrapper {
	private static final Scanner s = new Scanner(System.in);

	public static void print(String s) {
		System.out.print(s);
	}

	public static void println(String s) {
		System.out.println(s);
	}

	public static char read() {
		return s.next().split(" ")[0].charAt(0);
	}

	public static int readInt() {
		return s.nextInt();
	}

	public static String readLine() {
		return s.next();
	}
}
