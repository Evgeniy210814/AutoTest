package TestForCurse.AutoTest;

import org.apache.log4j.Logger;

public class Calculate {
	private static final Logger logger=Logger.getLogger(Calculate.class);
	public static int sum(int a, int b) throws InterruptedException {
		Thread.sleep(200);
		return a+b;
	}
	public static int div(int a, int b) {
		return a/b;
	}
}
