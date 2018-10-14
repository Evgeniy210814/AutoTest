package TestForCurse.AutoTest;

import java.security.PrivilegedAction;

import org.apache.log4j.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class TestRunner {
	private static final Logger logger=Logger.getLogger(TestRunner.class);
	/*public static void main(String[] args) {
		
		Result result = JUnitCore.runClasses(TestUnitCalculateClass.class);
		for(Failure failure:result.getFailures()){
			logger.error(failure.toString());
			//System.out.println(failure.toString());
		}
		logger.debug("a");
		result.wasSuccessful();
		result.getRunCount();

	}*/

}
