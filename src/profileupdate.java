import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.AWTException;
import org.testng.annotations.Test;
public class profileupdate {
	@Test
	public static void profileupdate_main() throws InterruptedException, AWTException {
		WebDriver driver=new FirefoxDriver();
		//for chrome browser
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe path");
		//WebDriver driver=new ChromeDriver();
		driver.get("http://demo.rtcamp.com/rtmedia/");
		Thread.sleep(5000);
		Login.UserLogin(driver);
		updateprofile(driver);
		driver.close();
	}
	public static void updateprofile(WebDriver driver) throws InterruptedException, AWTException
	{
		driver.findElement(By.linkText("Your Profile")).click();//click on profile link
		Thread.sleep(10000);
		driver.findElement(By.id("first_name")).clear();
		driver.findElement(By.id("first_name")).sendKeys("first name");//enter first name
		driver.findElement(By.id("submit")).click();//click on submit
		//wait until profile is updated
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.className("updated")));
		System.out.println("Profile updated successfully");
	}
}
