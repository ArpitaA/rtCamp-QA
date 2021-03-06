import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class Registration_ExistingUser {
	@Test
	public static void Registration_ExistingUser_main() throws InterruptedException, AWTException {
		WebDriver driver=new FirefoxDriver();
		//for chrome browser
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe path");
		//WebDriver driver=new ChromeDriver();
		driver.get("http://demo.rtcamp.com/rtmedia/");
		Thread.sleep(5000);
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("rtAS_registration_username")).sendKeys("test.sel");//entered already registered user
		driver.findElement(By.id("rtAS_registration_email")).click();
		//wait for error message
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.className("not-available")));
		System.out.println("User Already Exists");
		driver.close();
}
}
