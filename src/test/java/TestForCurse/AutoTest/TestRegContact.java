package TestForCurse.AutoTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.testng.annotations.Test;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestRegContact {
	public static WebDriver driver;
	public static WebDriverWait wait;
	@Parameters("driver-name")
	@BeforeClass(groups = "log")
	public static void start(String browserType) {
			//System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
			driver=getDriver(browserType);
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 3);
			driver.navigate().to(ParametersTest.url);
	}
	@Test(groups = {"log","add"},priority = 1, dataProvider="myDataForLogin",dataProviderClass = TestDate_2.class)
	public void logIn(String login, String pass) {
		driver.findElement(DataForTest.findFieldLogin).sendKeys(login);
		driver.findElement(DataForTest.findFieldPassword).sendKeys(pass);
	}
	
	@Test(groups = "add",priority = 2)
	public void testRegContatct() throws InterruptedException {
		driver.findElement(DataForTest.findButtonLogin).click();
		driver.findElement(DataForTest.findButtonContact).click();
		driver.switchTo().frame("popup");
		driver.findElement(DataForTest.findFieldName).sendKeys(ParametersTest.nameForReg);
		driver.findElement(DataForTest.findFieldLastName).sendKeys(ParametersTest.lastNameForReg);
		driver.findElement(DataForTest.findButtonSave).click();
		driver.switchTo().defaultContent();
		WebElement exit = wait.until(ExpectedConditions.presenceOfElementLocated(DataForTest.findButtonLogout));
		exit.click();
	}
	@Test(groups = "remove",priority = 3)
	public void testRemoveContatct() throws InterruptedException {
		//driver.navigate().to(Parameters.url);
		driver.findElement(DataForTest.findFieldLogin).clear();
		driver.findElement(DataForTest.findFieldLogin).sendKeys(ParametersTest.email);
		driver.findElement(DataForTest.findFieldPassword).clear();
		driver.findElement(DataForTest.findFieldPassword).sendKeys(ParametersTest.password);
		driver.findElement(DataForTest.findButtonLogin).click();
		findTableReg(DataForTest.findNameContact).click();
		driver.switchTo().frame("popup");
		driver.findElement(DataForTest.findButtonRemove).click();
		driver.switchTo().defaultContent();
		WebElement exit = wait.until(ExpectedConditions.presenceOfElementLocated(DataForTest.findButtonLogout));
		exit.click();
	}
	@Test (priority=4)
	public void findUsers() {
		driver.findElement(DataForTest.findFieldLogin).clear();
		driver.findElement(DataForTest.findFieldLogin).sendKeys(ParametersTest.email);
		driver.findElement(DataForTest.findFieldPassword).clear();
		driver.findElement(DataForTest.findFieldPassword).sendKeys(ParametersTest.password);
		driver.findElement(DataForTest.findButtonLogin).click();
		
		try {
			assertFalse(findTableReg(DataForTest.findNameContact).getText().contains("Evgeniy"));
		}
		catch(Exception e) {
			System.out.println(e);
		}
		WebElement exit = wait.until(ExpectedConditions.presenceOfElementLocated(DataForTest.findButtonLogout));
		exit.click();
	}
	@AfterClass(groups = "log")
	public static void close(){
		driver.close();
	}
	public static WebDriver getDriver(String browserType) {
		 WebDriver driver = null;
		 if(browserType.equals("chrome")) {
			 System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
			 driver = new ChromeDriver();
		 }
		 return driver;
	}
	public WebElement findTableReg(By elem){
		WebElement foundElement;
			List<WebElement> tbody = new ArrayList<WebElement>();
			tbody = driver.findElements(elem);
		for (int i = 0; i <tbody.size() ; i++) {
			if (tbody.get(i).getText().contains("Evgeniy")) {
				return foundElement=tbody.get(i);
			}
		}
		return null;
	}
}
