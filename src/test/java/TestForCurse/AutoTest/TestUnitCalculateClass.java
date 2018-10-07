package TestForCurse.AutoTest;

import static org.junit.Assert.assertEquals;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestUnitCalculateClass {
	int a, b,expected;
	
	public TestUnitCalculateClass(int a, int b, int expected) {
		this.a = a;
		this.b = b;
		this.expected = expected;
	}
	//@Rule
	//public TestRule timeOut =new Timeout(100,TimeUnit.MILLISECONDS);
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	@Test//(timeout=100)
	public void testSum() throws InterruptedException {		
		int actual=Calculate.sum(a, b);
		assertEquals(expected, actual);
	}
	@Test
	public void testDiv() {		
		int c =3;		
		//thrown.expect(ArithmeticException.class);
		thrown.expectMessage("/ by zero");
		int actual = Calculate.div(a, 0);
		assertEquals(expected, actual);
	}
	@Parameterized.Parameters (name ="{index}:a= {0},b= {1},expres= {2}")
	public static Collection numbers () {
		return Arrays.asList(new Object[][] {{1,2,3},{4,5,9},{4,2,6}});
		};
}
