package TestForCurse.AutoTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

public class TestData {
	@DataProvider
	public static Iterator<Object[]> myDataForLogin() {
		List<Object[]> list = new ArrayList<Object[]>();
		list.add(new Object[]{"EVGENIY@tut.by","123456"});
		
		
		return list.iterator();
		
	}
}
