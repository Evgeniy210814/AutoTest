package TestForCurse.AutoTest;

public class Calculate {
	
	public static int sum(int a, int b) throws InterruptedException {
		Thread.sleep(200);
		return a+b;
	}
	public static int div(int a, int b) {
		return a/b;
	}
}
