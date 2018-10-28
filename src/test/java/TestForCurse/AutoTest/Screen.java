package TestForCurse.AutoTest;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Screen {
	public static void screenshot (WebDriver driver) throws IOException {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String name = "D:\\For Curse AutoTest\\Screen\\"+(new Date()).getTime()+".png";
		FileUtils.copyFile(file, new File(name));
		Reporter .log("ScreenFile"+name);
	}

}
