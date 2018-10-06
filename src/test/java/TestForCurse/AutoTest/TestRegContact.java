package TestForCurse.AutoTest;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestRegContact {
	public static WebDriver driver;
	public static WebDriverWait wait;
	@BeforeClass
	public static void start() {
			//System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 3);
			driver.navigate().to(Parameters.url);
	}
	@Test
	public void testRegContatct() throws InterruptedException {

		driver.findElement(DataForTest.findFieldLogin).sendKeys(Parameters.email);
		driver.findElement(DataForTest.findFieldPassword).sendKeys(Parameters.password);
		driver.findElement(DataForTest.findButtonLogin).click();
		driver.findElement(DataForTest.findButtonContact).click();
		driver.switchTo().frame("popup");
		driver.findElement(DataForTest.findFieldName).sendKeys(Parameters.nameForReg);
		driver.findElement(DataForTest.findFieldLastName).sendKeys(Parameters.lastNameForReg);
		driver.findElement(DataForTest.findButtonSave).click();
		driver.switchTo().defaultContent();
		WebElement exit = wait.until(ExpectedConditions.presenceOfElementLocated(DataForTest.findButtonLogout));
		exit.click();
	}
	@Test
	public void testRemoveContatct() throws InterruptedException {
		driver.navigate().to(Parameters.url);
		driver.findElement(DataForTest.findFieldLogin).clear();
		driver.findElement(DataForTest.findFieldLogin).sendKeys(Parameters.email);
		driver.findElement(DataForTest.findFieldPassword).clear();
		driver.findElement(DataForTest.findFieldPassword).sendKeys(Parameters.password);
		driver.findElement(DataForTest.findButtonLogin).click();
		driver.findElement(By.id("R0")).click();
		driver.switchTo().frame("popup");
		driver.findElement(DataForTest.findButtonRemove).click();
		driver.switchTo().defaultContent();
		WebElement exit = wait.until(ExpectedConditions.presenceOfElementLocated(DataForTest.findButtonLogout));
		exit.click();
	}
	@AfterClass
	public static void close(){
		driver.close();
	}
	public String findTableReg(By elem){
			List<WebElement> form = new ArrayList<WebElement>();
			List<WebElement> tbody = new ArrayList<WebElement>();
			tbody = driver.findElements(elem);
			List<WebElement> tr = new ArrayList<WebElement>();
			List<WebElement> name = new ArrayList<WebElement>();
			System.out.println(form.size());
			for (int i = 0; i <form.size() ; i++) {
				tr = form.get(i).findElements(By.xpath(".//tr/td"));
				for (int j = 0; j <tr.size() ; j++) {
					name = tr.get(j).findElements(By.xpath("/strong"));
					for (int k = 0; k <name.size() ; k++) {
						if(name.get(k).getText().contains("Evgeniy")) {
							return name.get(k).getText().toString();
						}
						else {
							return "Not found";
						}
					}
				}
			}
			return "Not found";
	}
}
