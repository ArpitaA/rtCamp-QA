import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.AWTException;
public class profileupdate {
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver=new FirefoxDriver();
		//for chrome browser
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe path");
		//WebDriver driver=new ChromeDriver();
		driver.get("http://demo.rtcamp.com/rtmedia/");
		Thread.sleep(5000);
		Login(driver);
		updateprofile(driver);
	}
	public static void Login(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.cssSelector(".rtp-login.button.tiny")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("bp-login-widget-user-login")).sendKeys("test.sel");
		driver.findElement(By.id("bp-login-widget-user-pass")).sendKeys("testsel");
		driver.findElement(By.id("bp-login-widget-submit")).click();
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.rtp-current-user-avatar.dropdown[title='test-sel']")));
		System.out.println("User logged-in successfully");
	}
	public static void updateprofile(WebDriver driver) throws InterruptedException, AWTException
	{
		driver.findElement(By.linkText("Your Profile")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("first_name")).clear();
		driver.findElement(By.id("first_name")).sendKeys("first name");
		driver.findElement(By.id("submit")).click();
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.className("updated")));
		System.out.println("Profile updated successfully");
	}
}
