package TestForCurse.AutoTest;


import org.openqa.selenium.By;

public class DataForTest {
    public static By findFieldLogin=By.xpath("//input[@name='LEmail']");
    public static By findFieldPassword=By.xpath("//input[@name='LPassword']");
    public static By findButtonLogin=By.xpath("//input[@value='Login']");
    public static By findButtonContact=By.xpath("//table//td[@class='s9']//a[3]//img[1]");
    public static By findFieldName=By.xpath("/html[1]/body[1]/form[1]/table[1]/tbody[1]/tr[2]/td[2]/input[1]");
    public static By findFieldLastName =By.xpath("/html[1]/body[1]/form[1]/table[1]/tbody[1]/tr[2]/td[2]/input[2]");
    public static By findButtonSave = By.xpath("/html[1]/body[1]/form[1]/table[1]/tbody[1]/tr[1]/td[2]/input[2]");
    public static By findButtonLogout=By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[3]/a[12]/img[1]");
    public static By findButtonRemove = By.xpath("/html[1]/body[1]/form[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]");
    public static By findNameContact = By.xpath("//form[@name='THEFORM']/table/tbody/tr");
}
