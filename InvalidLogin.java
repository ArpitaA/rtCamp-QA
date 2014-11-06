import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class InvalidLogin {
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver=new FirefoxDriver();
		//for chrome browser
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe path");
		//WebDriver driver=new ChromeDriver();
		driver.get("http://demo.rtcamp.com/rtmedia/");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".rtp-login.button.tiny")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("bp-login-widget-user-login")).sendKeys("invalid user");
		driver.findElement(By.id("bp-login-widget-user-pass")).sendKeys("invalid pass");
		driver.findElement(By.id("bp-login-widget-submit")).click();
		new WebDriverWait(driver, 60).until(ExpectedConditions.textToBePresentInElement(By.id("login_error"),": Invalid username. "));
		System.out.println("User not logged-in");
	}
}
