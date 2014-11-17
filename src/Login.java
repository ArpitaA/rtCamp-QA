import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class Login {
	@Test
	public static void Login_main() throws InterruptedException, AWTException {
		WebDriver driver=new FirefoxDriver();
		//for chrome browser
		/*System.setProperty("webdriver.chrome.driver", "chromedriver.exe path");
		WebDriver driver=new ChromeDriver();*/
		driver.get("http://demo.rtcamp.com/rtmedia/");
		Thread.sleep(5000);
		UserLogin(driver);
		System.out.println("User logged-in successfully");
		driver.close();
}
	public static void UserLogin(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.cssSelector(".rtp-login.button.tiny")).click();//click on login button
		Thread.sleep(5000);
		driver.findElement(By.id("bp-login-widget-user-login")).sendKeys("test.sel");//enter username 
		driver.findElement(By.id("bp-login-widget-user-pass")).sendKeys("testsel");//enter password
		driver.findElement(By.id("bp-login-widget-submit")).click();//click on submit
		//wait until username is displayed on page
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.rtp-current-user-avatar.dropdown[title='test-sel']")));
	}
}
