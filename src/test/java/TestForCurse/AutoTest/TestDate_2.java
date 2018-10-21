package TestForCurse.AutoTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.sun.org.apache.bcel.internal.classfile.Field;

public class TestDate_2 {
	@DataProvider
	public static Iterator<Object[]> myDataForLogin() {
		List<Object[]> list = new ArrayList<Object[]>();
		File file =new File("TestData.txt");		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String s = br.readLine();
			while(s!=null) {
				String[] str =s.split(",");
				list.add(new Object[]{str[0],str[1]});
				s=br.readLine();
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list.iterator();
		
	}
}
